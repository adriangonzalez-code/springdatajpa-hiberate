package com.smoothiemx.springdatajpa.hibernate.inheritance;

import com.smoothiemx.springdatajpa.hibernate.inheritance.entities.Check;
import com.smoothiemx.springdatajpa.hibernate.inheritance.entities.CreditCard;
import com.smoothiemx.springdatajpa.hibernate.inheritance.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateInheritanceApplicationTests {

    @Autowired
    PaymentRepository repository;

    @Test
    void createPayment() {
        CreditCard cc = new CreditCard();
        cc.setId(123);
        cc.setAmount(1000);
        cc.setCardnumber("1234568790");
        repository.save(cc);
    }

    @Test
    void createCheckPayment() {
        Check ch = new Check();
        ch.setId(124);
        ch.setAmount(2000);
        ch.setChecknumber("9876543210");
        repository.save(ch);
    }
}