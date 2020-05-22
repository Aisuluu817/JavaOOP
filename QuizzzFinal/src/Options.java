import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.* ;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

class Options {
    
    String Questions ,
            a ,
            b ,
            c ,
            d ,
            correct_answer ,
            hint;
    
    Options (String question , String a , String b ,String c, String d , String corrAns , String hint) {
        this.Questions = question ;
        this.a = a;
        this.b = b;
        this.c = c ;
        this.d = d ;
        this.correct_answer = corrAns ;
        this.hint = hint ;
    }
}