package com.lilawat.Tinder_Ai_backend.profiles;

import org.springframework.data.annotation.Id;

public record Profiles(
        @Id //this annotation is used to mark the id field as the primary key
        String id,
        String firstName,
        String lastName,
        int age,
        String ethnicity,
        Gender gender,
        String bio,
        String imageUrl,
        String myerseBriggsPersonalityType

) {


}
