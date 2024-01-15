package suleyman.JackPot.module.navBar;

import suleyman.JackPot.module.main.MainController;
import suleyman.JackPot.module.main.types.PageEnum;

public class NavBarController {
    MainController mainController;
    private NavBarView navBarView;

    public NavBarController(MainController mainController) {
        this.mainController = mainController;
        this.navBarView = new NavBarView();
    }

    public void initEvents() {
        navBarView.homeViewButton.setOnAction(
                evt -> mainController.switchPage(
                        PageEnum.HomePage));
        navBarView.authViewButton.setOnAction(
                evt -> mainController.switchPage(PageEnum.AuthPage));
        navBarView.slotMachineViewButton.setOnAction(
                evt -> mainController.switchPage(PageEnum.SlotMachinePage));

    }

    public NavBarView getView() {
        return navBarView;
    }
}
