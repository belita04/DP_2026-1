package hw.ch22.drawer;

import hw.ch22.command.Command;
import hw.ch22.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 현재 그리기 색
    private Color color;

    // 점의 반지름
    private int radius;

    // 그리기 이력
    private MacroCommand history;

    // 생성자
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);

        this.history = history;
        init();
    }

    // 이력 전체 다시 그리기
    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    // 초기화
    @Override
    public void init() {
        color = Color.red;
        radius = 6;

        Command cmd = new ColorCommand(this, color);
        history.append(cmd);
        cmd.execute();
    }

    // 점 그리기
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();

        if (g != null) {
            g.setColor(color);
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }
    }

    // 색상 변경
    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}