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

public class SignInTab extends Tab {

    VBox signInBox = new VBox(10);
    ObservableList<Node> components = signInBox.getChildren();

    public TextField usernameOrEmailTextField = new TextField();
    public PasswordField passwordField = new PasswordField();
    public Button signInButton = new Button("Sign In");

    public SignInTab() {
        super("sign-in");

        signInBox.setAlignment(Pos.CENTER);
        signInBox.setPadding(new Insets(10));

        this.passwordField.setPromptText("password");
        this.passwordField.setMaxWidth(350);

        this.usernameOrEmailTextField.setPromptText("username or email");
        this.usernameOrEmailTextField.setMaxWidth(350);

        this.render();

        this.setContent(signInBox);

    }

    public void render() {
        this.components.addAll(
                usernameOrEmailTextField,
                passwordField,
                signInButton);
    }
}
