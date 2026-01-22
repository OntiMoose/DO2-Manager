package net.mat0u5.do2manager.queue;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;

import net.mat0u5.do2manager.utils.OtherUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.Collection;
import java.util.List;

import static net.mat0u5.do2manager.Main.dungeonQueue;

public class QueueCommand {
    public static int joinQueue(ServerCommandSource source) {
        MinecraftServer server = source.getServer();
        final PlayerEntity self = source.getPlayer();
  
        String command = "execute as "+self.getUuidAsString()+" run trigger do2queue set 2";
        OtherUtils.executeCommand(server,command);
        return 1;
    }

    public static int leaveQueue(ServerCommandSource source) {
        MinecraftServer server = source.getServer();
        final PlayerEntity self = source.getPlayer();

        String command = "execute as "+self.getUuidAsString()+" run trigger do2queue set 3";
        OtherUtils.executeCommand(server,command);
        return 1;
    }

    public static int skipTurn(ServerCommandSource source,int skipTurns) {
        MinecraftServer server = source.getServer();
        final PlayerEntity self = source.getPlayer();

        String command = "execute as "+self.getUuidAsString()+" run trigger do2queue set 4";
        OtherUtils.executeCommand(server,command);
        return 1;
    }
    public static int skipTurnOther(ServerCommandSource source, ServerPlayerEntity target) {
        MinecraftServer server = source.getServer();

        String command = "execute as "+target.getNameForScoreboard()+" run trigger do2queue set 4";
        OtherUtils.executeCommand(server,command);
        return 1;
    }
    public static int runFinish(ServerCommandSource source, Collection<? extends ServerPlayerEntity> targets) {
        MinecraftServer server = source.getServer();
        
        for (ServerPlayerEntity player : targets) {
        String command = "execute as "+player.getNameForScoreboard()+" run trigger do2queue set 5";
        OtherUtils.executeCommand(server,command);
        }
        return 1;
    }

    public static int addPlayerToQueue(ServerCommandSource source, Collection<? extends ServerPlayerEntity> targets) {
        MinecraftServer server = source.getServer();

        for (ServerPlayerEntity player : targets) {
        String command = "execute as "+player.getNameForScoreboard()+" run trigger do2queue set 2";
        OtherUtils.executeCommand(server,command);
        }
        return 1;
    }

    public static int removePlayerFromQueue(ServerCommandSource source, Collection<? extends ServerPlayerEntity> targets) {
        MinecraftServer server = source.getServer();

        for (ServerPlayerEntity player : targets) {
        String command = "execute as "+player.getNameForScoreboard()+" run trigger do2queue set 3";
        OtherUtils.executeCommand(server,command);
        }
        return 1;
    }

    public static int listQueue(ServerCommandSource source) {
        MinecraftServer server = source.getServer();
        final PlayerEntity self = source.getPlayer();

        String command = "execute as "+self.getUuidAsString()+" run trigger do2queue set 6";
        OtherUtils.executeCommand(server,command);
        return 1;
    }
}
