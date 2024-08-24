package com.example.ejemplochatreto2.presenter;


import com.example.ejemplochatreto2.model.LoginModel;
import com.example.ejemplochatreto2.view.LoginContract;
import com.google.firebase.auth.FirebaseUser;

//Funcionalidades de inicio de sesión
public class LoginPresenter {
    //vista asociada al presentación de Login

    private LoginContract.View view;

    private LoginModel model;

 public LoginPresenter(LoginContract.View  view, LoginModel model){
    this.view = view;
    this.model = model;
 }

    // Método para iniciar sesión
    public void loginUser() {
        // Obtener el email y la contraseña ingresados por el usuario desde la vista
        String email = view.getEmail();
        String password = view.getPassword();

        // Validar que el email y la contraseña no estén vacíos
        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            view.showToast("Por favor, completa todos los campos");
            return;
        }

        // Llamar al método del modelo para iniciar sesión, pasando un callback para manejar el resultado
        model.loginUser(email, password, new LoginModel.LoginCallback() {
            @Override
            // Método llamado en caso de éxito al iniciar sesión
            public void onSuccess(FirebaseUser user) {
                view.showToast("Inicio de sesión exitoso"); // Mostrar mensaje de éxito en la vista
                view.navigateToHome(); // Navegar a la pantalla de inicio en la vista
            }

            @Override
            // Método llamado en caso de fallo al iniciar sesión
            public void onFailure(Exception e) {
                // Mostrar mensaje de error en la vista
                view.showToast("Error de inicio de sesión: " + e.getMessage());
            }
        });
    }

}
