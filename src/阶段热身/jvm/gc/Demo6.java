package 阶段热身.jvm.gc;

import java.util.ArrayList;
import java.util.List;

public class Demo6 {


    public static void main(String[] args) throws Exception {
        List<Data> datas = new ArrayList<Data>();
        for (int i = 0; i < 10000; i++) {
            datas.add(new Data());
        }
        Thread.sleep(1 * 60 * 60 * 1000);
    }

    static class Data {

    }

}

