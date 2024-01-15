package suleyman.JackPot;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import suleyman.JackPot.module.main.MainController;

public class App extends Application {

    private final String WINDOW_TITLE = "JackPot";
    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 850;

    @Override
    public void start(Stage primStage) {
        MainController mainController = new MainController();
        Scene mainViewScene = new Scene(mainController.getView());

        primStage.setScene(mainViewScene);
        primStage.show();

        Platform.runLater(
                () -> {
                    primStage.setTitle(WINDOW_TITLE);

                    primStage.setWidth(WINDOW_WIDTH);
                    primStage.setHeight(WINDOW_HEIGHT);

                    primStage.centerOnScreen();
                });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
