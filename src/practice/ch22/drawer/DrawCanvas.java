package practice.ch22.drawer;

import practice.ch22.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 그리는 색 
    private Color color = Color.red; // 빨간색 상수
    // 그리는 점의 반지름 
    private int radius = 6;
    // 이력 
    private MacroCommand history; // 지금까지의 그리기 명령들을 모아놓은 곳

    // 생성자 
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 이력 전체 다시 그리기 
    @Override
    public void paint(Graphics g) { // repaint()가 호출될 떄 마다 이메소드가 호출됨.
        history.execute();
    }

    // 그리기 
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2); // 원을 채울때 사용하는 메소드, 사각형 안에 원을 그림
    }
}
