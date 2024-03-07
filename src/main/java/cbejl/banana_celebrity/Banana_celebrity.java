package cbejl.banana_celebrity;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Banana_celebrity extends JavaPlugin {

    Map<Player, String> celebrityMap = new HashMap<>();
    public static Banana_celebrity instance;

    @Override
    public void onEnable() {
        getLogger().info("[CELEBRITY DO] ПИТЬ СОК ТРАХАТЬ СУК СТРИМИТЬ ТВИЧ СМОТРЕТЬ ЮТУБ!");
        saveDefaultConfig();
        instance = this;
        getCommand("celebrity").setExecutor(new CelebrityCommand());
        new CelebrityPlaceholder().register();
        getLogger().info("[CELEBRITY DO] ГОТОВО!");
        getServer().getPluginManager().registerEvents(new JoinCheck(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static Banana_celebrity getInstance() {
        return instance;
    }

}
