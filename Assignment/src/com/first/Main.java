package com.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        user u1 = new user();
        user u2 = new user();
        user u3 = new user();
        user u4 = new user();

        u1.setUserId(1);
        u1.setNameOfUser("Monika");
        u2.setUserId(2);
        u2.setNameOfUser("Payal");
        u3.setUserId(3);
        u3.setNameOfUser("Priti");
        u4.setUserId(4);
        u4.setNameOfUser("Punam");

        List<user> users=new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);

        System.out.println(users);

        Collections.sort(users,(a,b)-> a.getUserId() - b.getUserId());
        System.out.println(users);
    }

}