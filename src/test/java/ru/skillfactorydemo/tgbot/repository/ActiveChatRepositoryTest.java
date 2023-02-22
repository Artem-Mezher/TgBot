package ru.skillfactorydemo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.ActiveChat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ActiveChatRepositoryTest {

    @Autowired
    private ActiveChatRepository activeChatRepository;

    @Test
    public void testRepo_found() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(12345L);
        activeChatRepository.save(activeChat);
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(12345L);
        assertTrue(activeChatByChatId.isPresent());
        assertEquals(12345L, activeChatByChatId.get().getChatId());
    }

    @Test
    public void testRepo_notFound() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(12345L);
        activeChatRepository.save(activeChat);
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(54321L);
        assertFalse(activeChatByChatId.isPresent());
    }
}