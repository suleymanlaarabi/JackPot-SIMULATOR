package suleyman.JackPot.module.main;

import suleyman.JackPot.module.auth.AuthController;
import suleyman.JackPot.module.home.HomeController;
import suleyman.JackPot.module.main.types.PageEnum;
import suleyman.JackPot.module.navBar.NavBarController;
import suleyman.JackPot.module.slotMachine.SlotMachineController;

public class MainController {

    public NavBarController navBarController = new NavBarController(this);

    // private MainModel mainModel = new MainModel();
    private MainView mainView = new MainView();

    // Page Controller
    private HomeController homeController;
    public AuthController authController;
    public SlotMachineController slotMachineController;

    public MainController() {
        this.homeController = new HomeController(this);
        this.authController = new AuthController(this);
        this.slotMachineController = new SlotMachineController(this);

        mainView.render(navBarController.getView(), homeController.getView());
        this.initEvents();
        this.authController.initEvents();
        this.slotMachineController.initEvents();
    }

    public void initEvents() {
        navBarController.initEvents();
    }

    public void switchPage(PageEnum page) {
        switch (page) {
            case HomePage:
                mainView.changeView(homeController.getView());
                break;
            case AuthPage:
                mainView.changeView(authController.getView());
                break;
            case SlotMachinePage:
                mainView.changeView(slotMachineController.getView());
                break;
        }
    }

    public MainView getView() {
        return mainView;
    }

}
