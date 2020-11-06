import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class Instructions  extends JFrame{
  Instructions (int time) {
      setSize(400,400);
      setLocationRelativeTo(null);
      setResizable(false);

      JPanel pan = new JPanel () ;
      pan.setSize(this.getSize().width,this.getSize().height);
      pan.setBackground(new java.awt.Color(0xC1AFF4));
      pan.setLayout(null);
      setContentPane(pan);

      JLabel howLabel = new JLabel("<html><center>You Have "+ time/60+" min To Answer 10 Different Questions"
                              + " And You Can Use The Helping Tools Such As 50:50 To remove two options "
                                    + "Or The Hint To give You A Little Clue About The Answer.</center></html>");
      howLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
      howLabel.setBounds(8,5,350,150);
      howLabel.setForeground(new java.awt.Color(0x000028));
      JLabel border = new JLabel() ;
      border.setBorder(new LineBorder(Color.white, 2, true));
      border.setBounds(10,5,360,300);
     border.add(howLabel);
      pan.add(border);
      setVisible(true);
  }
}