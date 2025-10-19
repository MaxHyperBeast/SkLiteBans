package org.maxhyperbeast.sklitebans;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;

import java.io.IOException;

public final class SkLiteBans extends JavaPlugin {

    SkLiteBans instance;
    SkriptAddon addon;

    @Override
    public void onEnable() {
        if (!getServer().getPluginManager().isPluginEnabled("Skript")) {
            getLogger().severe("Skript is required but not found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        if (!getServer().getPluginManager().isPluginEnabled("LiteBans")) {
            getLogger().severe("LiteBans is required but not found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        addon = Skript.registerAddon(this);

        try {
            addon.loadClasses("org.maxhyperbeast.sklitebans", "elements");

            getLogger().info("Successfully registered SkLiteBans addon!");
        } catch (IOException e) {
            getLogger().severe("Failed to load SkLiteBans syntax: " + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("SkLiteBans Disabled");
    }

    public SkLiteBans getInstance() {
        return instance;
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }
}
