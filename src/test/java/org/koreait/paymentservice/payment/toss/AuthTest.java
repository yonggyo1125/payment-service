package org.koreait.paymentservice.payment.toss;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Base64;

@SpringBootTest
@ActiveProfiles({"default", "test"})
//@EnableConfigurationProperties(TossProperties.class)
public class AuthTest {
    @Autowired
    private RestTemplate restTemplate;


    @Value("${toss.payment_key.secret}")
    private String secretKey;

    @Test
    void test1() {
        String secretEncoded = Base64.getEncoder().encodeToString((secretKey + ":").getBytes());

        // Authorization: Basic {ENCODED_SECRET_KEY}
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(secretEncoded);

        HttpEntity<Void> request = new HttpEntity<>(headers);

        String url = "https://api.tosspayments.com/v1/transactions?startDate=2022-01-01T00:00:00&endDate=2022-01-02T23:59:59";
        ResponseEntity<String> response = restTemplate.exchange(URI.create(url), HttpMethod.GET, request, String.class);
        System.out.println(response.getBody());
    }
}
