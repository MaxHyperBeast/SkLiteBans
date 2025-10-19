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

public class CondEntryHasTemplate extends Condition {

    static {
        Skript.registerCondition(CondEntryIsSilent.class, "%litebans entry% (1¦has|2¦does(n't| not) have) template");
    }
    Expression<Entry> entry;

    @Override
    public boolean check(Event event) {
        if (event instanceof EvtEntryAdded.EntryAddedEvent) {
            return ((EvtEntryAdded.EntryAddedEvent) event).getEntry().hasTemplate();
        }
        return false;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "Entry Has Template Condition";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        entry = (Expression<Entry>) expressions[0];
        return true;
    }
}
