import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;


class ScorePane extends JPanel {
    
    JButton playAgain ,
            exit ;
    
    JLabel scoreLabel ;
    
    static boolean go =false;
    
    ScorePane(JFrame window , int score , int nbrQ) {
        
        setSize(window.getSize().width,window.getSize().height);
        setLayout(null);
        setBackground(new java.awt.Color(0xC1AFF4));
        window.setContentPane(this);
        
        playAgain = new JButton ("Save the score");
        playAgain.setBackground(new Color(255,255,255)) ;
        playAgain.setForeground(new Color(0x000028));
        playAgain.setFont(new Font("Verdana", Font.BOLD, 13));
        playAgain.setBounds(300,250,200,50);
        add(playAgain);
        
        exit = new JButton ("Exit");
        exit.setBackground(new Color(255,255,255)) ;
        exit.setForeground(new Color(0x000028));
        exit.setFont(new Font("Verdana", Font.BOLD, 13));
        exit.setBounds(300,350,200,50);
        add(exit);
        
        scoreLabel = new JLabel ("You Got : "+score+"/"+nbrQ);


        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(new Font("Verdana", Font.BOLD, 40));
        scoreLabel.setForeground(new java.awt.Color(0x000028));
        scoreLabel.setBorder(new LineBorder(Color.white, 2, true));
        scoreLabel.setBounds(200,100,400,100);
        add(scoreLabel);
        
        window.setVisible(true);
        
    }
    
    void choose () {
        
        playAgain.addActionListener((ActionEvent e) -> {
            go= true ;
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