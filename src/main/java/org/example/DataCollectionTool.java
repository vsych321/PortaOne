package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCollectionTool {
    private final String fileName;
    public DataCollectionTool(String fileName) {
        this.fileName = fileName;
    }

    public List<Integer> readFromFile() {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value;
        while ((value = bufferedReader.readLine()) != null) {
            String[] split = value.split(System.lineSeparator());
            for (String s : split) {
                numbers.add(Integer.parseInt(s));
            }
        }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file",e);
        }
        return numbers;
    }
}
