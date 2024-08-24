package com.example.ejemplochatreto2.view;

import com.example.ejemplochatreto2.model.MessageModel;

import java.util.List;

public interface ChatContract {


    /**
     * Muestra la lista de conversaciones en la interfaz de usuario.
     * @param conversations Lista de modelos de mensajes que representan las conversaciones.
     */
    void showConversations(List<MessageModel> conversations);

    /**
     * Muestra una confirmación de que el mensaje ha sido enviado correctamente.
     */
    void showMessageSentConfirmation();

    String getCurrentUserModelName();
}
