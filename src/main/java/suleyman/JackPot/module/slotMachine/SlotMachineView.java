package suleyman.JackPot.module.slotMachine;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import suleyman.JackPot.module.slotMachine.components.SlotMachineRoll;
import suleyman.JackPot.services.Auth.Session.AuthSession;

public class SlotMachineView extends VBox {
    SlotMachineController slotMachineController;

    ObservableList<Node> components = this.getChildren();

    Text title = new Text("SlotMachine");

    SlotMachineRoll slotMachineRoll = new SlotMachineRoll();

    Text betMoneyText = new Text("bet: 0");
    Slider betMoneySlider = new Slider();
    Button playButton = new Button("Play !");

    public SlotMachineView(SlotMachineController slotMachineController) {
        this.slotMachineController = slotMachineController;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        this.betMoneySlider.setMin(0);
        this.betMoneySlider.setValue(0);
        this.betMoneySlider.setMaxWidth(400);

        this.render();

    }

    public void renderSlider(AuthSession authSession) {
        System.out.println("render slider : " + authSession.isConnected());
        if (authSession.isConnected()) {
            int money = authSession.getProfile().getMoney();
            betMoneySlider.setMax(money);
            if (!components.contains(betMoneySlider) && money > 0) {
                components.add(betMoneySlider);
            }
            return;
        }
        if (components.contains(betMoneySlider)) {
            components.remove(betMoneySlider);
        }
    }

    public void render() {
        components.addAll(title, slotMachineRoll, betMoneyText, playButton);
    }
}
