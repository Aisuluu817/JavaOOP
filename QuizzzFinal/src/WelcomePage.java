import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class WelcomePage extends JPanel {
    
    JButton play ,
            howItWorks ,
            exit ;
    
    static boolean go  = false ;
    
    WelcomePage(JFrame window) {
        
        setSize(window.getSize().width,window.getSize().height);
        setLayout(null);
        setBackground(new Color(0xC1AFF4));
        window.setContentPane(this);
        
        play = new JButton ("Play");
        play.setBackground(new java.awt.Color(0x000028)) ;
        play.setForeground(new Color(249, 247, 242));
        play.setFont(new Font("Verdana", Font.BOLD, 18));
        play.setBounds(300,50,200,50);
        add(play);
        
        howItWorks = new JButton ("Instructions");
        howItWorks.setBackground(new java.awt.Color(0x000028)) ;
        howItWorks.setForeground(new Color(249, 247, 242));
        howItWorks.setFont(new Font("Verdana", Font.BOLD, 18));
        howItWorks.setBounds(300,150,200,50);
        add(howItWorks);

        
        exit = new JButton ("Exit");
        exit.setBackground(new Color(0, 0, 40)) ;
        exit.setForeground(new Color(249, 247, 242));
        exit.setFont(new Font("Verdana", Font.BOLD, 18));
        exit.setBounds(300,350,200,50);
        add(exit);
        
        window.setVisible(true);
        
    }
    
    void choose (int time) {
        
        play.addActionListener((ActionEvent e) -> {
            go = true ;
            setVisible(false);
        });
        
        howItWorks.addActionListener((ActionEvent e) -> {
            new Instructions(time);
        });

        
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        while (!go) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException ex) {}
        }
        
        go = false ;
    
    }
    
}