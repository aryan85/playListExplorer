package com.playlistexporter.main;

import com.playlistexporter.main.com.playlistexporter.dto.Track;
import com.playlistexporter.main.com.playlistexporter.gui.MainFrame;
import com.playlistexporter.main.com.playlistexporter.io.M3u;
import com.playlistexporter.main.com.playlistexporter.io.Operation;
import com.playlistexporter.main.com.playlistexporter.io.Playlist;
import com.playlistexporter.main.com.playlistexporter.util.Validation;

import javax.swing.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author aryan
 */
public class Main {
    private final static String homePath ="/home/aryan/";
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("hi, please enter the path of your playList...");
       String playListPath = scanner.next();
       if (Validation.isEmpty(playListPath)) {
           printHelp();
       }
       System.out.println(" and enter the destination path of your songs");
       String destination = scanner.next();
       if (Validation.isEmpty(destination)) {
           printHelp();
       }
       long startTime = System.currentTimeMillis();
       Playlist playlist = new M3u();
       Collection<Track> tracks = playlist.readPlayList(playListPath);
       for (Track track : tracks) {
           String source = homePath + track.getPath();
           String destination1 = destination + track.getName();
           Operation.copy(source, destination1);
           System.out.println("copy "+source);
           System.out.println("to "+destination1);
       }
       System.out.println("export done in " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static void printHelp() {
        System.out.println("please enter valid path");
        System.exit(0);
    }
}
