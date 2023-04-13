import java.awt.Color;

public class Cubes {
    public int x;
    public int y;
    Color color;

    Cubes(int x, int y){
        setPosition(x, y);
        color = Color.RED;
    }

    Cubes(int x, int y, Color color){
        setPosition(x, y);
        this.color = color;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void transfer(Cubes cube){
        this.x = cube.x;
        this.y = cube.y;
    }
    
    public void get(String prefix) {
        System.out.println(prefix+ " ( "+x+", "+y+" )");
    }
}
