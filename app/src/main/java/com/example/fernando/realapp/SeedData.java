package com.example.fernando.realapp;

import java.util.Arrays;

/**
 * Created by fernando on 16.10.17.
 */

public class SeedData {

    static Person[] seedData(){
        Person person1 = new Person();
        person1.userId = "1";
        person1.userName = "Fernando";
        person1.imageProfile = "person1_p";
        person1.imageSelf = "person1_s";
        person1.imageFriend = "person1_f";
        person1.listFriends.addAll(Arrays.asList("2"));

        Person person2 = new Person();
        person2.userId = "2";
        person2.userName = "Maria";
        person2.imageProfile = "person2_p";
        person2.imageSelf = "person2_s";
        person2.imageFriend = "person2_f";
        person2.listFriends.addAll(Arrays.asList("1"));

        Person person3 = new Person();
        person3.userId = "3";
        person3.userName = "Led";
        person3.imageProfile = "person3_p";
        person3.imageSelf = "person3_s";
        person3.imageFriend = "person3_f";
        person3.listFriends.addAll(Arrays.asList(""));

        Person[] people = {person1, person2, person3};

        return people;

    }

}
