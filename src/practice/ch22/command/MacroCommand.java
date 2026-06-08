package practice.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;


//  명령어 묶음이면서 하나의 명령어
public class MacroCommand implements Command { 
    // 명령의 배열 
    private Deque<Command> commands = new ArrayDeque<>();

    // 실행 
    @Override
    public void execute() {
        for (Command cmd: commands) {
            cmd.execute(); // 리커시브 호출
        }
    }

    // 추가 
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append"); // 같은거에 같은것을 넣어서 오류가 발생한다.
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            commands.pop(); // 넣는건 push 빼는건 pop
        }
    }

    // 전부 삭제 
    public void clear() {
        commands.clear();
    }
}
