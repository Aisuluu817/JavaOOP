import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class Questions extends JPanel {
    
    JLabel Q ,
           hintLabel;
    
    JButton a,
            b,
            c,
            d;
    
    String correct_answer,
            hint  ;

    static boolean next = false ;
    static int score = 0 ;
    
    static JLabel timer = new JLabel ("00 : 00"); //: 000") ;
    static Counter count = new Counter ();
    
    Questions (Options obj , JFrame window) {
            
      Q = new JLabel (obj.Questions);
      hintLabel = new JLabel("Hint");
      hintLabel.setFont(new Font("Verdana", Font.BOLD, 12));
      a = new JButton (obj.a) ;
      b = new JButton (obj.b) ;
      c = new JButton (obj.c) ;
      d = new JButton (obj.d) ;
      add(hintLabel);
      correct_answer = obj.correct_answer ;
      hint = obj.hint ; 

      JPanel pan = new JPanel () ;     
      pan.setLayout(null);
      pan.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0x000028)));
      pan.setBackground(new java.awt.Color(0xC1AFF4));
      window.setContentPane(pan);
      setLayout(null);
      setBackground(Color.WHITE);


      setBounds(90,170,600,200);
      setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
      pan.add(this);
      
      add(Q); add(a); add(b); add(c); add(d);
      
      Q.setBounds(110,8,400,50);
      Q.setBorder(new LineBorder(Color.WHITE, 3, true));
      Q.setFont(new Font("Verdana", Font.BOLD, 12));
      Q.setForeground(new Color(0x000028));
      Q.setHorizontalAlignment(JLabel.CENTER);

      a.setBounds(90,70,200,40); a.setBackground(new Color(193, 175, 244)) ;
      a.setForeground(new Color(0x000028));
      a.setFont(new Font("Verdana", Font.BOLD, 13));
      b.setBounds(90,140,200,40); b.setBackground(new Color(193, 175, 244)) ;
        b.setForeground(new Color(0x000028));
        b.setFont(new Font("Verdana", Font.BOLD, 13));
      c.setBounds(330,70,200,40); c.setBackground(new Color(193, 175, 244)) ;
        c.setForeground(new Color(0x000028));
        c.setFont(new Font("Verdana", Font.BOLD, 13));
      d.setBounds(330,140,200,40); d.setBackground(new Color(193, 175, 244)) ;
        d.setForeground(new Color(0x000028));
        d.setFont(new Font("Verdana", Font.BOLD, 13));
      a.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      b.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      c.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      d.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      
      timer.setBounds(250,400,300,50);
      timer.setFont(new Font("Verdana", Font.BOLD, 40));
      timer.setHorizontalAlignment(JLabel.CENTER);
      timer.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0x000028)));
      timer.setForeground(new java.awt.Color(0x000028));
      pan.add(timer);
      
      JButton hintBTN = new JButton(new ImageIcon(getClass().getResource("Hint.png")));
      JButton half = new JButton(new ImageIcon(getClass().getResource("50 50.png")));


      pan.add(half); pan.add(hintBTN); pan.add(hintLabel);
      hintBTN.setBounds(200,50,80,80);
      hintBTN.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      half.setBounds(500,50,80,80);
      half.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
      hintLabel.setBounds(290,50,200,80);
      hintLabel.setHorizontalAlignment(JLabel.CENTER);
      hintLabel.setForeground(new java.awt.Color(0x000028));
      hintLabel.setBorder(new LineBorder(Color.white, 2, true));  
       
            hintBTN.addActionListener((ActionEvent e) -> {
                hintLabel.setText(hint);
            });
            
            half.addActionListener((ActionEvent e) -> {
                    if (!a.getText().equals(correct_answer)) {
                      a.setEnabled(false);
                      a.setBackground(new java.awt.Color(0xDE4348));
                    }else if (!b.getText().equals(correct_answer)) {
                      b.setEnabled(false);
                      b.setBackground(new java.awt.Color(0xDE4348));
                    }
                    if (!c.getText().equals(correct_answer)) {
                      c.setEnabled(false);
                      c.setBackground(new java.awt.Color(0xDE4348));
                    }else if (!d.getText().equals(correct_answer)) {
                      d.setEnabled(false);
                      d.setBackground(new java.awt.Color(0xDE4348));
                    }
            });
            
      window.setVisible(true);              
    }
    
    void getAnswer (int time) throws InterruptedException {
        
            a.addActionListener((ActionEvent e) -> {
                if (a.getText().equals(correct_answer)) score++ ;
                next = true ;
            });

            b.addActionListener((ActionEvent e) -> {
                if (b.getText().equals(correct_answer)) score++ ;
                next = true ;
            });

            c.addActionListener((ActionEvent e) -> {
                if (c.getText().equals(correct_answer)) score++ ;
                next = true ;
            });

            d.addActionListener((ActionEvent e) -> {
                if (d.getText().equals(correct_answer)) score++ ;
                next = true ;
           });

        while (next == false ) {
        
            timer.setText(String.format("%02d", count.M)+" : "+String.format("%02d", count.S));
               count.Ms++ ;
               Thread.sleep(1);
               if (count.Ms==999){
                   count.S++ ;
                   count.Ms=0 ;
               }
               if (count.S==59){
                   count.M++ ;
                   count.S=0;
               }
               
               if ((count.S + count.M*60) > time-3 ) {
                   
                   timer.setForeground(Color.red);
                   
                        if ((count.S + count.M*60)==time) { 
                            return ;
                        }
               }
        
        } 
        
        next = false ;
  
    }
    
    int getScore() {return score ;}
    
    Counter getTime () {return count ;}
    
    void Reset () {
        
            count.M=0 ; 
           // count.Ms=0 ;
            count.S=0;
            score = 0 ;
    
    }
    
}