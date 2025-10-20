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

public class EvtEntryAdded extends SkriptEvent {

    static {
        Skript.registerEvent("LiteBans Entry Added", EvtEntryAdded.class, EvtEntryAdded.EntryAddedEvent.class, "litebans entry added");
        EventValues.registerEventValue(EvtEntryAdded.EntryAddedEvent.class, Entry.class, EvtEntryAdded.EntryAddedEvent::getEntry);
    }

    @Override
    public boolean init(Literal<?>[] literals, int i, SkriptParser.ParseResult parseResult) {

        return true;
    }

    @Override
    public boolean check(Event event) {
        return event instanceof EvtEntryAdded.EntryAddedEvent;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "Litebans Entry Added";
    }

    public static class EntryAddedEvent extends Event {
        private static final HandlerList handlers = new HandlerList();
        private final Entry entry;

        public EntryAddedEvent(Entry entry) {
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
