package stack;

public class EmptyMyStackException extends RuntimeException{

    public EmptyMyStackException() {
        super("빈 스택 예외 발생");
    }
}
