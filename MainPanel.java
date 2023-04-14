import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MainPanel extends JPanel implements ActionListener, KeyListener {
  Random random = new Random();
  Timer timer;
  final int DELAY = 1000;
  final int MoveUnit = 50;
  int vMover = 0;
  int hMover = 0;
  int score = 0;
  char direction = 'R';
  boolean paused;

  Cubes[] snake = { new Cubes(200, 100), new Cubes(150, 100), new Cubes(100, 100) };
  Cubes apple = new Cubes(0, 0);

  MainPanel(int x, int y, int w, int h) {
    setBounds(x, y, w, h);
    this.addKeyListener(this);
    this.setFocusable(true);
    start();
  }

  public void start() {
    timer = new Timer(DELAY, this);
    timer.start();
  }

  public void updateSnake() {
    boolean ishead = true;
    Cubes cubeToAssing = new Cubes(0, 0);
    for (int i = 0; i < snake.length; i++) {
      Cubes el = snake[i];
      Cubes prevState = new Cubes(0, 0);
      if (ishead) {
        cubeToAssing.transfer(el);
        int headX = direction == 'R' ? el.x + MoveUnit : direction == 'L' ? el.x - MoveUnit : el.x;
        int headY = direction == 'D' ? el.y + MoveUnit : direction == 'U' ? el.y - MoveUnit : el.y;
        el.setPosition(headX, headY);
        ishead = false;
      } else {
        prevState.transfer(el);
        el.transfer(cubeToAssing);
        cubeToAssing.transfer(prevState);
      }
    }

  }

  public void updateSnakeDirection() {
    int snakeX = snake[0].x;
    int snakeY = snake[0].y;
    if (snakeX > 950) {
      snake[0].setPosition(0, snakeY);
    } 
    else  if(snakeX < 0) {
      snake[0].setPosition(1000, snakeY);
    }
    else if (snakeY < 0) {
      snake[0].setPosition(snakeX, 900);
    }
    else if (snakeY > 850) {
      snake[0].setPosition(snakeX, 0);
    }
  }

  public void updateApple() {
    int x = random.nextInt(850) + 1;
    int y = random.nextInt(850) + 1;
    apple.setPosition(x + (MoveUnit - (x % MoveUnit)), y + (MoveUnit - (y % MoveUnit)));
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (paused) {
      return;
    }
    updateSnake();
    updateSnakeDirection();
    if (CustomUtils.checkCircleOverlap(snake[0].x, apple.x, snake[0].y, apple.y)) {
        score +=10;
        Mainframe.scoreBoard.setText("score "+score);
      int prevLen = snake.length;
      Cubes[] newSnake = new Cubes[prevLen + 1];
      for (int i = 0; i < prevLen; i++) {
        newSnake[i] = snake[i];
      }
      newSnake[prevLen] = new Cubes(snake[prevLen - 1].x, snake[prevLen - 1].y);
      snake = newSnake;

      updateApple();
    }
    this.repaint();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    for (Cubes el : snake) {
      g.fillOval(el.x, el.y, 50, 50);
    }
    g.setColor(Color.GREEN);
    g.fillOval(apple.x, apple.y, 50, 50);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int pressedkey = e.getKeyCode();
    switch (pressedkey) {
      case 37:
        if (direction != 'R') {
          direction = 'L';
        }
        break;

      case 39:
        if (direction != 'L') {
          direction = 'R';
        }
        break;

      case 38:
        if (direction != 'D') {
          direction = 'U';
        }
        break;

      case 40:
        if (direction != 'U') {
          direction = 'D';
        }
        break;
      case 32:
        paused = !paused;
        break;

      default:
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

}
