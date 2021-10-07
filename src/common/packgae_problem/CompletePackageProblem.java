package src.common.packgae_problem;

public class CompletePackageProblem {
    public void testCompletePackage() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        // 一维数组的写法，定义 dp 与 初始化 与 01 背包相同
        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;
        // 遍历顺序 物品相同，背包容量相反
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            printArray(dp);
        }
    }

    public void testCompletePackage2() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        // 二维数组方式，定义 dp 数组与 01 背包相同
        int[][] dp = new int[weight.length][bagWeight + 1];
        // 初始化不一样
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        // 初始化不一样
        for (int j = 0; j <= bagWeight; j++) {
            if (j >= weight[0]) {
                dp[0][j] = (j / weight[0]) * value[0];
            } else {
                dp[0][j] = 0;
            }
        }
        // 遍历顺序都是 正序
        for (int i = 1; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                // 状态转移方程不一样
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    private void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CompletePackageProblem completePackageProblem = new CompletePackageProblem();
        completePackageProblem.testCompletePackage();
        System.out.println("--------------");
        completePackageProblem.testCompletePackage2();
    }
}
