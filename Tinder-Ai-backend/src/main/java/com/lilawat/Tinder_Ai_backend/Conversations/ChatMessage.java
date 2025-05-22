package com.lilawat.Tinder_Ai_backend.Conversations;


import java.time.LocalDateTime;

public record ChatMessage(
        String messageText,
        String AuthorId,
        LocalDateTime messageTime


) {

}
