package list;

import java.lang.reflect.Executable;
import java.util.HashSet;

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
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        while (head != null) {
            if (head.val != val) {
                node.next = head;
                node = node.next;
            }
            head = head.next;
        }
        node.next = null;
        return dummy.next;
    }

    /**
     * q：反转链表 lc206
     * grade：easy
     * time：2022/9/6
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        head = head.next;
        prev.next = null;
        while (head != null && head.next != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        head.next = prev;
        return head;
    }

    /**
     * q：两两交换链表中的节点 lc24
     * grade：mid
     * time：2022/9/9
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        // 若为null或只有一个节点，则不需要反转
        if (head == null || head.next == null) {
            return head;
        }

        // 使用虚拟头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.next != null) {
            ListNode tmp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = tmp;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * q：删除链表的倒数第N个节点 lc19
     * grade：19
     * time：2022/9/9
     * 注意：需要注意删除第一个节点的情况，所以最好设置一个虚拟头节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        // 快慢指针，先让快指针向后走n步
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            // 说明删除第一个节点
            return dummy.next.next;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }


    /**
     * q：链表相交 lc面试题02.07
     * grade：easy
     * time：2022/9/9
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        方法一：
//        ListNode m=headA;
//        ListNode n=headB;
//        while (m!=n){
//            m=m==null?headB:m.next;
//            n=n==null?headA:n.next;
//        }
//        return m;


//        方法二：
        ListNode m = headA;
        ListNode n = headB;
        while (m != null && n != null) {
            m = m.next;
            n = n.next;
        }

        if (m == null) {
            // headA比较短
            while (n != null) {
                n = n.next;
                headB = headB.next;
            }
        } else {
            // headB比较短
            while (m != null) {
                m = m.next;
                headA = headA.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


    /**
     * q：环形链表二
     * grade：mid
     * time：2022/9/9
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }

        HashSet<ListNode> set=new HashSet<>();
        while (head!=null){
            if(!set.contains(head)){
                set.add(head);
            }else{
                return head;
            }
            head=head.next;
        }
        return null;
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
