package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionStreams {

    public static Integer findMinValue(ArrayList<Integer> listFromFile) {
        return listFromFile.stream().min(Integer::compareTo).get();
    }

    public static Integer findMaxValue(ArrayList<Integer> listFromFile) {
        return listFromFile.stream().max(Integer::compareTo).get();
    }

    public static Float findMedian(ArrayList<Integer> listFromFile) {
        ArrayList<Integer> newCopyOfListFromFile = new ArrayList<>(listFromFile);
        Collections.sort(newCopyOfListFromFile);
        if (newCopyOfListFromFile.size() % 2 == 0) {
            return (float) (newCopyOfListFromFile.get(newCopyOfListFromFile.size() / 2)
                    + newCopyOfListFromFile.get(newCopyOfListFromFile.size() / 2 - 1)) / 2;
        } else
            return (float) newCopyOfListFromFile.get(newCopyOfListFromFile.size() / 2);
    }

    public static Float findAverageValue(ArrayList<Integer> listFromFile) {
        return (float) listFromFile.stream().mapToInt(Integer::intValue).sum() / listFromFile.stream().count();
    }

    public static StringBuilder convertMapToString(HashMap<Integer, Integer> map, ArrayList<Integer> listFromFile) {
        StringBuilder stringOfLists = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            stringOfLists.append("Список елементов: ");
            for (int i = entry.getKey(); i < entry.getKey() + entry.getValue(); i++) {
                stringOfLists.append(listFromFile.get(i) + " ");
            }
        }
        return stringOfLists;
    }

    public static HashMap<Integer, Integer> listOfIncreasing(ArrayList<Integer> listFromFile) {

        HashMap<Integer, Integer> positionAndLength = new HashMap<>();

        int length = 1, maxLength = 1;
        for (int i = 1; i < listFromFile.size(); i++) {
            if (listFromFile.get(i) > listFromFile.get(i - 1)) {
                ++length;
                if (length >= maxLength && length != 1) {
                    if(!positionAndLength.containsValue(length))
                        positionAndLength.clear();
                    positionAndLength.put(i - length + 1, length);
                    maxLength = length;
                }
            } else {
                length = 1;
            }
        }
        return positionAndLength;
    }

    public static HashMap<Integer, Integer> listOfDecreasing(ArrayList<Integer> listFromFile) {

        HashMap<Integer, Integer> positionAndLength = new HashMap<>();

        int length = 1, maxLength = 1;
        for (int i = 1; i < listFromFile.size(); i++) {
            if (listFromFile.get(i) < listFromFile.get(i - 1)) {
                ++length;
                if (length >= maxLength && length != 1) {
                    if(!positionAndLength.containsValue(length))
                        positionAndLength.clear();
                    positionAndLength.put(i - length + 1, length);
                    maxLength = length;
                }
            } else {
                length = 1;
            }
        }
        return positionAndLength;
    }
}
