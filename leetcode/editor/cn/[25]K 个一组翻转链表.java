//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 进阶：
//
//
// 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
// 示例 3：
//
//
//输入：head = [1,2,3,4,5], k = 1
//输出：[1,2,3,4,5]
//
//
// 示例 4：
//
//
//输入：head = [1], k = 1
//输出：[1]
//
//
//
//
//
// 提示：
//
//
// 列表中节点的数量在范围 sz 内
// 1 <= sz <= 5000
// 0 <= Node.val <= 1000
// 1 <= k <= sz
//
// Related Topics 链表
// 👍 990 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 自己写的
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup1(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        // p1记录头部，p2记录取栈
        ListNode pointer = head, p1 = null, p2 =null;
        int count = 0;
        while (pointer != null) {
            count++;
            stack.push(pointer);
            pointer = pointer.next;
            if (count == k) {
                for (int i = 0; i < k; i++) {
                    ListNode currNode = stack.pop();
                    if (p2 != null) {
                        p2.next = currNode;
                        p2 = p2.next;
                    } else {
                        p2 = currNode;
                    }
                    // 头
                    if (p1 != null && i == 0) {
                        p1.next = currNode;
                    }
                    if (p1 == null && i == 0) {
                        head = currNode;
                    }
                    // 尾
                    if (i == k - 1) {
                        currNode.next = pointer;
                        // 尾做为下一个头
                        p1 = currNode;
                    }
                }
                count = 0;
            }
        }
        return head;
    }

    /**
     * 抄的
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

}
//leetcode submit region end(Prohibit modification and deletion)
