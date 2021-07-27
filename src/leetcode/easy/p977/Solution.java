package src.leetcode.easy.p977;

class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }
        int neIndex = -1, poIndex = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                poIndex = i;
                break;
            }
        }
        neIndex = poIndex - 1;
        int[] result = new int[nums.length];
        int index = 0;
        while (neIndex >= 0 && poIndex < nums.length) {
            int ne = -nums[neIndex];
            int po = nums[poIndex];
            if (ne <= po) {
                neIndex--;
                result[index++] = ne * ne;
            } else {
                poIndex++;
                result[index++] = po * po;
            }
        }
        while (neIndex >= 0) {
            result[index++] = nums[neIndex] * nums[neIndex];
            neIndex--;
        }
        while (poIndex < nums.length) {
            result[index++] = nums[poIndex] * nums[poIndex];
            poIndex++;
        }
        return result;
    }
}
