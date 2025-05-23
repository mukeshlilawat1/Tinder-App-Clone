package com.lilawat.Tinder_Ai_backend;

import com.lilawat.Tinder_Ai_backend.Conversations.ChatMessage;
import com.lilawat.Tinder_Ai_backend.Conversations.Conversation;
import com.lilawat.Tinder_Ai_backend.Conversations.ConversationRepository;
import com.lilawat.Tinder_Ai_backend.profiles.Gender;
import com.lilawat.Tinder_Ai_backend.profiles.ProfileRepository;
import com.lilawat.Tinder_Ai_backend.profiles.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication

//commandlinerunner -> this is used to run the application
public class TinderAiBackendApplication implements CommandLineRunner {

    @Autowired // autowired is used to inject the profile repository bean
    private ProfileRepository profileRepository;

    @Autowired
    private ConversationRepository conversationRepository;

    public static void main(String[] args) {
        SpringApplication.run(TinderAiBackendApplication.class, args);
    }

    //	run -> this method is used to run the application
    public void run(String... args) {

        profileRepository.deleteAll(); // delete all the profiles in the database
        conversationRepository.deleteAll(); //delete all the conversations

//		THIS IS USED TO CREATE A NEW PROFILE IN THE DATABASE
        /* Ye method ek `Profiles` object banata hai, jisme user ki details
         * (jaise id, naam, age, gender, profession,
         * image URL, aur personality type) set ki jaati hain.
         *  Ye object aage database me save karne ke liye use ho sakta hai.
         * */
        Profiles profile = new Profiles(
                "1",
                "Mukesh",
                "lilawat",
                22,
                "Indian",
                Gender.MALE,
                "Software Engineer",
                "https://example.com/image.jpg",
                "INTP"
        );

        profileRepository.save(profile); //save the profile in the database

        Profiles profile2 = new Profiles(
                "2",
                "varun",
                "singh",
                23,
                "Indian",
                Gender.MALE,
                "Software Engineer",
                "https://example.com/image.jpg",
                "INTP"
        );
        profileRepository.save(profile2);

//        this method is used to create a new profile in the database
        profileRepository.findAll().forEach(System.out::println);

        Conversation conversation = new Conversation(
                "1",
                profile.id(),
                List.of(
                        new ChatMessage(
                                "Hello,", profile.id(), LocalDateTime.now()
                        )
                )
        );
        conversationRepository.save(conversation);
        conversationRepository.findAll().forEach(System.out::println);
    }
}
