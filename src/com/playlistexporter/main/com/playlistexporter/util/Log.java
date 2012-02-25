package com.playlistexporter.main.com.playlistexporter.util;

/**
 * @author aryan
 * @version 1/15/12
 */
public class Log {
    private static Log instance;

    private Log() {
    }

    public static Log createLog() {
        if (instance == null) {
            instance = new Log();
            return instance;
        } else
            return instance;
    }

    public void debug(String string) {
        System.out.println(string);
    }
}
