package suleyman.JackPot.module.auth;

import suleyman.JackPot.module.main.MainController;

public class AuthController {
    MainController mainController;
    public AuthModel authModel;
    private AuthView authView;

    public AuthController(MainController mainController) {
        this.mainController = mainController;
        this.authModel = new AuthModel(this);
        this.authView = new AuthView(this);
    }

    public AuthView getView() {
        return this.authView;
    }

    public void alertError(String errorMessage) {
        authView.setErrorMessage(errorMessage);
    }

    public void initEvents() {
        authView.signInTab.signInButton.setOnAction(
                evt -> authModel.login(
                        authView.signInTab.usernameOrEmailTextField.getText(),
                        authView.signInTab.passwordField.getText()));

        authView.signUpTab.signUpButton.setOnAction(
                evt -> authModel.signUp(
                        authView.signUpTab.emailField.getText(),
                        authView.signUpTab.usernameField.getText(),
                        authView.signUpTab.passwordField.getText(),
                        authView.signUpTab.confirmPasswordField.getText()

                ));
    }
}
