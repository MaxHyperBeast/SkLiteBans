package org.maxhyperbeast.sklitebans.elements;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import litebans.api.Entry;
import org.bukkit.Location;
import org.bukkit.Raid;

import javax.annotation.Nullable;

public class ClassInfos {

    static {
        Classes.registerClass(new ClassInfo<>(Entry.class, "litebans entry")
                .user("litebans entr(y|ies)")
                .name("Entry")
                .description("Represents a LiteBans Entry, in simple terms it's the punishment itself")
                .examples("id of entry", "reason of entry", "type of entry")
                .defaultExpression(new EventValueExpression<>(Entry.class))
                .parser(new Parser<Entry>() {
                    @Override
                    public String toString(Entry entry, int i) {
                        return "entry";
                    }

                    @Override
                    public String toVariableNameString(Entry entry) {
                        return Long.toString(entry.getId());
                    }
                }));
    }

}