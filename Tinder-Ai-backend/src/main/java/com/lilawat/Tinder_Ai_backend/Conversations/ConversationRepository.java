package com.lilawat.Tinder_Ai_backend.Conversations;

import org.springframework.data.mongodb.repository.MongoRepository;

// MongoRepository is a spring data interface that provides crud operations
public interface ConversationRepository extends MongoRepository<Conversation, String> {

}
