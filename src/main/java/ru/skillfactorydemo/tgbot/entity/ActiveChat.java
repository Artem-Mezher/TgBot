package ru.skillfactorydemo.tgbot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ACTIVE_CHAT")

public class ActiveChat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;
}