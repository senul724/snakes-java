import javax.swing.JFrame;

public class Mainframe extends JFrame{

    Mainframe(){
        String title = "This is a test drawing with swing timer";
        Label label = new Label(0, 0, 1000, 100, title);
        MainPanel panel = new MainPanel(0, 100, 1000, 900);

        this.setTitle("test for panel");
        this.setSize(1000, 1000);
        this.setLayout(null);
        this.add(label);
        this.add(panel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    
}
