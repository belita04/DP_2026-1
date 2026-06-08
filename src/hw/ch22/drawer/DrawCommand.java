package hw.ch22.drawer;

import hw.ch22.command.Command;

import java.awt.Point;

public class DrawCommand implements Command {
    // 그리기 대상
    protected Drawable drawable;

    // 그릴 위치
    private Point position;

    // 생성자
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}