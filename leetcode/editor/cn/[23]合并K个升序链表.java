//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1219 👎 0


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ln = new ListNode();
        ListNode pn = ln;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pn.next = l2;
                break;
            } else if (l2 == null) {
                pn.next = l1;
                break;
            } else {
                if (l1.val > l2.val) {
                    pn.next = l2;
                    l2 = l2.next;
                } else {
                    pn.next = l1;
                    l1 = l1.next;
                }
                pn = pn.next;
            }
        }
        return ln.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int listLen = lists.length;
        if (listLen == 0) {
            return null;
        }
        if (listLen == 1) {
            return lists[0];
        } else if (listLen == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        } else {
            int middle = listLen / 2;
            ListNode[] lists1 = Arrays.copyOfRange(lists, 0, middle);
            ListNode[] lists2 = Arrays.copyOfRange(lists, middle, listLen);
            ListNode listsT1 = mergeKLists(lists1);
            ListNode listsT2 = mergeKLists(lists2);
            return mergeTwoLists(listsT1, listsT2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
