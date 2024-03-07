package cbejl.banana_celebrity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinCheck implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(!Banana_celebrity.getInstance().celebrityMap.containsKey(event.getPlayer())) {
            Banana_celebrity.getInstance().celebrityMap.put(event.getPlayer(),
                    Banana_celebrity.getInstance().getConfig().getString("papi.justplay"));
        }
    }
}
