package marumasa.discord_text;

import org.bukkit.plugin.java.JavaPlugin;

public final class Discord_text extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new eventListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
