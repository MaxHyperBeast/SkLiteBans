package org.maxhyperbeast.sklitebans.elements.expressions;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import litebans.api.Entry;
import org.bukkit.event.Event;
import org.jetbrains.annotations.Nullable;
import org.maxhyperbeast.sklitebans.elements.events.EvtEntryAdded;

public class ExprEntryDateEnd extends SimpleExpression<Long> {
    static {
        Skript.registerExpression(ExprEntryDateEnd.class, Long.class, ExpressionType.SIMPLE, "date end of %litebansentry%", "%litebansentry%'s date end");
    }
    private Expression<Entry> entry;
    @Override
    protected Long @Nullable [] get(Event event) {
        if (event instanceof EvtEntryAdded.EntryAddedEvent) {
            return new Long[] {((EvtEntryAdded.EntryAddedEvent) event).getEntry().getDateEnd()};
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
        return "Entry Date End Expression";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        entry = (Expression<Entry>) expressions[0];
        return true;
    }
}
