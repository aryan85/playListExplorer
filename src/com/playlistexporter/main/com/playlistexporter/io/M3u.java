package com.playlistexporter.main.com.playlistexporter.io;

import com.playlistexporter.main.com.playlistexporter.dto.Track;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author aryan
 * @version 1/14/12
 */
public class M3u extends Playlist {


    @Override
    public Collection<Track> readPlayList(String fileName) {
        DataInputStream in = null;
        try {
            in = new DataInputStream(read(fileName));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            Set<Track> result = new HashSet<Track>();
            while ((strLine = br.readLine()) != null) {
                if (strLine.startsWith("File")) {
                    Track track = new Track();
                    track.setPath(strLine.substring(strLine.indexOf('=')+1,strLine.length()));
                    track.setName(strLine.substring(strLine.lastIndexOf("/"), strLine.length()));
                    result.add(track);
                }
            }
            return result;
        } catch (Exception e) {
            logger.debug("Error: " + e.getMessage());
            return Collections.emptyList();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    logger.debug(e.getMessage());
                }
        }
    }
}
