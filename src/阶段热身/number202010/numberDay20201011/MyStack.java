package 阶段热身.number202010.numberDay20201011;

public class MyStack {


    MyQueue queue1= new MyQueue();

    MyQueue queue2 = new MyQueue();


    /**
     * 1.放入q2
     * 2.如果q1不为空，把q1放入q2
     * 3.把q2放入到q1中
     *
     * @param e
     */
    public  void push(String e){
        queue2.push(e);
        while (!queue1.isEmpty()){
            queue2.push(queue1.pop());
        }
        while (!queue2.isEmpty()){
            queue1.push(queue2.pop());
        }
    }

    public  String peek(){
        return queue1.peek();
    }

    public String pop(){
        return queue1.pop();
    }

    public  boolean isEmpty(){
        return queue1.isEmpty();
    }

    public  void show(){
        queue1.show();
    }

}
