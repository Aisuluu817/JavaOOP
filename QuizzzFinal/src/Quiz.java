import javax.swing.*;
import java.awt.* ;
import java.io.*;

public class Quiz {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        JFrame window = new JFrame("Quiz");
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        while (true) {

            int nbr = 0, score = 0, m = 0, s = 0;
            int time = 60;

            WelcomePage welcome = new WelcomePage(window);
            welcome.choose(time);


            Options[] qObj = {
                    new Options("A programmer-defined constructor that has no arguments.. ", "a.empty constructor", "b.null constructor", "c. no-argument constructor", "d. default constructor", "c. no-argument constructor", "The hint is in the question"),
                    new Options("Which Department is the best in AIU?", "a. Computer Science", "b. Psychology", "c. International Relations", "d. Economics", "a. Computer Science", "It is obvious! "),
                    new Options("is not one of the 3 general types of computer languages??", "a. Assembly lang", "b. Spoken lang", "c. Machine lang", "d. High-level lang", "b. Spoken lang", "Language humans speak"),
                    new Options("The format specifier __ is a placeholder for an int value?", "a. %int", "b. %d", "c. %n", "d. %s", "b. %d", "not %int for sure"),
                    new Options("Portions of statements that contain calculations are called?", "a. sentences", "b. variables", "c. values", "d. expressions", "d. expressions", "the same as in MATH"),
                    new Options("is not a relational or equality operator?", "a. >=", "b. =!", "c. ==", "d. < ", "b. =!", "written wrong"),
                    new Options("Java's predefined classes are grouped into?", "a. packages", "b. declarations", "c. packets", "d. collections", "a. packages", "sent it to someone"),
                    new Options("Which of the following is not an arithmetic operator?", "a. -", "b. *", "c. #", "d. %", "c. #", "write a comment in python"),
                    new Options("Java requires a __ call for every object that’s created", "a. destructor", "b. constructor", "c. parameterized", "d. parameterless", "b. constructor", "abbreviation: ctor"),
                    new Options("Which is a double-selection control statement?", "a. break", "b. for", "c. do..while", "d. if..else", "d. if..else", "not a loop")

            };


            while (nbr != qObj.length && s < time) {
                Questions quiz = new Questions(qObj[nbr], window);
                quiz.getAnswer(time);
                m = quiz.getTime().M;
                s = quiz.getTime().S;
                score = quiz.getScore();
                if (nbr == qObj.length - 1 || (s == time)) quiz.Reset();
                nbr++;
            }

            Name name = new Name(window);
            name.choose();
            String scorer = name.getName();


            int nbrQ = qObj.length;
            ScorePane scorePane = new ScorePane(window, score, nbrQ);
            scorePane.choose();

            int highScore = 0;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Record.txt"));
                String line = reader.readLine();
                while (line != null)
                {
                    try {
                        int scor = Integer.parseInt(line.trim());
                        if (scor > highScore)
                        {
                            highScore = scor;
                        }
                    } catch (NumberFormatException e1) {

                    }
                    line = reader.readLine();
                }
                reader.close();

            } catch (IOException ex) {
                System.err.println("ERROR reading scores from file");
            }

            String comment;

            if (score > highScore) {
                 comment = "You now have the new high score! It is " + score + "! The previous high score was "
                         + highScore;
            } else if (score == highScore) {
                comment = "You tied the high score!";
            } else {
                comment = "The all time high score was " + highScore;
            }


            try {
                BufferedWriter output = new BufferedWriter(new FileWriter("Record.txt", true));
                output.newLine();
                output.append("" + score);
                output.newLine();
                output.append(scorer);
                output.close();

            } catch (IOException ex1) {
                System.out.printf("ERROR writing score to file: %s\n", ex1);

            }

            Results Results = new Results(window, comment);
            Results.setLayout(new BorderLayout());
            Results.choose();

        }
    }
}