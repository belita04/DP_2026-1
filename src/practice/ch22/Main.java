package practice.ch22;

import practice.ch22.command.*;
import practice.ch22.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력 
    private MacroCommand history = new MacroCommand();
    // 그리는 영역 
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton  = new JButton("clear");

    // 생성자 
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(e -> { 
            history.clear(); // 이력 전체 삭제
            canvas.repaint(); // 캔버스 전체를 다시 그리기-> paint()가 호출됨-> history.execute()가 호출됨 -> 이력이 비어있으므로 아무것도 그리지 않음
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS); // 버튼을 가로로 나열하기 위한 박스
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS); // 버튼과 캔버스를 세로로 나열하기 위한 박스
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("mouseMoved: " + e.getPoint()); // 마우스가 움직일 때마다 좌표를 출력 , 비워 놓으면 아무것도 출력 안됨
    }

    // 커맨드 패턴의 핵심 ***
    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint()); // 그리기 명령 객체가 생성됨
        history.append(cmd); // 그리기 명령이 이력에 추가됨
        cmd.execute(); // 그리기 명령을 실행함
    }

    // WindowListener용 
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0); // 프로그램 종료
    }

    // 나머지는 사용하지 않음 > 빈칸, 구현은 해야해놔야해서 빈칸으로 둔다.
    @Override public void windowActivated(WindowEvent e) {}
    @Override public void windowClosed(WindowEvent e) {}
    @Override public void windowDeactivated(WindowEvent e) {}
    @Override public void windowDeiconified(WindowEvent e) {}
    @Override public void windowIconified(WindowEvent e) {}
    @Override public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
