package com.projeto_aws.Inventarioti.dto.chatRequest;

public class ChatRequest {
    private String mensagem;
    private String usuario;

    // getters e setters
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
}