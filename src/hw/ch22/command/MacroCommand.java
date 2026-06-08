package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MacroCommand implements Command {
    // 실행된 명령들을 저장하는 Deque
    private Deque<Command> commands = new ArrayDeque<>();

    // Undo 된 명령들을 Redo 하기 위해 저장하는 Deque
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // 실행
    @Override
    public void execute() {
        Iterator<Command> it = commands.descendingIterator();

        while (it.hasNext()) {
            Command cmd = it.next();
            cmd.execute();
        }
    }

    // 명령 추가
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }

        commands.push(cmd);

        // Undo 후 새 명령이 들어오면 기존 Redo 이력은 무효화
        commandsForRedo.clear();
    }

    // 마지막 명령 취소
    public void undo() {
        if (!commands.isEmpty()) {
            Command cmd = commands.pop();
            commandsForRedo.push(cmd);
        }
    }

    // Undo 된 명령 다시 실행
    public void redo() {
        if (!commandsForRedo.isEmpty()) {
            Command cmd = commandsForRedo.pop();
            commands.push(cmd);
        }
    }

    // 전체 삭제
    public void clear() {
        commands.clear();
        commandsForRedo.clear();
    }
}