package stack;

public class DefaultStack<E> implements MyStack<E>{

    private E[] data;
    private int top;
    public DefaultStack() {
    }

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E push(E item) {
        return null;
    }

    @Override
    public int search(Object o) {
        return 0;
    }
}
