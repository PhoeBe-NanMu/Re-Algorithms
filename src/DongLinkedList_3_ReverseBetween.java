/**
 * 反转链表前N个元素
 * 递归思想实现
 * 2024-04-29
 * LeiYang
 */


public class DongLinkedList_3_ReverseBetween {

    public static void main(String[] args) {

        // 创建链表
        ListNode listNode = new ListNode();
        ListNode p = listNode;

        for (int i = 1; i < 10; i++) {
            ListNode listNodeTemp = new ListNode(i);
            p.next = listNodeTemp;
            p = p.next;
        }

        // 打印链表
        ListNode p1 = listNode;
        while (p1 != null){
            System.out.print(p1.data+" ");
            p1 = p1.next;
        }
        System.out.print("\n");

        // 调用关键代码
        ListNode head = listNode;
        ListNode res = new DongLinkedList_3_ReverseBetween().reverseBetweeen(head,4,7);
        while (res != null){
            System.out.print(res.data+" ");
            res = res.next;
        }

    }


    // 后驱节点 ，避免反转后后驱丢失
    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {

        // n==1时，还没有递归，此时的实参 head 是第n个元素
        if (n==1){
            successor = head.next;
            return head;
        }

        ListNode newHeadNode = reverseN(head.next,n-1);

        head.next.next = head;
        head.next = successor;

        return newHeadNode;

    }

    public ListNode reverseBetweeen(ListNode head, int m, int n) {

        if (m == 1){
            return reverseN(head,n);
        }

        head.next = reverseBetweeen(head.next,m-1,n-1);
        return head;

    }

}
