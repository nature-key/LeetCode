package 基础数据结构;

public class MyStack {

    private int maxSize;

    private Object[] element;

    private int top;

    public MyStack(int initSize){
        this.maxSize=initSize;
        this.element=new Object[initSize];
        this.top=-1;
    }

    public MyStack(){
        new MyStack(100);
    }

    public  void push(Object str){
        this.element[++top]=str;
    }

    public Object pop(){
        return this.element[top--];
    }

    public boolean isEmpty(){
        return top==-1;
    }

}
