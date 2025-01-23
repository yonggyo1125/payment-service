package org.koreait.paymentservice.payment.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    /**
     * 결제 성공시 유입되는 URL
     *  /success?paymentType={PAYMENT_TYPE}&orderId={ORDER_ID}
     * &paymentKey={PAYMENT_KEY}&amount={AMOUNT}
     */
    @GetMapping("/success")
    public void paymentSuccess(@ModelAttribute RequestPayment data) {

        // 결제 승인 처리


    }

    /**
     * 결제 실패시 유입되는 URL
     * /fail?code={ERROR_CODE}&message={ERROR_MESSAGE}
     * &orderId={ORDER_ID}
     *
     */
    @GetMapping("/fail")
    public void paymentFailure(@ModelAttribute RequestPayment data) {

        // 결제 실패 DB 기록 처리

    }
}
