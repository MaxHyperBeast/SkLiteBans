package org.maxhyperbeast.sklitebans;

import litebans.api.Entry;
import litebans.api.Events;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.maxhyperbeast.sklitebans.elements.events.EvtBroadcast;
import org.maxhyperbeast.sklitebans.elements.events.EvtEntryAdded;
import org.maxhyperbeast.sklitebans.elements.events.EvtEntryRemoved;

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

        } catch (IOException e) {
            getLogger().severe("Failed to load SkLiteBans syntax: " + e.getMessage());
            getServer().getPluginManager().disablePlugin(this);
        }
        Events.get().register(new Events.Listener() {
            @Override
            public void entryAdded(Entry entry) {
                EvtEntryAdded.EntryAddedEvent event = new EvtEntryAdded.EntryAddedEvent(entry);
                org.bukkit.Bukkit.getPluginManager().callEvent(event);
            }
            @Override
            public void entryRemoved(Entry entry) {
                EvtEntryRemoved.EntryRemovedEvent event = new EvtEntryRemoved.EntryRemovedEvent(entry);
                org.bukkit.Bukkit.getPluginManager().callEvent(event);
            }
            @Override
            public void broadcastSent(String message, String type) {
                EvtBroadcast.BroadcastEvent event = new EvtBroadcast.BroadcastEvent(message, type);
                org.bukkit.Bukkit.getPluginManager().callEvent(event);
            }
        });
        getLogger().info("Successfully registered SkLiteBans addon!");
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
