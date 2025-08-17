package com.projeto_aws.Inventarioti.configuration;

import com.google.genai.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatBotConfig {

//    @Bean
//    public ChatClient chatClient(VertexAiGeminiChatModel chatModel) {
//        return ChatClient.create(chatModel);
//    }

    @Bean
    public Client geminiClient(){
        return new Client();
    }
}
