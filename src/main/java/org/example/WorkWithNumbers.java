package org.example;

import java.util.List;

public class WorkWithNumbers {
    private static final String FILENAME = "10m.txt";
    private static final String RESULTFILE = "result.txt";

    public static void main(String[] args) {
        DataCollectionTool dataCollectionTool = new DataCollectionTool(FILENAME);
        List<Integer> numbers = dataCollectionTool.readFromFile();
        DataProcessor dataProcessor = new DataProcessor(numbers);
        dataProcessor.writeToFile(RESULTFILE);
    }

}