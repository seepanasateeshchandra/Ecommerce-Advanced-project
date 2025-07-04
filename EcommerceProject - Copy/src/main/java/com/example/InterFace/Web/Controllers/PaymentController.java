package com.example.InterFace.Web.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InterFace.Web.RequestDTO.PaymentDto;
import com.example.InterFace.Web.RequestDTO.PaymentRequest;
import com.example.InterFace.Web.Service.PaymentService;

@RequestMapping("api/payments")
@RestController
public class PaymentController {
	
	
	private PaymentService paymentService;
	
	@PostMapping("/makePayment")
    public ResponseEntity<PaymentDto> makePayment(@RequestBody PaymentRequest request) {
        return ResponseEntity.ok(paymentService.MakePayment(request));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<PaymentDto> getPayment(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.getPaymentByOrderId(orderId));
    }

}
