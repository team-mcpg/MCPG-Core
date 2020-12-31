package fr.milekat.MCPG_Core.utils;

public class CmdUtils {
    public static String getArgs(Integer skipedargs, String... args) {
        StringBuilder sb = new StringBuilder();
        int loop = 1;
        for (String string : args) {
            if (loop < skipedargs) continue;
            sb.append(string);
            sb.append(" ");
            loop++;
        }
        return sb.toString();
    }
}
