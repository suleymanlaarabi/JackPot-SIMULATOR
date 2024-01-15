package suleyman.JackPot.services.Auth.Session;

import com.google.gson.Gson;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import suleyman.JackPot.module.main.MainController;
import suleyman.JackPot.services.Auth.Response.AuthResponse;

public class AuthSession {
    private String access_token = "";
    MainController mainController;
    private Profile profile = new Profile(0, access_token, 0);

    public AuthSession(MainController mainController) {
        this.mainController = mainController;
    }

    public String getAccessToken() {
        return this.access_token;
    }

    public boolean isConnected() {
        System.out.println(!access_token.isEmpty());
        return !access_token.isEmpty();
    }

    public void setSession(AuthResponse authResponse) {
        access_token = authResponse.getToken();
        this.updateProfile();
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        System.out.println("MONEY GETTED" + profile.getMoney());
        if (isConnected()) {
            mainController.slotMachineController.getView().renderSlider(this);
            System.out.println("render");
            mainController.authController.getView().profileView.renderProfileInfo(profile);
        }
    }

    public Profile getProfile() {
        return profile;
    }

    public Profile updateProfile() {
        if (isConnected()) {
            HttpResponse<JsonNode> httpResponse = Unirest.get("http://localhost:3000/users")
                    .header("Authorization", "Bearer " + access_token)
                    .asJson();
            if (httpResponse.isSuccess()) {
                Gson gson = new Gson();

                Profile profile = gson.fromJson(httpResponse.getBody().toString(), Profile.class);
                this.setProfile(profile);
                System.out.println("MONEYYYYY: " + profile.getMoney());
                return profile;
            }
        }
        return new Profile(0, "Not Connected", 0);

    }

}
