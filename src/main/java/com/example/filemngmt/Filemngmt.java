package com.example.filemngmt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Filemngmt {
    // static final String fileLocation = "../HashedPW.txt";
    static final String fileLocation = "HashedPW.txt";
    static final String fileLocationBU = "HashedPWBU.txt";
    private ArrayList<Row> rows = new ArrayList<Row>();

    public Filemngmt() throws IOException {
        readFile();
    }

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileLocation));
        String line;
        while ((line = br.readLine()) != null) {
            String[] splitted = line.split(":");
            Row row = new Row(Integer.parseInt(splitted[0]), splitted[1], splitted[2]); // splitted[...]
            rows.add(row);
        }
        br.close();
        return;
    }

    public void writeFile(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        for (Row row : rows) {
            writer.write(row.toString());
            writer.write("\n");
        }
        writer.close();
        return;
    }

    public void writeFiles() throws IOException {
        writeFile(fileLocation);
        writeFile(fileLocationBU);
        return;
    }

    public void terminalOutput() {
        for (Row row : rows) {
            System.out.println(row.prettyPrint());
        }
    }

    public String getHash(int number) {
        return rows.get(number).hash();
    }

    public void addPw(int number, String hint, String hash) {
        try {
            rows.remove(number);
        } catch (Exception e) {
        }
        rows.add(number, new Row(number, hint, hash));
    }
}
