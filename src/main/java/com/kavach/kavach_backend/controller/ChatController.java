package com.kavach.kavach_backend.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatController {

    private static final String ANTHROPIC_URL = "https://api.anthropic.com/v1/messages";
    private static final String API_KEY = System.getenv("ANTHROPIC_API_KEY");

    @PostMapping
    public ResponseEntity<?> chat(@RequestBody Map<String, String> body) {
        String userMessage = body.get("message");
        if (userMessage == null || userMessage.trim().isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Message is required"));
        }

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("x-api-key", API_KEY);
            headers.set("anthropic-version", "2023-06-01");

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("model", "claude-sonnet-4-6");
            requestBody.put("max_tokens", 300);
            requestBody.put("system",
                "You are Kavach AI, assistant for a women safety app. " +
                "Reply in 2-3 lines max. Support both Hindi and English (Hinglish is fine). " +
                "If user seems in danger or scared, ALWAYS tell them to press SOS immediately and call 112. " +
                "Help with: SOS alerts, safe journey, voice activation, helplines, anonymous reporting, evidence vault."
            );
            requestBody.put("messages", List.of(
                Map.of("role", "user", "content", userMessage)
            ));

            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(ANTHROPIC_URL, request, Map.class);

            List<Map<String, Object>> content = (List<Map<String, Object>>) response.getBody().get("content");
            String reply = (String) content.get(0).get("text");

            return ResponseEntity.ok(Map.of("reply", reply));

        } catch (Exception e) {
            return ResponseEntity.ok(Map.of("reply", "In any emergency, press SOS or call 112 immediately!"));
        }
    }
}