package suleyman.JackPot.module.slotMachine;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import suleyman.JackPot.module.slotMachine.types.PlayResponse;

public class SlotMachineModel {
    SlotMachineController slotMachineController;
    private int betMoney = 0;

    public SlotMachineModel(SlotMachineController slotMachineController) {
        this.slotMachineController = slotMachineController;
    }

    public void setBetMoney(int amount) {
        this.betMoney = amount;
        this.slotMachineController.slotMachineView.betMoneyText.setText("bet: " + amount);
    }

    public void play() {
        System.out.println(betMoney);
        JSONObject json = new JSONObject();
        json.put("amount", betMoney);

        HttpResponse<PlayResponse> httpResponse = Unirest.post("http://localhost:3000/slot-machine/play")
                .header("Authorization",
                        "Bearer " + slotMachineController.mainController.authController.authModel.authSession
                                .getAccessToken())
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(json.toString())
                .asObject(PlayResponse.class);
        PlayResponse playResponse = httpResponse.getBody();
        int[] roll = playResponse.getRoll();

        slotMachineController.slotMachineView.slotMachineRoll.setRoll(roll);
        slotMachineController.mainController.authController.authModel.authSession.updateProfile();
    }

}
