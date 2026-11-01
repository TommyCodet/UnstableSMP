package com.txmmyyt.unstableclans;

import com.txmmyyt.unstableclans.command.ClanCommand;
import com.txmmyyt.unstableclans.manager.ClanManager;
import org.bukkit.plugin.java.JavaPlugin;

public class UnstableClans extends JavaPlugin {

    private static UnstableClans instance;
    private ClanManager clanManager;

    @Override
    public void onEnable() {
        instance = this;
        if (getServer().getPluginManager().getPlugin("UnstableCore") == null) {
            getLogger().severe("UnstableCore required!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        saveDefaultConfig();
        clanManager = new ClanManager(this);
        getCommand("clan").setExecutor(new ClanCommand(this));
        getLogger().info("UnstableClans enabled.");
    }

    @Override
    public void onDisable() {
        if (clanManager != null) clanManager.saveAll();
        getLogger().info("UnstableClans disabled.");
    }

    public static UnstableClans getInstance() { return instance; }
    public ClanManager getClanManager() { return clanManager; }
}
