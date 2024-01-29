package com.bitscoder.websocket.service;

import com.bitscoder.websocket.model.ChatMessage;
import com.bitscoder.websocket.repository.ChatMessageRepository;
import com.bitscoder.websocket.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage saveChat(ChatMessage chatMessage) {
        var chatId = chatRoomService.getChatroomId(
                chatMessage.getSenderId(), chatMessage.getRecipientId(), true)
                .orElseThrow();
        chatMessage.setChatId(chatId);
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId) {
        var chatId = chatRoomService.getChatroomId(senderId, recipientId, false);
        return chatId
                .map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }
}
