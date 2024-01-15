package suleyman.JackPot.module.auth;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;

import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import suleyman.JackPot.module.auth.tabs.SignInTab;
import suleyman.JackPot.module.auth.tabs.SignUpTab;
import suleyman.JackPot.module.profile.ProfileView;

public class AuthView extends VBox {

    AuthController authController;

    public ProfileView profileView;

    ObservableList<Node> components = this.getChildren();

    // components
    Text title = new Text("Auth");

    TabPane authPane = new TabPane();
    SignInTab signInTab = new SignInTab();
    SignUpTab signUpTab = new SignUpTab();

    Text errorMessage = new Text("");

    public AuthView(AuthController authController) {
        super(10);
        this.authController = authController;
        this.profileView = new ProfileView(authController);
        this.setAlignment(Pos.CENTER);

        authPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        authPane.getTabs().addAll(
                signInTab,
                signUpTab);

        this.render();
    }

    public void setErrorMessage(String message) {
        errorMessage.setText(message);
    }

    public void render() {
        if (authController.authModel.authSession.isConnected()) {
            components.clear();
            components.add(profileView);
            return;
        }
        components.addAll(
                title,
                errorMessage,
                authPane);
    }
}
