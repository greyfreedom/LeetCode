package src.leetcode.medium.p452;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        int res = 1;
        int minRight = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > minRight) {
                res++;
                minRight = points[i][1];
            } else {
                minRight = Math.min(minRight, points[i][1]);
            }
        }
        return res;
    }
}
