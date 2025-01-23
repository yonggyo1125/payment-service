package org.koreait.paymentservice.payment.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "toss.payment_key")
public class TossProperties {
    private String client;
    private String secret;
    private String security;
}
