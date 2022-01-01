package 阶段热身.juc.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class kafka1 {

    public  static WeakReference<ReplicaManager> replicaManger=
            new WeakReference<ReplicaManager>(new ReplicaManager());


    public static SoftReference<ReplicaManager> replicaManager =
            new SoftReference<ReplicaManager>(new ReplicaManager());
}
