package src.leetcode.easy.p119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // 同一行递推公式：
    // Cnm = Cnm-1 * ((n - m + 1) / m)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            long tmp = (long) row.get(i - 1) * (rowIndex - i + 1) / i;
            row.add((int) tmp);
        }
        return row;
    }
}
