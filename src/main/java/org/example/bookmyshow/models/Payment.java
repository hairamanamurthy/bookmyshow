package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Payment extends BaseModel{
    private double amount;
    private Date date;
    @Enumerated(EnumType.STRING)
    private PaymentGateway paymentGateway;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    private String refNumber;

}
