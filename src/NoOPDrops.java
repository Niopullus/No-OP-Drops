import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class NoOPDrops extends JavaPlugin {

    public void onEnable() {
        final MobDropListener listener;
        final Server server;
        final PluginManager pluginManager;
        listener = new MobDropListener();
        server = getServer();
        pluginManager = server.getPluginManager();
        pluginManager.registerEvents(listener, this);
    }

    public void onDisable() {

    }

}
