package com.lilawat.Tinder_Ai_backend.Conversations;

import com.lilawat.Tinder_Ai_backend.profiles.Profiles;
import org.apache.logging.log4j.message.Message;

import java.util.List;

// this class is used to store the conversations in memory
// it contains the id of the conversation, the id of the profile and the list of messages
public record Conversation(
        String id,
        String profileId,
        List<ChatMessage> messages

) {

}
