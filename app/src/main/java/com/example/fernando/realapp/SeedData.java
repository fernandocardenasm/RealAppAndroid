package com.example.fernando.realapp;

import java.util.Arrays;

/**
 * Created by fernando on 16.10.17.
 */

public class SeedData {

    static Person[] seedData(){
        Person person1 = new Person();
        person1.userId = "1";
        person1.userName = "Claudia";
        person1.imageProfile = "claudia_p";
        person1.imageSelf = "claudia_s";
        person1.imageFriend = "claudia_f";
        person1.listFriends.addAll(Arrays.asList("4", "5", "6"));

        Person person2 = new Person();
        person2.userId = "2";
        person2.userName = "Razan";
        person2.imageProfile = "razan_p";
        person2.imageSelf = "razan_s";
        person2.imageFriend = "razan_f";
        person2.listFriends.addAll(Arrays.asList(""));

        Person person3 = new Person();
        person3.userId = "3";
        person3.userName = "Mihaela";
        person3.imageProfile = "mihaela_p";
        person3.imageSelf = "mihaela_s";
        person3.imageFriend = "mihaela_s";
        person3.listFriends.addAll(Arrays.asList(""));

        Person person4 = new Person();
        person4.userId = "4";
        person4.userName = "Emilio";
        person4.imageProfile = "emilio_p";
        person4.imageSelf = "emilio_s";
        person4.imageFriend = "emilio_f";
        person4.listFriends.addAll(Arrays.asList("1","5","6"));

        Person person5 = new Person();
        person5.userId = "5";
        person5.userName = "Azusena";
        person5.imageProfile = "azu_p";
        person5.imageSelf = "azu_s";
        person5.imageFriend = "azu_f";
        person5.listFriends.addAll(Arrays.asList("1", "4", "6"));

        Person person6 = new Person();
        person6.userId = "6";
        person6.userName = "Sandra";
        person6.imageProfile = "person1_f";
        person6.imageSelf = "sandra_s";
        person6.imageFriend = "sandra_f";
        person6.listFriends.addAll(Arrays.asList("1", "4", "5"));


        Person[] people = {person1, person2, person3, person4, person5, person6};

        return people;

    }

}
