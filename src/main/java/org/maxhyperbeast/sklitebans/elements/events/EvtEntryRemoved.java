package org.maxhyperbeast.sklitebans.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import litebans.api.Entry;
import litebans.api.Events;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;

public class EvtEntryRemoved extends SkriptEvent {

    static {
        Skript.registerEvent("LiteBans Entry Added", EvtEntryRemoved.class, EvtEntryRemoved.EntryRemovedEvent.class, "litebans entry removed");
        EventValues.registerEventValue(EvtEntryRemoved.EntryRemovedEvent.class, Entry.class, EvtEntryRemoved.EntryRemovedEvent::getEntry);
    }

    Literal<Entry> entry;

    @Override
    public boolean init(Literal<?>[] literals, int i, SkriptParser.ParseResult parseResult) {
        entry = (Literal<Entry>) literals[0];
        Events.get().register(new Events.Listener() {
            @Override
            public void entryAdded(Entry entry) {
                EvtEntryRemoved.EntryRemovedEvent event = new EvtEntryRemoved.EntryRemovedEvent(entry);
                org.bukkit.Bukkit.getPluginManager().callEvent(event);
            }
        });
        return true;
    }

    @Override
    public boolean check(Event event) {
        return event instanceof EvtEntryRemoved.EntryRemovedEvent;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "Litebans Entry Removed Event";
    }

    public static class EntryRemovedEvent extends Event {
        private static final HandlerList handlers = new HandlerList();
        private final Entry entry;

        public EntryRemovedEvent(Entry entry) {
            super(true);
            this.entry = entry;
        }

        public Entry getEntry() {
            return entry;
        }

        @Override
        public HandlerList getHandlers() {
            return handlers;
        }
        public static HandlerList getHandlerList() {
            return handlers;
        }
    }
}
