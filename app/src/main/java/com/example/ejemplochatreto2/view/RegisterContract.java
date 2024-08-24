package com.example.ejemplochatreto2.view;

public interface RegisterContract {

    interface View {
        /**
         * Muestra un mensaje de notificación en la interfaz de usuario.
         * @param message Mensaje a mostrar.
         */
        void showToast(String message);

        /**
         * Limpia los campos de entrada en la interfaz de usuario.
         */
        void clearInputFields();

        /**
         * Navega a la pantalla de inicio de sesión.
         */
        void navigateToLogin();

        /**
         * Obtiene el nombre ingresado por el usuario.
         * @return Nombre ingresado.
         */
        String getName();

        /**
         * Obtiene el correo electrónico ingresado por el usuario.
         * @return Correo electrónico ingresado.
         */
        String getEmail();

        /**
         * Obtiene la contraseña ingresada por el usuario.
         * @return Contraseña ingresada.
         */
        String getPassword();
    }
}
