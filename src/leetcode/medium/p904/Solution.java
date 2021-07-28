package src.leetcode.medium.p904;

import java.util.HashMap;

// [3,3,3,1,2,1,1,2,3,3,4]
class Solution {
    public int totalFruit(int[] fruits) {
       Counter counter = new Counter();
       int res = 0, left = 0;
       for (int right = 0; right < fruits.length; right++) {
           counter.addCount(fruits[right]);
           if (counter.size() <= 2) {
               res = Math.max(res, right - left + 1);
           } else {
               while (counter.size() > 2) {
                   counter.removeCount(fruits[left++]);
               }
           }
       }
       return res;
    }
}

class Counter {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public void addCount(int key) {
        map.put(key, getCount(key) + 1);
    }

    public void removeCount(int key) {
        if (map.containsKey(key)) {
            map.put(key, getCount(key) - 1);
            if (map.get(key) <= 0) {
                map.remove(key);
            }
        }
    }

    private int getCount(int key) {
        return map.containsKey(key) ? map.get(key) : 0;
    }

    public int size() {
        return map.size();
    }
}
