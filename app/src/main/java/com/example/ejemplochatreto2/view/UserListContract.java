package com.example.ejemplochatreto2.view;

import com.example.ejemplochatreto2.model.UserModel;

import java.util.List;

public interface UserListContract {
    /**
     * Muestra la lista de usuarios en la interfaz de usuario.
     * @param users Lista de modelos de usuarios.
     */
    void displayUsers(List<UserModel> users);

    /**
     * Muestra un mensaje de error en la interfaz de usuario.
     * @param message Mensaje de error a mostrar.
     */
    void showError(String message);

    void setCurrUserModel(UserModel userModel);

    /**
     * Recupera el email del usuario logueado
     * @return El correo electronico del usuario logueado
     */
    String getCurrenUserMail();
}
