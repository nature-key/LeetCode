package 基础数据结构;

import java.util.List;

public class ListNodeUtil {


    private static ListNode  head=null;


    public static ListNode addNode(int value){

        ListNode newNode = new ListNode(value);

        if(head==null){
            head=newNode;
            return head;
        }
        ListNode curr=head;
        while (curr.getNext()!=null){
            curr=curr.getNext();
        }
        curr.setNext(newNode);
        return head;
    }


    public static boolean  delNode(int value){

        if(head==null){
            return false;
        }
        if(head.getValue()==value){
            head=head.getNext();
            return true;
        }

        ListNode curr=head;
        while (curr.getNext()!=null){
            if (curr.getNext().getValue()==value) {
                curr.setNext(curr.getNext().getNext());
                return true;
            }
            curr=curr.getNext();
        }
        return false;
    }

    public static  void addNodes(int[] values){
        for (int i = 0; i < values.length; i++) {
            addNode(values[i]);
        }
    }

    public static  void print(){

        if(head==null){
            System.out.println("没有节点");
            return;
        }
        ListNode curr=head;
        while (curr!=null){
            System.out.print(curr.getValue()+"->");
            curr=curr.getNext();
        }
    }

    public static ListNode getHead() {
        return head;
    }

    public static void setHead(ListNode head) {
        ListNodeUtil.head = head;
    }
}
