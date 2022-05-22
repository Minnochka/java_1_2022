package ru.geekbrains.bogachevaks;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    public  final int HEIGHT = 5;
    public  final int WIDTH = 5;
    public  final int MINE_CNT = 10;
    public  final int MINE = 1000;
    public  final int EMPTY = 0;
    public  final int CELL_CLOSE = -2;
    public  final int CELL_FLAG = -1;
    public  final int CELL_OPEN = 1;

    public  int LEVEL = 2;
    public  int height;
    public  int width;
    public  int mineCnt;

    public boolean isFlag = false;


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public int[][] board;
    public int[][] moves;
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Выберите уровень:\n1. 5 x 5\n2. 10 x 10\n3. 15 x 15");
            LEVEL = scanner.nextInt();
        }while(LEVEL <= 0 || LEVEL > 3);
        boolean userWin = play();
        if (userWin){
            System.out.println("Вы выиграли!");
        }
        else{
            System.out.println("Мина! Вы проиграли!");
        }
    }
    */
    public boolean play(){
        boolean win = true;
        boolean isPassMove = true;

        //printBoard(board);
        height = LEVEL * HEIGHT;
        width = LEVEL * WIDTH;
        mineCnt = LEVEL * MINE_CNT;
        board = generateBoard();
        moves = new int[height][width];

        for (int[] row : moves){
            Arrays.fill(row, CELL_CLOSE);
        }
        //do{
        //    isPassMove = move(board,moves);
        //    win = isWin(moves);
        //} while(isPassMove && !win);
        return isPassMove;
    }

    public  boolean isWin(){
        int openCell = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if (moves[i][j] == CELL_OPEN){
                    openCell++;
                }
            }
        }
        return openCell + mineCnt == height * width;
    }

    public  boolean move(int row, int col){
        //printBoard(board, moves);
        String[] move;
        if (board[row][col] != MINE && !isFlag){
            moves[row][col] = CELL_OPEN;
            if (board[row][col] == EMPTY){
                moves = checkFree(row, col);
            }
            return true;
        }
        else if (isFlag){
            moves[row][col] = CELL_FLAG;
            return true;
        }
        //printLoseBoard(col, row);
        return false;
    }

    public  boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }



    public  int[][] generateBoard() {
        int[][] board = new int[height][width];
        Random random = new Random();
        int mines = mineCnt;

        while (mines > 0){
            int x, y;
            do{
                x = random.nextInt(height);
                y = random.nextInt(width);
            } while (board[x][y] == MINE);
            board[x][y] = MINE;
            mines--;
        }

        //System.out.println(Arrays.deepToString(board));

        for(int i = 0; i < height; i++){
            for(int j= 0; j < width; j++){
                if (board[i][j] == MINE){
                    continue;
                }
                int mCount = 0;
                for(int k = i - 1; k <= i + 1; k++){
                    for (int h = j - 1; h <= j + 1; h++){
                        if(k < 0 || k >= height || h < 0 ||h >= width){
                            continue;
                        }
                        if (board[k][h] == MINE ){
                            mCount++;
                        }
                    }

                }
                board[i][j] = mCount;
            }
        }
        return board;
    }

    public  void printBoard(int[][] board, int[][] moves){
        System.out.print("   ");
        for( char i = 'A'; i < 'A' + width; i++){
            System.out.print(" " + i);
        }
        System.out.println();
        for(int i = 0; i < height; i++){
            System.out.printf("%3d",i);
            for (int j = 0; j < width; j++){
                if(moves[i][j] == CELL_CLOSE){
                    System.out.print("[]");
                    continue;
                }
                if(moves[i][j] == CELL_FLAG){
                    System.out.print(" P");
                    continue;
                }

                String colorCode = getColorCode(board[i][j]);
                System.out.print(colorCode);
                if(board[i][j] == EMPTY){
                    System.out.print(" .");
                }
                else if (board[i][j] == MINE){
                    System.out.print(" *");
                }
                else {
                    System.out.printf(" %d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();

        }
    }

    public  void printBoard(int[][] board){
        System.out.print("   ");
        for( char i = 'A'; i < 'A' + width; i++){
            System.out.print(" " + i);
        }
        System.out.println();
        for(int i = 0; i < height; i++){
            System.out.printf("%3d",i);
            for (int j = 0; j < width; j++){

                String colorCode = getColorCode(board[i][j]);
                System.out.print(colorCode);
                if(board[i][j] == EMPTY){
                    System.out.print(" .");
                }
                else if (board[i][j] == MINE){
                    System.out.print(" *");
                }
                else {
                    System.out.printf(" %d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();

        }
    }

    public  void printLoseBoard(int x, int y){
        System.out.print("   ");
        for( char i = 'A'; i < 'A' + width; i++){
            System.out.print(" " + i);
        }
        System.out.println();
        for(int i = 0; i < height; i++){
            System.out.printf("%3d",i);
            for (int j = 0; j < width; j++){
                if(moves[i][j] == CELL_FLAG && board[i][j] == MINE){
                    System.out.print(" P");
                    continue;
                }

                String colorCode = getColorCode(board[i][j]);
                System.out.print(colorCode);
                if(moves[i][j] == CELL_FLAG && board[i][j] != MINE){
                    System.out.print(getColorCode(CELL_FLAG));
                    System.out.print(" X");
                }
                else if (board[i][j] == MINE && i == x && j == y){
                    System.out.print(" Ж");
                }
                else if(board[i][j] == EMPTY){
                    System.out.print(" .");
                }
                else if (board[i][j] == MINE){
                    System.out.print(" *");
                }
                else {
                    System.out.printf(" %d", board[i][j]);
                }
                System.out.print(ANSI_RESET);
            }
            System.out.println();

        }
    }

    public  int[][] checkFree( int x, int y){
        for ( int i = x - 1; i <= x + 1; i++){
            for ( int j = y - 1; j <= y + 1; j++){
                //System.out.println(x + "-" + y + " : " + i + "-" + j);
                if (i < 0 || i >= moves.length || j < 0 || j >= moves[i].length || (i == x && j == y)){
                    continue;
                }
                if (board[i][j] == EMPTY && moves[i][j] == CELL_CLOSE){
                    moves[i][j] = board[i][j];
                    moves = checkFree(i, j);
                }
                else if (board[i][j] != MINE && moves[i][j] == CELL_CLOSE   ){
                    moves[i][j] = board[i][j];
                }
            }
        }
        return moves;
    }

    public  String getColorCode(int i){
        switch (i){
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
            case CELL_FLAG:
                return ANSI_RED;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            default:
                return ANSI_YELLOW;
        }
    }
}
