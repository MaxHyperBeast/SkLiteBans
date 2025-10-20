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

public class ExprEntryServerScope extends SimpleExpression<String> {
    static {
        Skript.registerExpression(ExprEntryServerScope.class, String.class, ExpressionType.SIMPLE, "server scope of %litebansentry%", "%litebansentry%'s server scope");
    }
    private Expression<Entry> entry;
    @Override
    protected String @Nullable [] get(Event event) {
        if (event instanceof EvtEntryAdded.EntryAddedEvent) {
            return new String[] {((EvtEntryAdded.EntryAddedEvent) event).getEntry().getServerScope()};
        }
        return null;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(@Nullable Event event, boolean b) {
        return "Entry Server Scope Expression";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
        entry = (Expression<Entry>) expressions[0];
        return true;
    }
}
