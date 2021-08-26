package src.common.packgae_problem;

public class CompletePackageProblem {
    public void testCompletePackage() {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;

        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;
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

        int[][] dp = new int[weight.length][bagWeight + 1];
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= bagWeight; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = bagWeight; j >=weight[i]; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
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
