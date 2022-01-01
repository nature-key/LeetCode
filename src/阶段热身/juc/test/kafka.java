package 阶段热身.juc.test;

public class kafka {

    private static  ReplicaFetcher fetcher = new ReplicaFetcher();

    public static void main(String[] args) {
       loadReplicasFromDisk();

       while (true){
           fetchReplicasFromRemote();
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    private static void loadReplicasFromDisk(){
        ReplicaManager replicaManager = new ReplicaManager();
        replicaManager.load();
    }
    public static void fetchReplicasFromRemote(){
        fetcher.fetch();
    }
}
