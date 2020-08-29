package classicAlgorithms;

public class EightQueen {
    private static int[][] a;
    private static int num;

    static {
        a = new int[8][8];
        num = 0;
    }

    public static void findQueen(int row) {
        if (row == 8) {
            num++;
            print();
            return;
        }

        for (int column = 0; column < a.length; column++) {
            if (check(row, column)) {
                a[row][column] = 1;
                findQueen(row + 1);
                a[row][column] = 0;
            }
        }
    }

    private static boolean check(int row, int column) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][column] == 1)
                return false;
        }

        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {  //检测左上角
            if (a[i][j] == 1)
                return false;
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j < a.length; i--, j++) { // 检测右上角
            if (a[i][j] == 1)
                return false;
        }

        return true;
    }

    private static void print() {
        System.out.println("第" + num + "八皇后问题解");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {

        //System.out.println();
        findQueen(0);

    }


}
