package suleyman.JackPot.module.main;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import suleyman.JackPot.module.navBar.NavBarView;

public class MainView extends VBox {

    ObservableList<Node> components = this.getChildren();

    // components
    public MainView() {
        super(10);
    }

    public void changeView(Node newView) {
        components.set(1, newView);
    }

    public void render(NavBarView navBarView, Node startView) {
        components.addAll(navBarView, startView);
    }
}
