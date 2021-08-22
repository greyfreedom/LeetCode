package src.leetcode.medium.p406;

import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int[] item : people) {
            list.add(item[1], item);
        }
        return list.toArray(new int[0][]);
    }
}
