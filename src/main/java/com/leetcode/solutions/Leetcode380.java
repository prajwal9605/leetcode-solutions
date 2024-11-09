package com.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode380 {

    Map<Integer, Integer> map;
    List<Integer> list;

    public Leetcode380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int lastNum = list.get(list.size() - 1);
            int index = map.get(val);
            list.set(index, lastNum);
            map.put(lastNum, index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomIndex = (int) (Math.random() * list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        Leetcode380 leetcode380 = new Leetcode380();
        System.out.println(leetcode380.insert(1));
        System.out.println(leetcode380.remove(2));
        System.out.println(leetcode380.insert(2));
        System.out.println(leetcode380.getRandom());
        System.out.println(leetcode380.remove(1));
        System.out.println(leetcode380.insert(2));
        System.out.println(leetcode380.getRandom());
    }
}
