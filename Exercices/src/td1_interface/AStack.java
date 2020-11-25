package td1_interface;

public interface AStack {

    boolean isEmpty();
    void push(Object objet) throws FullStackException;
    Object peek();
    Object pop();

}
