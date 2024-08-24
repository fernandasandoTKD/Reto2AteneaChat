package com.example.ejemplochatreto2.presenter;

import com.example.ejemplochatreto2.model.RegisterModel;
import com.example.ejemplochatreto2.view.RegisterContract;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;


//[Clase que actúa como presentador para la funcionalidad de registro]
public class RegisterPresenter {
    private RegisterContract.View view; // Interfaz de vista que maneja la interacción con la interfaz de usuario
    private RegisterModel model; // Modelo que maneja la lógica de negocio y las operaciones de datos

    // Constructor del presentador que recibe la vista y el modelo
    public RegisterPresenter(RegisterContract.View view, RegisterModel model) {
        this.view = view;
        this.model = model;
    }

    // Método para registrar un usuario
    public void registerUser() {
        String name = view.getName(); // Obtiene el nombre del usuario desde la vista
        String email = view.getEmail(); // Obtiene el correo electrónico del usuario desde la vista
        String password = view.getPassword(); // Obtiene la contraseña del usuario desde la vista

        // Verifica si algún campo está vacío
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            // Muestra un mensaje de advertencia en la vista
            view.showToast("Por favor, completa todos los campos");
            // Sale del método si algún campo está vacío
            return;
        }

        // Verifica si la contraseña tiene al menos 6 caracteres
        if (password.length() < 6) {
            view.showToast("La contraseña debe tener al menos 6 caracteres"); // Muestra un mensaje de advertencia en la vista
            return; // Sale del método si la contraseña es demasiado corta
        }

        // Llama al método del modelo para registrar al usuario en Firebase Authentication

        model.registerUser(email, password, new RegisterModel.RegistroCallback() {
            @Override
            public void onSuccess(Object result) {
                // Obtiene el usuario registrado
                FirebaseUser user = (FirebaseUser) result;
                // Crea un mapa para almacenar los datos del usuario
                Map<String, Object> userData = new HashMap<>();
                // Agrega el nombre del usuario al mapa
                userData.put("name", name);
                // Agrega el correo electrónico del usuario al mapa
                userData.put("email", email);

                // Llama al método del modelo para almacenar los datos del usuario en Firestore

                model.storeUserData(user, userData, new RegisterModel.RegistroCallback() {
                    @Override
                    public void onSuccess(Object result) {
                        // Muestra un mensaje de éxito en la vista
                        view.showToast("Registro exitoso");
                        // Limpia los campos de entrada en la vista
                        view.clearInputFields();
                        // Navega a la pantalla de inicio de sesión en la vista
                        view.navigateToLogin();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        view.showToast("Error al registrar en Firestore");
                    }
                });
            }

            // Muestra un mensaje de error en la vista
            @Override
            public void onFailure(Exception e) {
                view.showToast("Error al registrar usuario");
            }
        });
    }
}