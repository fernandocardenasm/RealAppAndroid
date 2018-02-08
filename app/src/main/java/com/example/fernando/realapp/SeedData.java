package com.example.fernando.realapp;

import java.util.Arrays;

/**
 * Created by fernando on 16.10.17.
 */

public class SeedData {

    static Person[] seedData(){
        Person person1 = new Person();
        person1.userId = "1";
        person1.userName = "Carolin";
        person1.imageProfile = "caro_p";
        person1.imageSelf = "caro_s";
        person1.imageFriend = "caro_f";
        person1.listFriends.addAll(Arrays.asList(""));

        Person person2 = new Person();
        person2.userId = "2";
        person2.userName = "Christopher";
        person2.imageProfile = "chris_p";
        person2.imageSelf = "chris_s";
        person2.imageFriend = "chris_f";
        person2.listFriends.addAll(Arrays.asList(""));

        Person person3 = new Person();
        person3.userId = "3";
        person3.userName = "Charlotte";
        person3.imageProfile = "charlotte_p";
        person3.imageSelf = "charlotte_s";
        person3.imageFriend = "charlotte_f";
        person3.listFriends.addAll(Arrays.asList("4", "5"));

        Person person4 = new Person();
        person4.userId = "4";
        person4.userName = "Svea";
        person4.imageProfile = "svea_p";
        person4.imageSelf = "svea_s";
        person4.imageFriend = "svea_f";
        person4.listFriends.addAll(Arrays.asList("3","5"));

        Person person5 = new Person();
        person5.userId = "5";
        person5.userName = "Michelle";
        person5.imageProfile = "michelle_p";
        person5.imageSelf = "michelle_s";
        person5.imageFriend = "michelle_f";
        person5.listFriends.addAll(Arrays.asList("3", "4"));

        /*Person person6 = new Person();
        person6.userId = "6";
        person6.userName = "Sandra";
        person6.imageProfile = "person1_f";
        person6.imageSelf = "sandra_s";
        person6.imageFriend = "sandra_f";
        person6.listFriends.addAll(Arrays.asList("1", "4", "5"));*/


        Person[] people = {person1, person2, person3, person4, person5};

        return people;

    }

}
