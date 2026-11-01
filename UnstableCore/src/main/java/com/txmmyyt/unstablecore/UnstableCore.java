package com.txmmyyt.unstablecore;

import com.txmmyyt.unstablecore.api.UnstableAPI;
import com.txmmyyt.unstablecore.database.DatabaseManager;
import com.txmmyyt.unstablecore.manager.ConfigManager;
import com.txmmyyt.unstablecore.manager.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

public class UnstableCore extends JavaPlugin {

    private static UnstableCore instance;
    private DatabaseManager databaseManager;
    private ConfigManager configManager;
    private MessageManager messageManager;
    private UnstableAPI api;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        configManager = new ConfigManager(this);
        messageManager = new MessageManager(this);
        databaseManager = new DatabaseManager(this);

        try {
            databaseManager.connect();
            getLogger().info("Database connected successfully.");
        } catch (Exception e) {
            getLogger().severe("Failed to connect to database: " + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        api = new UnstableAPI(this);

        getLogger().info("UnstableCore enabled! API ready for other Unstable plugins.");
    }

    @Override
    public void onDisable() {
        if (databaseManager != null) {
            databaseManager.disconnect();
        }
        getLogger().info("UnstableCore disabled.");
    }

    public static UnstableCore getInstance() {
        return instance;
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }

    public UnstableAPI getAPI() {
        return api;
    }
}
