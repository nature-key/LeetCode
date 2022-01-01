package 阶段热身.juc.test;

public class ReplicaManager {
    private ReplicaFetcher replicaFetcher = new ReplicaFetcher();






    public static ReplicaManager instance;

    @Override
    protected void finalize() throws Throwable {
        ReplicaManager.instance = this;
    }


    public void loadReplicasFromDisk() {
        Boolean hasFinishedLoad = false;
        if (isLoacalDataCorrupt()) {
            //....
        }

    }

    public void load(){

    }

    public Boolean isLoacalDataCorrupt() {
        Boolean isCorrupt = false;
        return isCorrupt;
    }
}
