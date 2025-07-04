package com.example.InterFace.Web.Service;

import com.example.InterFace.Web.RequestDTO.PaymentDto;
import com.example.InterFace.Web.RequestDTO.PaymentRequest;

public interface PaymentService{
	
	PaymentDto MakePayment(PaymentRequest request);
	
	PaymentDto getPaymentByOrderId(Long orderId);

}
