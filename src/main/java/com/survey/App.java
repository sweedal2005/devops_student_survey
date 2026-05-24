package com.survey;

import java.util.*;

public class App {
    public static List<String> responses = new ArrayList<>();

    public static void submitResponse(String response) {
        responses.add(response);
        System.out.println("Response saved: " + response);
    }

    public static List<String> getResponses() {
        return responses;
    }
}