package com.playlistexporter.main.com.playlistexporter.io;

import com.playlistexporter.main.com.playlistexporter.util.Log;

import java.io.*;

/**
 * @author aryan
 * @version 1/15/12
 */
public class Operation {
    public static Log logger = Log.createLog();

    public static void copy(String source, String destination) {
        InputStream in = null;
        OutputStream out = null;
        try {
            File sourceFile = new File(source);
            File destinationFile = new File(destination);
            if(!destinationFile.exists())
                destinationFile.createNewFile();
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destinationFile);

            byte[] buf = new byte[in.available() + 1];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            logger.debug(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug(e.getMessage());
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IOException e) {
                logger.debug(e.getMessage());
            }
        }
    }
}
