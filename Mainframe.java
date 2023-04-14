import javax.swing.JFrame;

public class Mainframe extends JFrame{
    String title = "This is a test drawing with swing timer";
    Label label = new Label(200, 0, 800, 100, title);
    static Label scoreBoard = new Label(0, 0, 200, 100, "score 0");
    MainPanel panel = new MainPanel(0, 100, 1000, 900);

    Mainframe(){
        this.setTitle("test for panel");
        this.setSize(1000, 1000);
        this.setLayout(null);
        this.add(label);
        this.add(panel);
        this.add(scoreBoard);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    
}
