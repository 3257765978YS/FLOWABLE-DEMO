package dataStructures.stack;

/**
 * @author : 杨帅
 * @description:
 * @date： 2021/10/26 10:53
 */
public interface Stack<T> {
    // return the number of elements in the stack
    public int size();

    // return if the stack is empty
    public boolean isEmpty();

    // push the element on the stack
    public void push(T elem);

    // pop the element off the stack
    public T pop();

    public T peek();
}
