import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GridDemo extends JFrame {
    private JButton[] jbs = new JButton[100];
    Grid grid = new Grid();

    public GridDemo() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(10, 10));
        jp.setBackground(Color.WHITE);
        for (int i = 0; i < 100; i++) {
            int index = i;
            jbs[i] = new JButton();
            jbs[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton clicked = (JButton) e.getSource();
                    JTextArea typeArea = new JTextArea(10, 20);
                    JScrollPane scrollPane = new JScrollPane();
                    clicked.setText("A");
                    clicked.setEnabled(false);
                }
            });

            jp.add(jbs[i]);
        }
        add(jp);
    }
    private static void createAndShowGUI() {
        GridDemo frame = new GridDemo();
        frame.setName("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();

    }
}