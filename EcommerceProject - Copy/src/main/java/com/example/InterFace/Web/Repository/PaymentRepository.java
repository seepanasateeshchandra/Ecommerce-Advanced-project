package com.example.InterFace.Web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.InterFace.Web.Entity.Order;
import com.example.InterFace.Web.Entity.Payment;
import com.example.InterFace.Web.Entity.UserDetails;

import java.math.BigDecimal;
import java.util.Optional;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	Optional<Payment> findByOrderId(Long orderId);
  
	@Query(value = "select sum(p.amount) from Payment p where p.status = 'SUCCESS'",nativeQuery = false)
	BigDecimal getTotalRevenue();

	Optional<Payment> findTopByUserOrderByPaymentDateDesc(UserDetails user);
	
	
}
