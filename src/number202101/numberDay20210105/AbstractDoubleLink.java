package number202101.numberDay20210105;

public abstract class AbstractDoubleLink {


    /**
     * 添加到头节点
     * @param x
     */
    public  abstract void addFirst(Node x);

    /**
     * 删除目标节点
     * @param x
     */
    public  abstract void remove(Node x);

    /**
     * 删除链表最后一个节点
     * @param x
     * @return
     */
    public abstract Node removeLast(Node x);

    /**
     * 节点大小
     * @return
     */
    public abstract int size();



}
