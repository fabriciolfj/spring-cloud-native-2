package com.github.fabriciolfj.bddintegrationtransaction;

import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class BddTestUtil {

    public static String readFile(final String file) {
        JSONParser parser = new JSONParser();
        try {
            return parser.parse(new FileReader(file)).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
