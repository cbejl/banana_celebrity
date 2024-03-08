package cbejl.banana_celebrity;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CelebrityCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(player.hasPermission("celebrity.do")) {
                if(strings.length > 0 && !strings[0].isEmpty()) {
                    switch (strings[0]) {
                        case "stream" -> {
                            Banana_celebrity.getInstance().celebrityMap.put(player,
                                    Banana_celebrity.getInstance().getConfig().getString("papi.stream"));
                            player.sendMessage(Banana_celebrity.getInstance().getConfig().getString("set.stream"));
                        }
                        case "rec" -> {
                            Banana_celebrity.getInstance().celebrityMap.put(player,
                                    Banana_celebrity.getInstance().getConfig().getString("papi.rec"));
                            player.sendMessage(Banana_celebrity.getInstance().getConfig().getString("set.rec"));
                        }
                        case "justplay" -> {
                            Banana_celebrity.getInstance().celebrityMap.put(player,
                                    Banana_celebrity.getInstance().getConfig().getString("papi.justplay"));
                            player.sendMessage(Banana_celebrity.getInstance().getConfig().getString("set.justplay"));
                        }
                        default -> {
                            if(Banana_celebrity.getInstance().celebrityMap.get(player).equals(Banana_celebrity.getInstance().getConfig().getString("papi.stream"))) {
                                player.sendMessage(Banana_celebrity.getInstance().getConfig().getString("is.stream"));
                            } else if(Banana_celebrity.getInstance().celebrityMap.get(player).equals(Banana_celebrity.getInstance().getConfig().getString("papi.rec"))) {
                                player.sendMessage(Banana_celebrity.getInstance().getConfig().getString("is.rec"));
                            } else if(Banana_celebrity.getInstance().celebrityMap.get(player).equals(Banana_celebrity.getInstance().getConfig().getString("papi.justplay"))) {
                                player.sendMessage(Banana_celebrity.getInstance().getConfig().getString("is.justplay"));
                            }
                        }
                    }
                }
                return true;
            }
            if(player.hasPermission("kepka")) {
                if(strings[0].equals("reload")) {
                    Banana_celebrity.getInstance().reloadConfig();
                    System.out.println("Плагин перезагружен!");
                    return true;
                }
            }
        } else if(strings[0].equals("reload")) {
            Banana_celebrity.getInstance().reloadConfig();
            System.out.println("Плагин перезагружен!");
            return true;
        }
        return false;
    }
}
