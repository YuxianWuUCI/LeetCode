/*
 问题的要求是将两个用链表表示的数相加，是第一次见很难想到方法的题目
 以下是Solution
 时间复杂度:O(max(m,n))
 空间复杂度:O(max(m,n))
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//在链表前加一个dummy head是一种惯例，这样头节点可以像其他节点一样处理
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		//简洁明了的处理方式，值得学习
		while (p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;
			if (p != null) p = p.next;
			if (q != null) q = q.next;
		}
		if (carry > 0) {
			curr.next = new ListNode(carry);
		}
		return dummyHead.next;
	}
}
