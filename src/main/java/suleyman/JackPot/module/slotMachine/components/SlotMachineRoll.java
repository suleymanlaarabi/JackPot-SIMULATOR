package suleyman.JackPot.module.slotMachine.components;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import suleyman.JackPot.utils.CreateImage;

public class SlotMachineRoll extends HBox {
    ObservableList<Node> components = this.getChildren();

    ImageView image1 = new ImageView(new CreateImage().createImageWithNumber(1));
    ImageView image2 = new ImageView(new CreateImage().createImageWithNumber(1));
    ImageView image3 = new ImageView(new CreateImage().createImageWithNumber(1));

    public SlotMachineRoll() {
        super();
        this.setAlignment(Pos.CENTER);
        this.render();
    }

    public void setRoll(int[] roll) {
        CreateImage imageCreation = new CreateImage();
        image1.setImage(imageCreation.createImageWithNumber(roll[0]));
        image2.setImage(imageCreation.createImageWithNumber(roll[1]));
        image3.setImage(imageCreation.createImageWithNumber(roll[2]));

    }

    public void render() {
        components.addAll(
                image1,
                image2,
                image3);
    }
}
