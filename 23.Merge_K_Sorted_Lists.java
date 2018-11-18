//n，list的长度
//m, node的总数
//我个人的解法，hard难度，过了（拍手）
//就是速度相当慢，就赢了%4的人
//如果能把lists里的null元素删除应该会快上不少
//时间复杂度O(n*m)
public ListNode mergeKLists(ListNode[] lists){
    if(lists.length==0)
            return null;
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;

    while(true) {
        //find the list whose first node has the smallest value
        int min_index = 0;
        for (int i = 1; i < lists.length; i++) {
            if (lists[min_index] == null)
                min_index = i;
            else if (lists[i] == null)
                continue;
            else if (lists[min_index].val > lists[i].val)
                min_index = i;
        }

        //if all the lists are null, the min_index would still be pointed to null,
        //then the merged list would also be null
        if (lists[min_index] == null)
            break;

        //after finding the least value
        node.next = lists[min_index];
        lists[min_index] = lists[min_index].next;

        node = node.next;
    }
	return dummy.next;
}
//最佳答案的一种是用recursion的方法
//时间复杂度：画recursion tree，每一层的总时间复杂度都是m，有log n层
//所以是O(mlogn)
public ListNode mergeKLists(ListNode[] lists) {
	if (lists.length == 0) return null;
	return sort(lists, 0, lists.length - 1);
}
public ListNode sort(ListNode[] lists, int l, int r) {
	if (l == r) return lists[l];
	int mid = (r - l) / 2 + l;
	ListNode left = sort(lists, l, mid);
	ListNode right = sort(lists, mid + 1, r);
	return merge(left, right);
}

public ListNode merge(ListNode left, ListNode right) {
	ListNode dummy = new ListNode(0), ptr = dummy;
	while(left != null && right != null) {
		if (left.val < right.val) {
			ptr.next = left;
			left = left.next;
		} else {
			ptr.next = right;
			right = right.next;
		}
		ptr = ptr.next;
	}

	if (left == null) ptr.next = right;
	if (right == null) ptr.next = left;
	return dummy.next;
}

//Merge lists one by one
//Time = O(nm)
//Space = O(1)


//Brute Force
//把所有的node都拿出来然后排序后放进一个新的list里
//Time = O(mlogm)
//Space = O(m)


