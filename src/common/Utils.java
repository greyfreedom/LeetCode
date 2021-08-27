package src.common;

public class Utils {
    public static void printArray(int[] array) {
        if (array == null || array.length <= 0) return;
        for (int item : array) {
            System.out.print(item);
            System.out.print(", ");
        }
        System.out.println();
    }

    public static void printArray(int[][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) return;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
                System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
