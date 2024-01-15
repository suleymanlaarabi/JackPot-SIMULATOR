package suleyman.JackPot.module.home;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class HomeView extends HBox {
    ObservableList<Node> components = this.getChildren();

    // components
    Text title = new Text("Home");

    public HomeView() {
        super(10);
        this.setAlignment(Pos.CENTER);
        this.render();
    }

    public void render() {
        components.add(title);
    }
}
