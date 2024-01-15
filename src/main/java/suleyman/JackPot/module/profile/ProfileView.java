package suleyman.JackPot.module.profile;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import suleyman.JackPot.module.auth.AuthController;
import suleyman.JackPot.services.Auth.Session.AuthSession;
import suleyman.JackPot.services.Auth.Session.Profile;

public class ProfileView extends VBox {
    AuthController authController;

    ObservableList<Node> components = this.getChildren();

    Text title = new Text("Profile");

    public Button logoutButton = new Button("logout");

    Text usernamText = new Text("");

    Text moneyText = new Text("Money : 0");

    public ProfileView(AuthController authController) {
        super(10);
        this.authController = authController;
        this.setAlignment(Pos.CENTER);
        this.render();
    }

    public void renderProfileInfo(Profile profile) {

        AuthSession currentSession = authController.authModel.authSession;
        if (currentSession.isConnected()) {
            System.out.print("render Profile");
            this.usernamText.setText(profile.getUsername());
            this.moneyText.setText("money :" + profile.getMoney());
        }
    }

    public void render() {

        components.addAll(
                title,
                usernamText,
                moneyText,
                logoutButton);
    }
}
