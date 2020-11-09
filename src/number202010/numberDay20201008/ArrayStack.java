package number202010.numberDay20201008;

import java.util.Arrays;

public class ArrayStack<T> {

    private Object[] stack;

    private int size;

    public ArrayStack() {
        this.stack = new Object[10];
    }

    public ArrayStack(int size) {
        this.stack = new Object[size];
    }


    public Object[] getStack() {
        return stack;
    }

    public void setStack(Object[] stack) {
        this.stack = stack;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 入栈
     *
     * @param e
     */
    public void push(T e) {
        expandCapacity(size + 1);
        stack[size] = e;
        size++;
    }

    /**
     * 返回栈定元素
     *
     * @return
     */
    public T peek() {
        T e = null;
        if (size > 0) {
            e = (T) stack[size - 1];
        }
        return e;

    }
    /**
     * 出栈
     *
     * @return
     */
    public T pop() {
        T peek = peek();
        if (size > 0) {
            stack[size - 1] = null;
            size--;
        }
        return peek;
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void show() {
        Arrays.stream(stack)
                .filter(it->it!=null)
                .forEach((e)->System.out.print(e.toString()+" "));
    }


    /**
     * 扩容
     *
     * @param size
     */
    private void expandCapacity(int size) {
        int length = stack.length;
        if (size >= length) {
            size = size * 2;
            stack = Arrays.copyOf(stack, size);
        }
    }


}
