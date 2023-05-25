// https://www.youtube.com/watch?v=Mq-My7_m6WA

import java.util.Random;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid extends JFrame {
    private final boolean[][] bombGrid;
    private final int[][] countGrid;
    private final int numRows;
    private final int numColumns;
    private final int numBombs;
    JButton[] buttons = new JButton[100];

    public Grid() {
        numRows = 10;
        numColumns = 10;
        numBombs = 25;
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    public Grid(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        numBombs = 25;
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    public Grid(int rows, int columns, int numBombs) {
        this.numColumns = columns;
        this.numRows = rows;
        this.numBombs = numBombs;
        bombGrid = new boolean[numRows][numColumns];
        countGrid = new int[numRows][numColumns];
        // board = new JButton [numRows][numColumns];
        createBombGrid();
        createCountGrid();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getNumBombs() {
        return numBombs;
    }

    public boolean[][] getBombGrid() {
        boolean[][] copy = new boolean[numRows][numColumns];

        for (int x = 0; x < copy.length; x++) {
            for (int y = 0; y < copy.length; y++) {
                copy[x][y] = bombGrid[x][y];
            }
        }
        return copy;

    }

    public int[][] getCountGrid() {
        int[][] copy = new int[numRows][numColumns];

        for (int x = 0; x < copy.length; x++) {
            for (int y = 0; y < copy.length; y++) {
                copy[x][y] = countGrid[x][y];
            }
        }
        return copy;

    }

    public boolean isBombAtLocation(int row, int column) {
        return bombGrid[row][column];
    }

    public int getCountAtLocation(int row, int column) {
        return countGrid[row][column];
    }

    public boolean isCutoffBounds(int row, int column) {
        if (row >= 0 && column >= 0 && row < numRows && column < numColumns && bombGrid[row][column]) {
            return true;
        }
        return false;
    }

    private void createBombGrid() {
        Random rd = new Random();
        int counter = 0;
        // int num = 0;

        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numColumns; y++) {
                bombGrid[x][y] = false;
            }
        }

        while (counter != numBombs) {
            int x = rd.nextInt(numRows);
            int y = rd.nextInt(numColumns);

            if (!bombGrid[x][y]) {
                bombGrid[x][y] = true;
                counter++;
            }
        }

    }

    // num = rd.nextInt(0,9);

    // if(num <= 4 && counter < numBombs) {
    // bombGrid[x][y] = true;
    // counter++;
    // }
    // if(num >= 5)
    // bombGrid[x][y] = false;

    // if(counter == numBombs) {
    // bombGrid[x][y] = false;

    // if(bombGrid[x][y] == true)
    // counter++;
    // }

    // }
    // }
    // }
    private void createCountGrid() {
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numColumns; y++) {
                int bombs = 0;
                if (isCutoffBounds(x, y)) {
                    bombs++;
                }

                if (isCutoffBounds(x, y + 1)) {
                    bombs++;
                }

                if (isCutoffBounds(x + 1, y)) {
                    bombs++;
                }

                if (isCutoffBounds(x, y - 1)) {
                    bombs++;
                }

                if (isCutoffBounds(x + 1, y + 1)) {
                    bombs++;
                }

                if (isCutoffBounds(x + 1, y - 1)) {
                    bombs++;
                }

                if (isCutoffBounds(x - 1, y - 1)) {
                    bombs++;
                }

                if (isCutoffBounds(x - 1, y)) {
                    bombs++;
                }

                if (isCutoffBounds(x - 1, y + 1)) {
                    bombs++;
                }

                countGrid[x][y] = bombs;
            }
        }
    }

    public void guiSetup() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(10, 10));
        jp.setBackground(Color.WHITE);
        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numColumns; y++) {
                final String value = String.valueOf(countGrid[x][y]);
                final String test = x + "," + y;
                final String bombs = String.valueOf(bombGrid[x][y]);
                JButton buttons = new JButton();
                buttons.setForeground(Color.RED);
                buttons.setText(bombs);
                buttons.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton clicked = (JButton) e.getSource();

                        clicked.setText(value);
                        clicked.setEnabled(false);

                        //if(clicked.setText(value) == "true") {
                        //int choice = JOptionPane.showConfirmDialog(null, "Sorry you lose, Do you want to play again", null, JOptionPane.YES_NO_OPTION);


                        //System.out.println(test);

                        //if(clicked)
                    }
                });

                jp.add(buttons);
            }
        }
        add(jp);
    }

    public static void createAndShowGUI(Grid grid) {
        //Grid frame = new Grid();
        grid.setTitle("MineSweeper");
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.pack();
        grid.setVisible(true);
        grid.guiSetup();
    }

    public static void main(String[] args) {
        Grid grid = new Grid();
        boolean[][] bombGrid = grid.getBombGrid();
        int[][] countGrid = grid.getCountGrid();

        for (int x = 0; x < grid.numRows; x++) {
            for (int y = 0; y < grid.numColumns; y++) {
                System.out.print(bombGrid[x][y] + " ");
            }
            System.out.println();

        }

        for (int x = 0; x < grid.numRows; x++) {
            for (int y = 0; y < grid.numColumns; y++) {
                System.out.print(countGrid[x][y] + " ");
            }
            System.out.println();


        }
        createAndShowGUI(grid);
    }
}