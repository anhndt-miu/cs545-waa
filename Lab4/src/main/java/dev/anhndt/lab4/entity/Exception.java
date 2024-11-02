package dev.anhndt.lab4.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Exception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;
    private String date;
    private String time;
    private String principle;
    private String operation;
    private String exception_type;
}
