package com.bitscoder.websocket.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatNotification {

    private String chatNotificationId;
    private String senderId;
    private String recipientId;
    private String content;
}
