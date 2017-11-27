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
        person1.listFriends.addAll(Arrays.asList(""));

        Person person2 = new Person();
        person2.userId = "2";
        person2.userName = "Mark";
        person2.imageProfile = "mark_p";
        person2.imageSelf = "mark_s";
        person2.imageFriend = "mark_f";
        person2.listFriends.addAll(Arrays.asList("3"));

        Person person3 = new Person();
        person3.userId = "3";
        person3.userName = "Emilio";
        person3.imageProfile = "emilio_p";
        person3.imageSelf = "emilio_s";
        person3.imageFriend = "emilio_f";
        person3.listFriends.addAll(Arrays.asList("4"));

        Person person4 = new Person();
        person4.userId = "4";
        person4.userName = "Gabriela";
        person4.imageProfile = "gabi_p";
        person4.imageSelf = "gabi_s";
        person4.imageFriend = "gabi_f";
        person4.listFriends.addAll(Arrays.asList("2","3"));

        Person person5 = new Person();
        person5.userId = "5";
        person5.userName = "Djanina";
        person5.imageProfile = "dj_p";
        person5.imageSelf = "dj_s";
        person5.imageFriend = "dj_s";
        person5.listFriends.addAll(Arrays.asList("0"));

        Person person6 = new Person();
        person6.userId = "6";
        person6.userName = "Rana";
        person6.imageProfile = "rana_p";
        person6.imageSelf = "rana_s";
        person6.imageFriend = "rana_s";
        person6.listFriends.addAll(Arrays.asList("0"));


        Person[] people = {person1, person2, person3, person4, person5, person6};

        return people;

    }

}
