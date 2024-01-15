package suleyman.JackPot.module.auth;

import com.google.gson.Gson;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import suleyman.JackPot.services.Auth.Response.AuthErrorResponse;
import suleyman.JackPot.services.Auth.Response.AuthResponse;
import suleyman.JackPot.services.Auth.Session.AuthSession;

public class AuthModel {

    AuthController authController;

    public AuthSession authSession;

    public AuthModel(AuthController authController) {
        this.authController = authController;
        this.authSession = new AuthSession(authController.mainController);
    }

    public void login(String username, String password) {
        HttpResponse<JsonNode> httpResponse = Unirest.post("http://localhost:3000/users/login")
                .header("accept", "application/json")
                .field("username", username)
                .field("password", password)
                .asJson();

        Gson gson = new Gson();
        if (httpResponse.isSuccess()) {
            AuthResponse authResponse = gson.fromJson(httpResponse.getBody().toString(), AuthResponse.class);
            authSession.setSession(authResponse);
            authController.getView().render();

        } else {
            AuthErrorResponse errorResponse = gson.fromJson(httpResponse.getBody().toString(), AuthErrorResponse.class);
            this.authController.alertError(errorResponse.getMessage()[0]);

        }
    }

    public void signUp(String email, String username, String password, String confirmPassword) {
        HttpResponse<JsonNode> httpResponse = Unirest.post("http://localhost:3000/users/register")
                .header("accept", "application/json")
                .field("email", email)
                .field("username", username)
                .field("password", password)
                .asJson();

        Gson gson = new Gson();
        if (httpResponse.isSuccess()) {
            AuthResponse authResponse = gson.fromJson(httpResponse.getBody().toString(), AuthResponse.class);
            authSession.setSession(authResponse);
            authController.getView().render();

        } else {
            AuthErrorResponse errorResponse = gson.fromJson(httpResponse.getBody().toString(), AuthErrorResponse.class);
            this.authController.alertError(errorResponse.getMessage()[0]);

        }

    }
}
