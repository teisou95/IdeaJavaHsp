package horse_game;

import java.util.Random;

/**
 * 马踏棋盘算法，使用递归 + 回溯
 */
public class ChatGPTHorseGame {
    static int size = 7; // 棋盘大小（可调整）
    static int[][] board = new int[size][size]; // 棋盘
    static int count; // 步数计数
    static int[] position = new int[2]; // 当前马的位置
    static int[] order = new int[8]; // 移动方向顺序
    static Random random = new Random(); // 随机数生成器

    // 马移动的8个方向的位移（x,y）
    static final int[][] MOVES = {
            {-1, -2}, {-1, 2}, {1, -2}, {1, 2},
            {-2, -1}, {-2, 1}, {2, -1}, {2, 1}
    };

    // 起始坐标（随机生成）
    static final int x0 = random.nextInt(size);
    static final int y0 = random.nextInt(size);

    static {
        for (int i = 0; i < order.length; i++) {
            order[i] = i;
        }
        shuffleOrder(); // 打乱初始顺序
        resetBoard(); // 初始化棋盘
    }

    public static void main(String[] args) {
        int attempts = 0;
        while (!solve()) { // 不断尝试直到找到解决方案
            System.out.println("第" + (++attempts) + "次尝试");
            shuffleOrder(); // 每次尝试重新打乱顺序
            resetBoard(); // 重置棋盘
        }
        System.out.println("初始坐标: (" + x0 + ", " + y0 + ")");
        System.out.println("成功, 尝试次数: " + (attempts + 1));
        printBoard(); // 打印结果棋盘
    }

    // 打乱方向顺序，使用Fisher-Yates洗牌算法
    public static void shuffleOrder() {
        for (int i = order.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = order[i];
            order[i] = order[j];
            order[j] = temp;
        }
    }

    // 重置棋盘并初始化马的起始位置
    public static void resetBoard() {
        count = 1; // 重置步数
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = -1; // 初始化棋盘为空白
            }
        }
        board[x0][y0] = 0; // 起始点为第0步
        position[0] = x0;
        position[1] = y0;
    }

    // 解决棋盘，返回是否找到解
    public static boolean solve() {
        return move(position[0], position[1]);
    }

    // 尝试递归移动马，并通过回溯法进行探索
    public static boolean move(int x, int y) {
        if (count == size * size) {
            return true; // 成功遍历完棋盘
        }
        // 遍历马的8个移动方向
        for (int i = 0; i < order.length; i++) {
            int moveIndex = order[i];
            int newX = x + MOVES[moveIndex][0];
            int newY = y + MOVES[moveIndex][1];

            // 检查是否可以移动到该位置
            if (isValidMove(newX, newY)) {
                board[newX][newY] = count++; // 标记移动
                if (move(newX, newY)) { // 递归调用继续探索
                    return true; // 成功
                }
                board[newX][newY] = -1; // 回溯撤销移动
                count--; // 回退步数
            }
        }
        return false; // 无法继续移动，回溯
    }

    // 判断是否可以移动到新的位置
    public static boolean isValidMove(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size && board[x][y] == -1; // 位置合法且未走过
    }

    // 打印棋盘
    public static void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }
}
