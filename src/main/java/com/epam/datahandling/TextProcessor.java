package com.epam.datahandling;

import com.epam.datahandling.lexis.Text;

import java.io.*;
import java.nio.file.Files;

public class TextProcessor {

    public Text parse(File src) {
        try {
            return new Text(Files.readString(src.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
