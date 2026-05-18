package ch17.A2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameObserver extends Frame implements Observer, ActionListener {
    // GraphText는 통지된 수를 텍스트 필드로 표시하는 static 클래스 
    static class GraphText extends TextField implements Observer { //내부 class는 FrameObserver에서만 사용
        public GraphText(int columns) {
            super(columns);
        }

        @Override
        public void update(NumberGenerator generator) {
            int number = generator.getNumber();
            String text = number + ":";
            for (int i = 0; i < number; i++) {
                text += '*';
            }
            setText(text);
        }
    }

    // GraphCanvas는 통지된 수를 원그래프로 표시하는 static 클래스 
    static class GraphCanvas extends Canvas implements Observer {
        private int number;

        @Override
        public void update(NumberGenerator generator) {
            number = generator.getNumber();
            repaint(); // 도화지를 클리어하고 paint() 메소드를 호출한다. paint() 메소드에서 number의 값에 따라 원그래프를 그린다.
        }

        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            // 흰 색 원
            g.setColor(Color.white);
            g.fillArc(0, 0, width, height, 0, 360);
            // 빨간 색 원호
            g.setColor(Color.red);
            g.fillArc(0, 0, width, height, 90, - number * 360 / 50);
        }
    }

    private GraphText textGraph = new GraphText(60);
    private GraphCanvas canvasGraph = new GraphCanvas();
    private Button buttonClose = new Button("Close"); 

    public FrameObserver() { //생성자
        super("FrameObserver");

        setLayout(new BorderLayout()); 

        setBackground(Color.lightGray); // 프레임의 배경색을 밝은 회색으로 설정한다.
        textGraph.setEditable(false); // 텍스트 필드를 편집할 수 없도록 설정한다.
        canvasGraph.setSize(500, 500); // 캔버스의 크기를 500x500으로 설정한다.

        add(textGraph, BorderLayout.NORTH);// 북
        add(canvasGraph, BorderLayout.CENTER);//중앙
        add(buttonClose, BorderLayout.SOUTH);//남쪽

        buttonClose.addActionListener(this); // 버튼이 눌러지면 동작할 Listener
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0);
    }

    @Override
    public void update(NumberGenerator generator) {
        textGraph.update(generator);
        canvasGraph.update(generator);
    }
}

