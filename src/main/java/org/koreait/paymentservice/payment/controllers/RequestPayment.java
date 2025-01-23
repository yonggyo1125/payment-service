package org.koreait.paymentservice.payment.controllers;

import lombok.Data;
import org.koreait.paymentservice.payment.controllers.constants.PaymentType;

@Data
public class RequestPayment {
    private Long orderId;
    private String customerName; //  주문자 명
    private String customerEmail; // 주문자 이메일
    private String customerMobile; // 주문자 휴대전화번호

    private PaymentType paymentType;
    private String paymentKey;
    private Long amount;
    private String code; // 결제 실패시 에러 코드
    private String message; // 결제 실패시 메세지
}
