package marumasa.discord_text.server;

import marumasa.discord_text.http.request;

import java.io.IOException;

public class status {

    public void onEnable() throws IOException {
        int TYPE = 1000;
        String JSON = "{\"type\":" + TYPE + "}";
        new request().post(JSON);
    }

    public void onDisable() throws IOException {
        int TYPE = 1001;
        String JSON = "{\"type\":" + TYPE + "}";
        new request().post(JSON);
    }
}