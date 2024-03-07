package cbejl.banana_celebrity;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CelebrityPlaceholder extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "celebrity";
    }

    @Override
    public @NotNull String getAuthor() {
        return "CbeJl_Tpycbl";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if(player == null) {
            return "";
        }

        if(params.equals("do")) {
            if (Banana_celebrity.getInstance().celebrityMap.get(player).length() > 0) {
                return Banana_celebrity.getInstance().celebrityMap.get(player);
            } else {
                return "";
            }
        }

        return "";
    }
}
