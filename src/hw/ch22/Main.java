package hw.ch22;

import hw.ch22.command.Command;
import hw.ch22.command.MacroCommand;
import hw.ch22.drawer.ColorCommand;
import hw.ch22.drawer.DrawCanvas;
import hw.ch22.drawer.DrawCommand;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // 그리기 이력
    private MacroCommand history = new MacroCommand();

    // 그리는 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);

    // 버튼
    private JButton clearButton = new JButton("clear");
    private JButton redButton = new JButton("red");
    private JButton greenButton = new JButton("green");
    private JButton blueButton = new JButton("blue");
    private JButton undoButton = new JButton("undo");
    private JButton redoButton = new JButton("redo");

    // 생성자
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);

        // clear 버튼
        clearButton.addActionListener(e -> {
            history.clear();
            canvas.init();
            canvas.repaint();
        });

        // red 버튼
        redButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.red);
            history.append(cmd);
            cmd.execute();
        });

        // green 버튼
        greenButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);
            cmd.execute();
        });

        // blue 버튼
        blueButton.addActionListener(e -> {
            Command cmd = new ColorCommand(canvas, Color.blue);
            history.append(cmd);
            cmd.execute();
        });

        // undo 버튼
        undoButton.addActionListener(e -> {
            history.undo();
            canvas.repaint();
        });

        // redo 버튼
        redoButton.addActionListener(e -> {
            history.redo();
            canvas.repaint();
        });

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);
        buttonBox.add(greenButton);
        buttonBox.add(blueButton);
        buttonBox.add(undoButton);
        buttonBox.add(redoButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox);

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override public void windowActivated(WindowEvent e) {
    }

    @Override public void windowClosed(WindowEvent e) {
    }

    @Override public void windowDeactivated(WindowEvent e) {
    }

    @Override public void windowDeiconified(WindowEvent e) {
    }

    @Override public void windowIconified(WindowEvent e) {
    }

    @Override public void windowOpened(WindowEvent e) {
    }

    public static void main(String[] args) {
        System.out.println("20240761 이명진");
        new Main("Command Pattern Sample");
    }
}