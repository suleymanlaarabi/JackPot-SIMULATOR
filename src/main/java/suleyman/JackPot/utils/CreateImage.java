package suleyman.JackPot.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreateImage {
    public static ImageView createImageViewWithPath(Class<?> contextClass, String path) {
        return new ImageView(new Image(contextClass.getResourceAsStream(path)));
    }

    public static Image createImageWithPath(Class<?> contextClass, String path) {
        return new Image(contextClass.getResourceAsStream(path));
    }

    public Image createImageWithNumber(int number) {
        String imageString = new String("");
        switch (number) {
            case 1:
                imageString = "../assets/Apple.jpeg";
                break;
            case 2:
                imageString = "../assets/Banane.jpeg";
                break;
            case 3:
                imageString = "../assets/Cerise.jpeg";
                break;
            case 4:
                imageString = "../assets/Lemon.jpeg";
                break;
            case 5:
                imageString = "../assets/Orange.jpeg";
                break;
            case 6:
                imageString = "../assets/Watermelon.jpeg";
                break;
            case 7:
                imageString = "../assets/Seven.jpeg";
                break;

            default:
                imageString = "../assets/Apple.jpeg";
                break;
        }
        return new Image(this.getClass().getResourceAsStream(imageString));
    }
}
