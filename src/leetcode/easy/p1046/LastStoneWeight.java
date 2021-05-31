package src.leetcode.easy.p1046;

import java.util.Arrays;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        int index = stones.length - 1;
        while (index > 0) {
            Arrays.sort(stones, 0, index + 1);
            int left = Math.abs(stones[index] - stones[index - 1]);
            if (left == 0) {
                stones[index] = 0;
                stones[index - 1] = 0;
                index -= 2;
            } else {
                stones[index] = left;
                stones[index - 1] = left;
                index -= 1;
            }
        }
        return stones[0];
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})); // 1
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{1, 10, 3, 21, 8})); // 1
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{5})); // 5
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2, 2})); // 0
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{7, 6, 7, 6, 9})); // 3
    }
}
