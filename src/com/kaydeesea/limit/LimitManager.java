package com.kaydeesea.limit;

import com.andrei1058.bedwars.api.arena.IArena;
import com.andrei1058.bedwars.arena.Arena;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LimitManager implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        IArena playerarena = Arena.getArenaByPlayer(e.getPlayer());
        if (playerarena != null) {
            int heightlimit = playerarena.getConfig().getInt("max-build-y");
            int difference = e.getPlayer().getLocation().getBlockY() - heightlimit;
            if (difference > -6 && difference < 1) {
                String message = "§9§lLimit: §b§l" + difference;
                CraftPlayer p = (CraftPlayer)e.getPlayer();
                IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
                PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte)2);
                p.getHandle().playerConnection.sendPacket(ppoc);
            }
        }

    }
}
