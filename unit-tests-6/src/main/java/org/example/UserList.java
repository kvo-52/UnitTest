package org.example;

import java.util.Arrays;
import java.util.List;

public class UserList {

    public List<Integer> firstList;
    public List<Integer> secondList;

    public UserList(List<Integer> firstList, List<Integer> secondList) {
        this.firstList = firstList;
        this.secondList = secondList;
    }

    public double calculateAverageValueList(List<Integer> nums) {
        double sum = nums.stream().reduce(0, Integer::sum);
        return sum / nums.size();
    }

    public String compareAvgValueLists(List<Integer> numsOne, List<Integer> numsTwo) {
        double firstAvg = calculateAverageValueList(numsOne);
        double secondAvg = calculateAverageValueList(numsTwo);

        String result;
        if (firstAvg > secondAvg) {
            result = "Первый список имеет большее среднее значение";
        } else if (firstAvg < secondAvg) {
            result = "Второй список имеет большее среднее значение";
        } else {
            result = "Средние значения равны";
        }

        return result;
    }

    public String compareAvgValueLists() {
        return compareAvgValueLists(firstList, secondList);
    }
}