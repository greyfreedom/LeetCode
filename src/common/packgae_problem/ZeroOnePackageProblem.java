package src.common.packgae_problem;

public class ZeroOnePackageProblem {
    // 使用 DP 数组实现 01背包问题
    public void testZeroOnePackageProblem(int[] weight, int[] value, int bagSize) {
        // dp[i][j] 表示 从 0 - i 物品中拿一个放入容量为 j 的背包中，能够获得的最大价值
        int[][] dp = new int[weight.length][bagSize + 1];
        // 初始化 dp 数组
        // 任何物品，放入容量为 0 的背包，能够获得最大价值为 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // 下标为 0 的物品，放入 0 - bagSize 的背包中，能放进去就获得 value[0]，放不进去就获得 0
        for (int j = 0; j <= bagSize; j++) {
            if (weight[0] > j) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = value[0];
            }
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    // 使用一维数组（滚动数组）实现
    public void testZeroOnePackageProblem2(int[] weight, int[] value, int bagSize) {
        // dp[i] 表示容量为 i 的背包，能够装下物品的最高价值
        int[] dp = new int[bagSize + 1];

        dp[0] = 0;

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i]);
            System.out.print(", ");
        }
    }


    public static void main(String[] args) {
        ZeroOnePackageProblem problem = new ZeroOnePackageProblem();
        problem.testZeroOnePackageProblem(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4);
        problem.testZeroOnePackageProblem2(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4);
    }
}
