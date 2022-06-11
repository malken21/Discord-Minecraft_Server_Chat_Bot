package marumasa.discord_text;

import marumasa.discord_text.server.status;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Discord_text extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new eventListener(this), this);
    }

    @Override
    public void onDisable() {
        try {
            new status().onDisable();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}