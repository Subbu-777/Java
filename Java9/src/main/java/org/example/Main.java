package org.example;

import javax.security.auth.x500.X500Principal;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        X500Principal name =new X500Principal("CN=user");
    }
}