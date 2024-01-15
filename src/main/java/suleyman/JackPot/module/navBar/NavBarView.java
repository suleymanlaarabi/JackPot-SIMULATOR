package suleyman.JackPot.module.navBar;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class NavBarView extends HBox {

    ObservableList<Node> components = this.getChildren();

    // Components
    Button homeViewButton = new Button("Home");
    Button authViewButton = new Button("Auth");
    Button slotMachineViewButton = new Button("SlotMachine");

    public NavBarView() {
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(15));
        this.setSpacing(10);
        this.render();
    }

    public void render() {
        components.addAll(homeViewButton, slotMachineViewButton, authViewButton);
    }
}
