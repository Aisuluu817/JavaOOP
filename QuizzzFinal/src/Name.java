import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;


class Name extends JPanel {

    JButton next;

    JLabel highestScoreLabel;

    JTextField nameInput;

    static boolean again = false;

    Name (JFrame window) {

        setSize(window.getSize().width,window.getSize().height);
        setLayout(null);
        setBackground(new Color(0xC1AFF4));
        window.setContentPane(this);

        highestScoreLabel = new JLabel ("Name, please", SwingConstants.CENTER);
        highestScoreLabel.setBackground(new Color(255,255,255)) ;
         highestScoreLabel.setForeground(new Color(0x000028));
         highestScoreLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        highestScoreLabel.setBounds(0,0, window.getSize().width, window.getSize().height-400);
        add(highestScoreLabel);

        nameInput = new JTextField ();
        nameInput.setBackground(new Color(255,255,255)) ;
        nameInput.setForeground(new Color(0x000028));
        nameInput.setBounds(325,175, 150, 50);
        add(nameInput);

        next = new JButton ("Next");
        next.setBackground(new Color(0x000028)) ;
        next.setForeground(new Color(255,255,255));
        next.setFont(new Font("Verdana", Font.BOLD, 16));
        next.setBounds(300,350,200,50);
        add(next);

        window.setVisible(true);

    }

    void choose () {

        next.addActionListener((ActionEvent e) -> {
            again = true ;
        });

        while (!again) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {}
        }

        again = false ;

    }

    public String getName() {
        return nameInput.getText();
    }

}