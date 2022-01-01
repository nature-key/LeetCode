package 阶段热身.number202010.numberDay20201008;

public abstract class AbstractStack<T> {


    /**
     * 入栈
     * @param e
     * @return
     */
    public abstract T push(T e);

    /**
     * 返回栈定元素
     * @return
     */
    public abstract T peek();

    /**
     * 出栈
     * @return
     */
    public abstract T pop();

    /**
     * 是否为空
     */
    public abstract boolean isEmpty();


    public  void  expandCapacity(int size){



    }

    public abstract void show();




}
