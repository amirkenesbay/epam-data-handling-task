package com.epam.datahandling.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BackupUtils {
    private static final Logger LOGGER = LogManager.getLogger(BackupUtils.class);

    /**
     * Backup file. Create backup file if it is not exists. Override existing backup.
     *
     * @param src  Path to the source file
     * @param dest Path to backup file
     * @throws IOException If source file is not exist
     */
    public static void backup(String src, String dest) throws IOException {
        if (new File(src).exists()) {
            Files.createDirectories(Paths.get(dest).getParent());
            try (FileInputStream fileInputStream = new FileInputStream(src);
                 FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
                int contentAvailability;
                do {
                    contentAvailability = fileInputStream.read();
                    if (contentAvailability != -1) {
                        fileOutputStream.write(contentAvailability);
                    }
                } while (contentAvailability != -1);
            } catch (IOException e) {
                LOGGER.error("One of streams cannot be closed", e);
            }
        }
    }
}
