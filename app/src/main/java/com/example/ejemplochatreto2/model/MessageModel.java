package com.example.ejemplochatreto2.model;

import java.util.Date;

public class MessageModel {

    // Identificador único del mensaje
    private String messageId;
    // Texto del mensaje
    private String messageText;
    // ID del remitente del mensaje
    private String senderId;
    // Nombre del remitente del mensaje
    private String senderName;
    // Marca de tiempo del mensaje
    private Date timestamp;
    // Correo electrónico del remitente del mensaje
    private String senderEmail;

    // Constructores, getters y setters

    public MessageModel() {
        // Constructor vacío necesario para Firebase
    }

    public MessageModel(String messageId, String messageText, String senderId, String senderName, Date timestamp) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.senderId = senderId;
        this.senderName = senderName;
        this.timestamp = timestamp;
    }
    public MessageModel(String messageId, String messageText, String senderId, String senderName, Date timestamp, String senderEmail) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.senderId = senderId;
        this.senderName = senderName;
        this.timestamp = timestamp;
        this.senderEmail = senderEmail;
    }

    // Getter y setter para el correo electrónico del remitente
    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    // Getters y setters para los demás atributos
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
