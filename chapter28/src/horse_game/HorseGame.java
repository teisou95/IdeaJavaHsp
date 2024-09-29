package horse_game;

import java.util.Random;

/**
 * 马踏棋盘 算法
 */
public class HorseGame {
    static int size = 5;
    static int[][] board = new int[size][size];
    static int[] position = new int[2];
    static int count;
    static int[] order = new int[8];
    // 初始坐标
    static Random random = new Random();

    static final int x0 = random.nextInt(size);
    static final int y0 = random.nextInt(size);
//    static final int x0 = 5;
//    static final int y0 = 2;

    static {
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        reorder();
        rollback();
    }

    public static void main(String[] args) {
        int trySum = 0;
        while (!move(order)) {
            System.out.println("第" + (++trySum) + "次尝试");
            if (trySum == 100000) return;
            reorder();
            rollback();
        }
        System.out.println("成功,总计尝试" + (trySum + 1) + "次,正解如下:");
        printBoard();

    }

    // 打乱顺序 洗牌算法 随即交换
    public static void reorder() {
        for (int i = order.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = order[i];
            order[i] = order[j];
            order[j] = temp;
        }
    }

    // 初始化
    public static void rollback() {
        count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = -1;
            }
        }
        position[0] = x0;
        position[1] = y0;
        board[position[0]][position[1]] = count++;
    }

    // 移动
    public static boolean move(int[] order) {
        if (count == size * size) {
            return true;
        }
        // key = order[0] -> order[7] 尝试走下一步
        for (int i = 0; i < order.length; i++) {
            if (next(order[i])) {
                return move(order);
            }
        }
        return false;
    }

    // 打印棋盘
    public static void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 走下一步
     *
     * @param key 8个策略
     * @return 是否能走下一步
     */
    public static boolean next(int key) {
        int nextX = 0;
        int nextY = 0;
        switch (key) {
            case 0:
                nextX = -1;
                nextY = -2;
                break;
            case 1:
                nextX = -1;
                nextY = 2;
                break;
            case 2:
                nextX = 1;
                nextY = -2;
                break;
            case 3:
                nextX = 1;
                nextY = 2;
                break;
            case 4:
                nextX = -2;
                nextY = -1;
                break;
            case 5:
                nextX = -2;
                nextY = 1;
                break;
            case 6:
                nextX = 2;
                nextY = -1;
                break;
            case 7:
                nextX = 2;
                nextY = 1;
                break;
        }
        int x = position[0] + nextX;
        int y = position[1] + nextY;
        if (x >= 0 && x <= size - 1 && y >= 0 && y <= size - 1 && board[x][y] == -1) { // 下一步可以走
            board[x][y] = count++;
            position[0] = x;
            position[1] = y;
            return true;
        }
        return false;
    }
}
