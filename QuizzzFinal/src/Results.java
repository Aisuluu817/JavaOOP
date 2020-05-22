import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class Results extends JPanel {

    JButton next;

    JLabel highestScoreLabel;

    JLabel scoreList;

    static boolean again = false;

    Results (JFrame window , String comment) throws FileNotFoundException {

        setSize(window.getSize().width,window.getSize().height);
        setLayout(null);
        setBackground(new Color(0xC1AFF4));
        window.setContentPane(this);

        highestScoreLabel = new JLabel (comment, SwingConstants.CENTER);
        highestScoreLabel.setBackground(new Color(255,255,255)) ;
        highestScoreLabel.setForeground(new Color(0x000028));
        highestScoreLabel.setFont(new Font("Verdana", Font.BOLD, 16));
        highestScoreLabel.setBounds(0,0, window.getSize().width, 100);
        add(highestScoreLabel);


        next = new JButton ("Next");
        next.setBackground(new Color(255,255,255)) ;
        next.setForeground(new Color(0x000028));
        next.setFont(new Font("Verdana", Font.BOLD, 13));
        next.setBounds(300,350,200,50);
        add(next);

        scoreList = new JLabel ("<html>" + getScores() + "</html>", SwingConstants.CENTER);
        scoreList.setBackground(new Color(255,255,255)) ;
        scoreList.setForeground(new Color(0x000028));
        scoreList.setFont(new Font("Verdana", Font.BOLD, 16));
        scoreList.setBounds(0,0, window.getSize().width, 300);
        add(scoreList);



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

    public String getScores() {
        String scores = "";

        try {
            int count = 1;
            BufferedReader reader = new BufferedReader(new FileReader("Record.txt"));
            String line = reader.readLine();
            while (line != null)
            {
                try {
                    if (count % 2 == 0) {
                        scores += line + "      ";
                    } else {
                        scores += line + "<br/>";
                    }
                    count++;
                } catch (NumberFormatException e1) {}

                line = reader.readLine();
            }
            reader.close();

        } catch (IOException ex) {
            System.err.println("ERROR reading scores from file");
        }

        return scores;
    }


}