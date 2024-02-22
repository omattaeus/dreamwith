package br.com.compilou.apirh.repositories;

import br.com.compilou.apirh.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
