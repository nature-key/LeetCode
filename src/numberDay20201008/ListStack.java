package numberDay20201008;

import java.util.ArrayList;
import java.util.List;

public class ListStack<T> extends AbstractStack<T> {

    private List<T> list = new ArrayList<>();


    @Override
    public T push(T e) {
        list.add(e);
        return e;
    }

    @Override
    public T peek() {
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    @Override
    public T pop() {
        T peek = peek();
        if (list.size() > 0) {
            list.remove(list.size() - 1);
        }
        return peek;


    }


    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }


    @Override
    public void show() {

        list.forEach((e)->System.out.print(e+" "));
        System.out.println();

    }
}
