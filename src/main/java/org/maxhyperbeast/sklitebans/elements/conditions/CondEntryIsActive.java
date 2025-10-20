package org.maxhyperbeast.sklitebans.elements.conditions;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import litebans.api.Entry;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;
import ch.njol.skript.Skript;
import org.maxhyperbeast.sklitebans.elements.events.EvtEntryAdded;

public class CondEntryIsActive extends Condition {

    static {
        Skript.registerCondition(CondEntryIsSilent.class, "%litebansentry% is active", "%litebansentry% is(n't| not) active");
    }
    Expression<Entry> entry;

    @Override
    public boolean check(Event event) {
        if (event instanceof EvtEntryAdded.EntryAddedEvent) {
            return ((EvtEntryAdded.EntryAddedEvent) event).getEntry().isActive();
        }
        return false;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "Entry Is Active Condition";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        setNegated(i == 2);
        entry = (Expression<Entry>) expressions[0];
        return true;
    }
}
