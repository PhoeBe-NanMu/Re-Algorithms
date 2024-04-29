/**
 * 链表反转
 * 递归思想实现
 * 2024-04-29
 * LeiYang
 */


public class DongLinkedList_1_Reverse {

    public static void main(String[] args) {

        // 创建链表
        ListNode listNode = new ListNode();
        ListNode p = listNode;

        for (int i = 1; i < 5; i++) {
            ListNode listNodeTemp = new ListNode(i);
            p.next = listNodeTemp;
            p = p.next;
        }
        // 打印链表
//        while (listNode != null){
//            System.out.println(listNode.data);
//            listNode = listNode.next;
//        }

        // 调用关键代码
        ListNode head = listNode;
        ListNode res = new DongLinkedList_1_Reverse().reverse(head);
        while (res != null){
            System.out.println(res.data);
            res = res.next;
        }

    }

    // 解决方法
    public ListNode reverse(ListNode head){
        if (head ==null || head.next ==null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
