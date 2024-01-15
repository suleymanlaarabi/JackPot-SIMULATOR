package suleyman.JackPot.module.home;

import suleyman.JackPot.module.main.MainController;

public class HomeController {
    private HomeView homeView = new HomeView();

    public HomeController(MainController mainController) {

    }

    public HomeView getView() {
        return homeView;
    }
}
