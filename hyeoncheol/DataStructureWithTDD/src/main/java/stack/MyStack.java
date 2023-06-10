package stack;

public interface MyStack<E> {
    boolean empty();
    E peek();
    E pop();
    E push(E item);
    int search(Object o);
}
