package org.maxhyperbeast.sklitebans.elements.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.registrations.EventValues;
import litebans.api.Events;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.Nullable;

import static org.bukkit.Bukkit.getLogger;

public class EvtBroadcast extends SkriptEvent {

    static {
        Skript.registerEvent("LiteBans Broadcast", EvtBroadcast.class, BroadcastEvent.class, "litebans broadcast [for %string%]");
        EventValues.registerEventValue(BroadcastEvent.class, String.class, BroadcastEvent::getMessage);
    }

    @Override
    public boolean init(Literal<?>[] literals, int i, SkriptParser.ParseResult parseResult) {
        return true;
    }

    @Override
    public boolean check(Event event) {
        return event instanceof BroadcastEvent;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "Litebans Broadcast Event";
    }
    public static class BroadcastEvent extends Event {
        private static final HandlerList handlers = new HandlerList();
        private final String message;
        private final String type;

        public BroadcastEvent(String message, String type) {
            super(true);
            this.message = message;
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public String getType() {
            return type;
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
