package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private final List<Integer> numbers;

    public DataProcessor(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void writeToFile(String toFileName) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(getResult());
        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
    }

    private int findMax() {
        int max = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (max < n) {
                max = n;
            }
        }
        return max;
    }

    private int findMin() {
        int min = Integer.MAX_VALUE;
        for (int n : numbers) {
            if (min > n) {
                min = n;
            }
        }
        return min;
    }

    private double findMedian() {
        List<Integer> sorted = numbers.stream()
                .sorted()
                .toList();
        int median = numbers.size() / 2;

        if (sorted.size() % 2 != 0) {
            return sorted.get(median);
        }
        return (double) (sorted.get(median) + sorted.get(median)) / 2;
    }

    private double findAverage() {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.size();
    }

    private List<Integer> findLongestIncreasingSequence() {
        int currentLength = 1;
        int currentStart = 0;

        int maxLength = 0;
        int startOfMaxSequence = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) <= numbers.get(i - 1)) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startOfMaxSequence = currentStart;
                }
            } else {
                currentLength = 1;
                currentStart = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = startOfMaxSequence; i < startOfMaxSequence + maxLength; i++) {
            result.add(numbers.get(i));
        }
        return result;
    }

    private List<Integer> findLongestDecreasingSequence() {
        int currentLength = 1;
        int currentStart = 0;

        int maxLength = 0;
        int startOfMaxSequence = 0;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) >= numbers.get(i - 1)) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    startOfMaxSequence = currentStart;
                }
            } else {
                currentLength = 1;
                currentStart = i;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = startOfMaxSequence; i < startOfMaxSequence + maxLength; i++) {
            result.add(numbers.get(i));
        }
        return result;
    }

    private String getResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("Max value: ").append(findMax());
        sb.append("\n Min value: ").append(findMin());
        sb.append("\n Median: ").append(findMedian());
        sb.append("\n Average: ").append(findAverage());
        sb.append("\n The Longest Increasing Sequence: ").append(findLongestIncreasingSequence());
        sb.append("\n The Longest Decreasing Sequence: ").append(findLongestDecreasingSequence());
        return sb.toString();
    }
}
