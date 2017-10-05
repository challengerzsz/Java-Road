import java.util.Objects;
import java.util.Random;
import java.util.Scanner;


class AI {
    public int x;
    public int y;
    Random rd = new Random();
    public int chatX() {
        x = rd.nextInt(15);
        return x;
    }
    public int chatY() {
        y = rd.nextInt(15);
        return y;
    }

}
class Gobang {
    //定义棋盘大小
    private static int BOARD_SIZE = 15;
    //定义一个二维数组来充当棋盘
    private String [][] board;

    public void initBoard() {
        //初始化棋盘数组
        board = new String[BOARD_SIZE][BOARD_SIZE];
        //用“┼”画出棋盘
        for (int i = 0; i < BOARD_SIZE; i++){
            for (int o = 0; o < BOARD_SIZE;o++){
                board[i][o] = "┼";
            }
        }
    }

    //设置先行: 1.玩家 2.电脑
    public int firstGo(int flag) {
        if (flag == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }

    //将对应坐标位置设置为“●”或“○”
    public void setBoard(int x,int y,int flag) {
        if (isHad(x - 1, y - 1) && flag == 1) {
            board[x - 1][y - 1] = "●";
        }
        if (isHad(x, y) && flag == 0) {
            board[x][y] = "○";
        }

    }

    //在控制台输出棋盘
    public void printBoard() {
        //打印每个数组元素
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int o = 0; o < BOARD_SIZE; o++) {
                System.out.print(board[i][o]);
            }
            System.out.print("\n");
        }
        System.out.println("\n");
    }

    //判断棋盘上有没有在此位置下过棋
    public boolean isHad(int x,int y) {
        if (board[x][y] != "┼") {
            System.out.println("对不起，您已经在此坐标下过棋");
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isWin(int x,int y) {
        String tem = board[x - 1][y - 1];
        int flag,i,j;
        //横向搜索
        for (i = x, j = y - 1, flag = 1; i < BOARD_SIZE; i++) {
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        for (i = x - 2, j = y -1; i >= 0; i--) {
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        if (flag == 5) {
            return true;
        }
        //纵向搜索
        for (i = x - 1, j = y, flag = 1; j < BOARD_SIZE; j++) {
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        for (i = x - 1, j = y - 2; j >= 0; j--){
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        if (flag == 5) {
            return true;
        }
        //135°搜索
        for (i = x, j = y, flag = 1; i < BOARD_SIZE && j < BOARD_SIZE; i++, j++){
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        for (i = x - 2, j = y - 2; i >= 0 && j >= 0; i--, j--){
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        if (flag == 5) {
            return true;
        }
        //45°搜索
        for (i = x, j = y - 2, flag = 1; i < BOARD_SIZE && j >= 0; i++, j--) {
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        for (i = x - 2, j = y; i >= 0 && j < BOARD_SIZE; i--, j++){
            if (Objects.equals(board[i][j], tem)) {
                flag++;
            }
        }
        if (flag == 5) {
            return true;
        }
        return false;
    }


}
public class Main {
    public static void main(String[] args) {
        int x,y;
        Gobang gobang = new Gobang();
        gobang.initBoard();
        gobang.printBoard();
        AI ai = new AI();
        Scanner scanner = new Scanner(System.in);
        System.out.println("设置先行 1：玩家先行 2：电脑先行");
        int flag = scanner.nextInt();
        if (flag == 2) {
            x = ai.chatX();
            y = ai.chatY();
            gobang.setBoard(x,y,flag);
            gobang.printBoard();
            flag = 1;
        }
        String inputStr = null;
        String tem [];
        System.out.println("请输入你下棋的位置，使用逗号隔开，eg：1,1");
        while (true) {
            if (flag == 1) {
                inputStr = scanner.next();
                tem = inputStr.split(",");
                x = Integer.parseInt(tem[0]);
                y = Integer.parseInt(tem[1]);
                gobang.setBoard(x,y,flag);
                gobang.printBoard();
                flag = 0;
                if (gobang.isWin(x,y)) {
                    System.out.println("你赢了！");
                    return;
                }
                continue;
            }
            else {
                x = ai.chatX();
                y = ai.chatY();
                gobang.setBoard(x,y,flag);
                gobang.printBoard();
                flag = 1;
                if (gobang.isWin(x,y)) {
                    System.out.println("电脑赢了！");
                    return;
                }
                continue;
            }
        }
    }
}
