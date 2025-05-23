package com.lilawat.Tinder_Ai_backend.Conversations;


import com.lilawat.Tinder_Ai_backend.profiles.ProfileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController //this annotation is used to create a RESTful web service
// this class is used to handle the conversation requests
public class ConversationController {

//     this is used to inject the conversation repository bean
    private final ConversationRepository conversationRepository;
    private final ProfileRepository profileRepository;

//    constructor -> this is used to create a new conversation controller
    public ConversationController(ConversationRepository conversationRepository, ProfileRepository profileRepository) {
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
    }

    @PostMapping("/conversations") // this annotation is used to create a new conversation
//    postmapping -> @PostMapping is a Spring annotation used to map HTTP POST requests onto specific
//    handler methods. In your code, it is used to define an endpoint that will
//    handle POST requests for creating a new conversation.
//    You can specify the URL path in the annotation, for example:

//    @PostMapping("/conversations") will handle post requests to the /coversations endpoint.
//    @RequestBody -> is a spring annotation that indicates that a method parameter should be bound to the body of the web request.
    public Conversation createNewConversation(@RequestBody CreateConversationRequest request){
        profileRepository.findById(request.profileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                request.profileId(),
              new ArrayList<>()
        );
        conversationRepository.save(conversation);
        return conversation;
    }

//    createconversationrequest -> this is a record that is used to create a new conversation
    public record CreateConversationRequest(
            String profileId
    ) {

    }

}
