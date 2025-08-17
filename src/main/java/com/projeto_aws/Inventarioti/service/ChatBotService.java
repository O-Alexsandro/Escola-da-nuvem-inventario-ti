package com.projeto_aws.Inventarioti.service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.projeto_aws.Inventarioti.dto.chatRequest.ChatRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatBotService {

    @Autowired
    Client client;

    private final Map<String, List<String>> historicos = new HashMap<>();

    private static final String PROMPT_BASE = "Você é um agente de suporte técnico automatizado chamado SmartBot. Seu objetivo é resolver o chamado abaixo de forma rápida, simples e, acima de tudo, prestativa.\n"; // seu prompt aqui (mesmo do código anterior)

    public Map<String, String> perguntas(ChatRequest request) {
        String mensagem = request.getMensagem();
        String usuario = request.getUsuario() != null ? request.getUsuario() : "default";

        List<String> historico = historicos.getOrDefault(usuario, new ArrayList<>());

        int maxHistorico = 6;
        List<String> ultimasMensagens = historico.size() > maxHistorico ?
                historico.subList(historico.size() - maxHistorico, historico.size()) :
                new ArrayList<>(historico);

        StringBuilder promptBuilder = new StringBuilder();
        promptBuilder.append(PROMPT_BASE).append("\n\n");
        promptBuilder.append("---\nHISTÓRICO:\n");
        for (String msg : ultimasMensagens) {
            promptBuilder.append(msg).append("\n");
        }
        promptBuilder.append("\n[NOVA MENSAGEM:]\nUsuário: ").append(mensagem).append("\nSmartBot: ");

        String promptFinal = promptBuilder.toString();

        GenerateContentResponse resposta =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        promptFinal,
                        null);

        String respostaTexto = formatarResposta(resposta.text());

        historico.add("Usuário: " + mensagem);
        historico.add("SmartBot: " + respostaTexto);
        historicos.put(usuario, historico);

        return Map.of("resposta", respostaTexto);
    }

    public String formatarResposta(String textoOriginal) {
        String texto = textoOriginal.replaceAll("\\r\\n", "\n")
                .replaceAll("\\r", "\n");

        String[] linhas = texto.split("\n");
        StringBuilder sb = new StringBuilder();

        for (String linha : linhas) {
            String linhaTrim = linha.trim();
            if (linhaTrim.startsWith("*")) {
                linhaTrim = "- " + linhaTrim.substring(1).trim();
            }
            if (!linhaTrim.isEmpty()) {
                sb.append(linhaTrim).append("\n");
            }
        }

        String resultado = sb.toString().replaceAll("(?m)^[ \t]*\r?\n", ""); // remove linhas em branco
        resultado = resultado.replaceAll("\n{2,}", "\n\n"); // no máximo duas linhas em branco

        return resultado.trim();
    }
}
