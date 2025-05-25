package com.lilawat.Tinder_Ai_backend.Conversations;


import com.lilawat.Tinder_Ai_backend.profiles.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController //this annotation is used to create a RESTful web service
// this class is used to handle the conversation requests
public class ConversationController {

    private static final Logger log = LoggerFactory.getLogger(ConversationController.class);
    //     this is used to inject the conversation repository bean
    private final ConversationRepository conversationRepository;
    private final ProfileRepository profileRepository;
    private final ConversionService conversionService;

    //    constructor -> this is used to create a new conversation controller
    public ConversationController(ConversationRepository conversationRepository, ProfileRepository profileRepository, ConversionService conversionService) {
        this.conversationRepository = conversationRepository;
        this.profileRepository = profileRepository;
        this.conversionService = conversionService;
    }

    @PostMapping("/conversations") // this annotation is used to create a new conversation
//    postmapping -> @PostMapping is a Spring annotation used to map HTTP POST requests onto specific
//    handler methods. In your code, it is used to define an endpoint that will
//    handle POST requests for creating a new conversation.
//    You can specify the URL path in the annotation, for example:

//    @PostMapping("/conversations") will handle post requests to the /coversations endpoint.
//    @RequestBody -> is a spring annotation that indicates that a method parameter should be bound to the body of the web request.
    public Conversation createNewConversation(@RequestBody CreateConversationRequest request) {
        profileRepository.findById(request.profileId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "unable to find a profile with id : " + request.profileId));

        Conversation conversation = new Conversation(
                UUID.randomUUID().toString(),
                request.profileId(),
                new ArrayList<>()
        );
        conversationRepository.save(conversation);
        return conversation;
    }

//    GetMapping -> is a spring annotation that is used to map http get requests onto specific handler methods.
    @GetMapping("/conversations/{conversationId}")
    public Conversation getConversation(
            @PathVariable String conversationId
    ){
        return conversationRepository.findById(conversationId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Unable to find conversation with id : " + conversationId
                ));
    }

    @PostMapping("/conversations/{conversationId}")
    public Conversation addMessageToConversation(
            @PathVariable String conversationId,
            @RequestBody ChatMessage chatMessage) {
//        @PathVariable -> is a spring annotation that indicates that a method parameter should be bound to a url template variable.
//        @RequestBody -> is a spring annotation that indicates that a method parameter should be bound to the body of the web request.

//        conversation -> this is used to find the conversation by id
        Conversation conversation = conversationRepository.findById(conversationId).
//                orElseThrow -> this is used to throw an exception if the conversation is not found
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Unable to find conversation id : " + conversationId
                ));

//  profileRepository -> this is used to find the profile by id
        profileRepository.findById(chatMessage.AuthorId()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Unable to find profile with id :" + chatMessage.AuthorId()
                ));
//        TODO : Need to validate that the author of a message happens to be only the profile associated with the message user
        ChatMessage messageWithTime = new ChatMessage(
                chatMessage.messageText(),
                chatMessage.AuthorId(),
                LocalDateTime.now()
        );
        conversation.messages().add(messageWithTime);
        conversationRepository.save(conversation);
        return conversation;
    }

    //    createconversationrequest -> this is a record that is used to create a new conversation
    public record CreateConversationRequest(
            String profileId
    ) {

    }

}
