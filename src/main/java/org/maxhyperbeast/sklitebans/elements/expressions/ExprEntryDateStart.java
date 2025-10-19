package org.maxhyperbeast.sklitebans.elements.expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import litebans.api.Entry;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;
import org.maxhyperbeast.sklitebans.elements.events.EvtEntryAdded;

public class ExprEntryDateStart extends SimpleExpression<Long> {

    private Expression<Entry> entry;
    @Override
    protected Long @Nullable [] get(Event event) {
        if (event instanceof EvtEntryAdded.EntryAddedEvent) {
            return new Long[] {((EvtEntryAdded.EntryAddedEvent) event).getEntry().getDateStart()};
        }
        return null;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends Long> getReturnType() {
        return Long.class;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "Entry Date Start Expression";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        entry = (Expression<Entry>) expressions[0];
        return true;
    }
}
