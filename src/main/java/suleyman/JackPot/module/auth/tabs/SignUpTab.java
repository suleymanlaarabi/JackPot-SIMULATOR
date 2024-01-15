package suleyman.JackPot.module.auth.tabs;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SignUpTab extends Tab {

    VBox signUpBox = new VBox(10);
    ObservableList<Node> components = signUpBox.getChildren();

    public TextField emailField = new TextField();
    public TextField usernameField = new TextField();
    public PasswordField passwordField = new PasswordField();
    public PasswordField confirmPasswordField = new PasswordField();

    public Button signUpButton = new Button("Sign Up");

    public SignUpTab() {
        super("sign-up");

        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.setPadding(new Insets(10));

        this.passwordField.setPromptText("password");
        this.passwordField.setMaxWidth(350);

        this.confirmPasswordField.setPromptText("confirm password");
        this.confirmPasswordField.setMaxWidth(350);

        this.emailField.setPromptText("email");
        this.emailField.setMaxWidth(350);

        this.usernameField.setPromptText("username");
        this.usernameField.setMaxWidth(350);

        this.render();
        this.setContent(signUpBox);

    }

    public void render() {
        this.components.addAll(
                emailField,
                usernameField,
                passwordField,
                confirmPasswordField,
                signUpButton);
    }
}
