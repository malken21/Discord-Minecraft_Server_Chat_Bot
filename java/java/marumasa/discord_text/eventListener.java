package marumasa.discord_text;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import marumasa.discord_text.http.request;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.net.URLEncoder;
import java.util.UUID;

public class eventListener implements Listener {
    private final Discord_text minecraft;

    public eventListener(Discord_text data) {
        minecraft = data;
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent event) throws Exception {

        int TYPE = 0;
        String NAME = URLEncoder.encode(event.getPlayer().getName(), "UTF-8");
        UUID UUID = event.getPlayer().getUniqueId();

        String JSON = "{\"name\":\"" + NAME + "\",\"uuid\":\"" + UUID + "\",\"type\":\"" + TYPE + "\"}";
        new request().post(JSON);
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) throws Exception {

        int TYPE = 1;
        String NAME = URLEncoder.encode(event.getPlayer().getName(), "UTF-8");
        String TEXT = URLEncoder.encode(event.getMessage(), "UTF-8");
        UUID UUID = event.getPlayer().getUniqueId();

        String JSON = "{\"name\":\"" + NAME + "\",\"text\":\"" + TEXT + "\",\"uuid\":\"" + UUID + "\",\"type\":\"" + TYPE + "\"}";
        new request().post(JSON);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) throws Exception {

        int TYPE = 2;
        String NAME = URLEncoder.encode(event.getPlayer().getName(), "UTF-8");
        UUID UUID = event.getPlayer().getUniqueId();

        String JSON = "{\"name\":\"" + NAME + "\",\"uuid\":\"" + UUID + "\",\"type\":\"" + TYPE + "\"}";
        new request().post(JSON);
    }
}