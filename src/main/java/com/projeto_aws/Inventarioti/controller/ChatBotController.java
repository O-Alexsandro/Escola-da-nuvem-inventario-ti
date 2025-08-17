package com.projeto_aws.Inventarioti.controller;

import com.projeto_aws.Inventarioti.dto.chatRequest.ChatRequest;
import com.projeto_aws.Inventarioti.service.ChatBotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatBotController {

    @Autowired
    ChatBotService chatBotService;

    @PostMapping
    public Map<String, String> perguntas(@RequestBody ChatRequest request) {
        return chatBotService.perguntas(request);
    }
}
