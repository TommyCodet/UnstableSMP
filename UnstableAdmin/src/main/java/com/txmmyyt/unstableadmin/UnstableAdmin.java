package com.txmmyyt.unstableadmin;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class UnstableAdmin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("UnstableCore") == null) {
            getLogger().severe("UnstableCore required!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("fly").setExecutor(this);
        getCommand("vanish").setExecutor(this);
        getCommand("kick").setExecutor(this);
        getCommand("ban").setExecutor(this);
        getCommand("unban").setExecutor(this);
        getCommand("gamemode").setExecutor(this);
        getLogger().info("UnstableAdmin enabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("unstable.admin." + command.getName().toLowerCase())) {
            sender.sendMessage("§cNo permission!");
            return true;
        }

        switch (command.getName().toLowerCase()) {
            case "fly" -> {
                if (!(sender instanceof Player player)) return true;
                player.setAllowFlight(!player.getAllowFlight());
                player.sendMessage(player.getAllowFlight() ? "§aFly enabled" : "§cFly disabled");
            }
            case "vanish" -> {
                if (!(sender instanceof Player player)) return true;
                boolean vanished = !player.isInvisible();
                player.setInvisible(vanished);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (vanished) p.hidePlayer(this, player);
                    else p.showPlayer(this, player);
                }
                player.sendMessage(vanished ? "§aVanished" : "§aVisible");
            }
            case "kick" -> {
                if (args.length < 1) { sender.sendMessage("§cUsage: /kick <player> [reason]"); return true; }
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) target.kickPlayer(args.length > 1 ? String.join(" ", args).substring(args[0].length()+1) : "Kicked by admin");
            }
            case "ban" -> {
                if (args.length < 1) { sender.sendMessage("§cUsage: /ban <player> [reason]"); return true; }
                Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(args[0], args.length > 1 ? String.join(" ", java.util.Arrays.copyOfRange(args,1,args.length)) : "Banned", null, sender.getName());
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) target.kickPlayer("Banned");
                sender.sendMessage("§aBanned " + args[0]);
            }
            case "unban" -> {
                if (args.length < 1) { sender.sendMessage("§cUsage: /unban <player>"); return true; }
                Bukkit.getBanList(org.bukkit.BanList.Type.NAME).pardon(args[0]);
                sender.sendMessage("§aUnbanned " + args[0]);
            }
            case "gamemode" -> {
                if (args.length < 1) { sender.sendMessage("§cUsage: /gamemode <mode> [player]"); return true; }
                GameMode gm = switch (args[0].toLowerCase()) {
                    case "0", "s", "survival" -> GameMode.SURVIVAL;
                    case "1", "c", "creative" -> GameMode.CREATIVE;
                    case "2", "a", "adventure" -> GameMode.ADVENTURE;
                    case "3", "sp", "spectator" -> GameMode.SPECTATOR;
                    default -> null;
                };
                if (gm == null) { sender.sendMessage("§cInvalid gamemode"); return true; }
                Player target = args.length > 1 ? Bukkit.getPlayer(args[1]) : (sender instanceof Player p ? p : null);
                if (target != null) {
                    target.setGameMode(gm);
                    sender.sendMessage("§aSet gamemode of " + target.getName() + " to " + gm);
                }
            }
        }
        return true;
    }
}
