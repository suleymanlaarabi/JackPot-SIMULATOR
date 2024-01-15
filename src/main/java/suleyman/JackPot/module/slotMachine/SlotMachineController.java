package suleyman.JackPot.module.slotMachine;

import suleyman.JackPot.module.main.MainController;

public class SlotMachineController {

    public MainController mainController;
    SlotMachineModel slotMachineModel;
    SlotMachineView slotMachineView;

    public SlotMachineController(MainController mainController) {
        this.mainController = mainController;
        this.slotMachineModel = new SlotMachineModel(this);
        this.slotMachineView = new SlotMachineView(this);
    }

    public void initEvents() {
        slotMachineView.betMoneySlider.valueProperty().addListener(
                (obj, oldValue, newValue) -> {
                    slotMachineModel.setBetMoney(newValue.intValue());
                });
        slotMachineView.playButton.setOnAction(
                evt -> slotMachineModel.play());
    }

    public SlotMachineView getView() {
        return slotMachineView;
    }
}
