package com.playlistexporter.main.com.playlistexporter.io;

import com.playlistexporter.main.com.playlistexporter.dto.Track;
import com.playlistexporter.main.com.playlistexporter.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;

/**
 * @author aryan
 * @version 1/14/12
 */
public abstract class Playlist {
    public static Log logger = Log.createLog();

    protected InputStream read(String fileName) {
        try {
            return new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            logger.debug(e.getMessage());
            return null;
        }
    }

    public abstract Collection<Track> readPlayList(String fileName);
}
