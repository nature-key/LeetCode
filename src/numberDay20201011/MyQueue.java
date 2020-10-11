package numberDay20201011;

import numberDay20201008.ListStack;

public class MyQueue {


    private String front;
    //栈中放着队列的数据
    ListStack<String> inputStack = new ListStack<>();
    ListStack<String> ouputStack = new ListStack<>();


    /**
     * 获取队列第一元素
     *
     * @return
     */
    public String peek() {
        return front;
    }

    /**
     * 出队
     *
     * @return
     */
    public String pop() {
        String pop = inputStack.pop();
        if (!inputStack.isEmpty()) {
            front = inputStack.peek();
        }
        return pop;

    }

    public void push(String e) {
        if (inputStack.isEmpty()) {
            front = e;
        }
        while (!inputStack.isEmpty()) {
            ouputStack.push(inputStack.pop());
        }
        inputStack.push(e);
        while (!ouputStack.isEmpty()) {
            inputStack.push(ouputStack.pop());
        }
    }


    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return inputStack.isEmpty();
    }


    public void show() {
        inputStack.show();
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }
}
