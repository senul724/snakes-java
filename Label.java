import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Label extends JLabel {
    Label(int x, int y, int w, int h, String title, Color textColor, int fontSize){
        this.setText(title);
        this.setBounds(x, y, w, h);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);

        this.setForeground(textColor);
        this.setFont(new Font("Rockwell Extra Bold", Font.BOLD, fontSize));
    }

    Label(int x, int y, int w, int h, String title){
        this.setText(title);
        this.setBounds(x, y, w, h);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.CENTER);

        this.setForeground(Color.BLACK);
        this.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 30));
    }
}
