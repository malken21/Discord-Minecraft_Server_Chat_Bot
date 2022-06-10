package marumasa.discord_text;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import marumasa.discord_text.http.request;

public class eventListener implements Listener {
    private final Discord_text minecraft;

    public eventListener(Discord_text data) {
        minecraft = data;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) throws Exception {
        new request().post(event.getPlayer().getName(), event.getMessage(),event.getPlayer().getUniqueId());
    }
}