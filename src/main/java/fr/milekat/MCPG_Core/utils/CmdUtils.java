package fr.milekat.MCPG_Core.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class CmdUtils {
    public static String getArgs(Integer skipedargs, String... args) {
        StringBuilder sb = new StringBuilder();
        int loop = 1;
        for (String string : args) {
            if (loop <= skipedargs) continue;
            sb.append(string);
            sb.append(" ");
            loop++;
        }
        return sb.toString();
    }

    /**
     * Get true/false from Bukkit command arg
     */
    public static ArrayList<String> getBool(String arg) {
        if ("true".startsWith(arg.toLowerCase(Locale.ROOT))) {
            return new ArrayList<>(Collections.singletonList("true"));
        } else if ("false".startsWith(arg.toLowerCase(Locale.ROOT))) {
            return new ArrayList<>(Collections.singletonList("false"));
        } else return null;
    }
}
