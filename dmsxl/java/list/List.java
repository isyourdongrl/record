package list;

import java.lang.reflect.Executable;

public class List {

    public static void main(String[] args) {


    }

    /**
     * q：移除链表元素 lc203
     * grade：easy
     * time：2022/9/6
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode dummy=new ListNode();
        ListNode node=dummy;
        while(head!=null){
            if(head.val!=val){
                node.next=head;
                node=node.next;
            }
            head=head.next;
        }
        node.next=null;
        return dummy.next;
    }

    /**
     * q：反转链表 lc206
     * grade：easy
     * time：2022/9/6
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev=head;
        head=head.next;
        prev.next=null;
        while(head!=null && head.next!=null){
            ListNode temp=head;
            head=head.next;
            temp.next=prev;
            prev=temp;
        }
        head.next=prev;
        return head;
    }

}


    /**
     * q：设计链表 lc707
     * grade：mid
     * time：2022/9/6
     */
    class MyLinkedList {

        Node dummy=null;

        public MyLinkedList() {
            dummy=new Node();
        }

        public int get(int index) {
            if(index>=dummy.size){
                return -1;
            }
            Node node=dummy.next;
            for(int i=0;i<index;i++){
                node=node.next;
            }
            return node.val;
        }

        public void addAtHead(int val) {
            Node node=dummy.next;
            dummy.next=new Node(val);
            dummy.next.next=node;
            dummy.size++;
        }

        public void addAtTail(int val) {
            Node node=dummy;
            while(node.next!=null){
                node=node.next;
            }
            node.next=new Node(val);
            dummy.size++;
        }

        public void addAtIndex(int index, int val) {
            if(index>dummy.size){
                return;
            }
            if(index==0 || index<0){
                addAtHead(val);
            }else{
                Node node=dummy.next;
                for(int i=0;i<index-1;i++){
                    node=node.next;
                }
                Node temp=node.next;
                node.next=new Node(val);
                node.next.next=temp;
            }
            dummy.size++;
        }

        public void deleteAtIndex(int index) {
            if(index>=dummy.size || index<0){
                return;
            }
            Node node=dummy.next;
            if(index==0){
                // 删除第一个节点
                dummy.next=node.next;
            }else{
                for(int i=0;i<index-1;i++){
                    node=node.next;
                }
                node.next=node.next.next;
            }
            dummy.size--;
        }
    }

    class Node{
        int val;
        Node next;
        int size;

        public Node(){}

        public Node(int val){
            this.val=val;
        }
    }

 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
