package ru.geekbrains.bogachevaks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;




public class Game_MS extends JFrame {


    public Game_MS() {
        JFrame mainFrame = new JFrame();
        JFrame firstFrame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JPanel gamePanel = new JPanel();
        boolean isFlag = false;


        /*firstFrame.setTitle("Test Window");
        firstFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        firstFrame.setBounds(300, 300, 400, 400);
        firstFrame.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        firstFrame.add(new Button("Легкий уровень"));
        firstFrame.add(new Button("Средний уровень"));
        firstFrame.add(new Button("Сложный уровень"));*/

        mainFrame.setTitle("Test Window");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setBounds(300, 300, 400, 400);

        Button btnFlag = new Button("Открыть");
        MineSweeper game = new MineSweeper();
        game.play();

        ActionListener btnFlagListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button btn = (Button) e.getSource();
                if (btn.getLabel() == "Открыть"){
                    btn.setLabel("Флаг");
                    game.isFlag = true;
                }
                else{
                    btn.setLabel("Открыть");
                    game.isFlag = false;
                }
            }
        };


        ActionListener btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MatrixButton matrixButton = (MatrixButton) e.getSource();
                System.out.println(matrixButton.getRow() + ";" + matrixButton.getCol());
                int x = matrixButton.getRow();
                int y = matrixButton.getCol();


                boolean isPassMove = game.move(x, y);

                if (!isPassMove) {

                    for (int i = 0; i < game.height; i++) {
                        for (int j = 0; j < game.width; j++) {
                            System.out.println("cicle = " + i + ";" + j);
                            if (game.moves[i][j] == game.CELL_FLAG && game.board[i][j] == game.MINE) {
                                //System.out.print(" P");
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("P");
                                but.setEnabled(false);
                                continue;
                            }
                            String colorCode = game.getColorCode(game.board[i][j]);
                            if (game.moves[i][j] == game.CELL_FLAG && game.board[i][j] != game.MINE) {
                                System.out.print(game.getColorCode(game.CELL_FLAG));
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("X");
                                but.setEnabled(false);
                            } else if (game.board[i][j] == game.MINE && i == x && j == y) {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("Ж");
                                but.setEnabled(false);
                            } else if (game.board[i][j] == game.EMPTY) {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText(".");
                                but.setEnabled(false);
                            } else if (game.board[i][j] == game.MINE) {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("*");
                                but.setEnabled(false);
                            } else {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("" + game.board[i][j]);
                                but.setEnabled(false);
                            }
                        }
                    }
                }
                else{
                    for(int i = 0; i < game.height; i++) {
                        for (int j = 0; j < game.width; j++) {
                            if(game.moves[i][j] == game.CELL_CLOSE){
                                continue;
                            }if (game.moves[i][j] == game.CELL_FLAG) {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("P");
                                but.setEnabled(false);
                                continue;
                            }

                            if (game.board[i][j] == game.EMPTY) {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText(".");
                                but.setEnabled(false);
                            } else if (game.board[i][j] == game.MINE) {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("*");
                                but.setEnabled(false);
                            } else {
                                MatrixButton but = (MatrixButton) gamePanel.getComponent(i * game.width + j);
                                but.setText("" + game.board[i][j]);
                                but.setEnabled(false);

                            }
                        }
                    }
                }

                boolean win = game.isWin();
                if (!isPassMove || win){
                    return;
                }

            }
        };

        gamePanel.setLayout(new GridLayout(10, 10));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                MatrixButton matrixButton = new MatrixButton("", j, i);
                matrixButton.addActionListener(btnListener);
                gamePanel.add(matrixButton);
            }
        }

        topPanel.setLayout(new GridLayout(1,1,5,5));
        btnFlag.addActionListener(btnFlagListener);
        topPanel.add(btnFlag);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainFrame.add(mainPanel);
        //mainFrame.add(gamePanel);
        mainFrame.setVisible(true);

    }


    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Выберите уровень:\n1. 5 x 5\n2. 10 x 10\n3. 15 x 15");
            LEVEL = scanner.nextInt();
        }while(LEVEL <= 0 || LEVEL > 3);

        boolean userWin = play();*/
         new Game_MS();
    }

}
