package com.txmmyyt.unstablecrates;

import com.txmmyyt.unstablecrates.command.CrateCommand;
import com.txmmyyt.unstablecrates.manager.CrateManager;
import com.txmmyyt.unstablecrates.manager.KeyManager;
import org.bukkit.plugin.java.JavaPlugin;

public class UnstableCrates extends JavaPlugin {

    private static UnstableCrates instance;
    private CrateManager crateManager;
    private KeyManager keyManager;

    @Override
    public void onEnable() {
        instance = this;
        if (getServer().getPluginManager().getPlugin("UnstableCore") == null) {
            getLogger().severe("UnstableCore required! Disabling.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        saveDefaultConfig();
        crateManager = new CrateManager(this);
        keyManager = new KeyManager(this);

        getCommand("crate").setExecutor(new CrateCommand(this));

        getLogger().info("UnstableCrates enabled with 5 crate types.");
    }

    @Override
    public void onDisable() {
        if (crateManager != null) crateManager.saveAll();
        getLogger().info("UnstableCrates disabled.");
    }

    public static UnstableCrates getInstance() { return instance; }
    public CrateManager getCrateManager() { return crateManager; }
    public KeyManager getKeyManager() { return keyManager; }
}
