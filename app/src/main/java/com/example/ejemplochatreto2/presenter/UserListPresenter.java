package com.example.ejemplochatreto2.presenter;

import com.example.ejemplochatreto2.model.UserModel;

//[Interfaz para el presentador de la lista de usuarios]
public interface UserListPresenter {
    void loadUsers();
    // Método para cargar la lista de usuario

    UserModel findUserByEmail(String email);
}
