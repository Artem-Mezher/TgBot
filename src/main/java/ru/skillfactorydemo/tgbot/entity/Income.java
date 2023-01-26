package ru.skillfactorydemo.tgbot.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "INCOME")
@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "INCOME")
    private BigDecimal income;
}