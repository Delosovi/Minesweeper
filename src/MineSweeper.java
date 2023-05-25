import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MineSweeper extends JFrame{
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    Grid grid = new Grid();

    JButton[] buttons;

    public MineSweeper()
    {
        this(WIDTH, HEIGHT);
    }

    public MineSweeper(int width, int height)
    {
        buttons = new JButton[25];
        buildGame();
        setSize(width,height);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildGame() {
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(5,5));
        for(JButton jButton: buttons) {
            //java.net.URL imgURL = getClass().getResource("cat.png");
            //System.out.println(imgURL);
            //ImageIcon icon = new ImageIcon(imgURL, "cat");

            //jButton = new JButton("icon", icon);
            jButton.setVerticalTextPosition(AbstractButton.CENTER);
            jButton.setHorizontalAlignment(AbstractButton.LEADING);

            jButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    System.out.println(e);
                }
            });
            mainPanel.add(jButton);
        }
        add(mainPanel);
    }

//}
    //public void actionPerformed(ActionEvent e)
    //{
    //System.out.println(e);
    //}

    public static void main (String [] args) {
        MineSweeper game = new MineSweeper();

    }
}