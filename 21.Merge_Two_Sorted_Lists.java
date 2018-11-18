//这个是用递归解决问题，非常的简洁明了，而且并没有创什么新的变量好像也没有重复计算相同的subproblems
//用DP可能做不到这一点，或者说会比这个麻烦很多，因为DP得从最小的subproblem开始往上走
public ListNode mergeTwoLists(ListNode l1, ListNode l2)
{
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    if(l1.val<l2.val){
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }
    else{
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
}

//这个是和我的想法一样，用的是最直接的方法
//但麻烦的细节在于开头的节点和中间的节点的情况不一样，无法在while循环里统一处理
//这里创建了一个空节点作为开头节点，返回的时候返回的是空节点的下一位，做到了大家的情况都统一
//还有一点，这里把加元素的方法也很有意思，我原来的想法是创一个新节点加进list里，他直接用的比较的节点本身
//非常好，逻辑很清晰
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;

    while(l1 != null && l2!=null){
        if(l1.val <= l2.val){
            node.next = l1;
            l1 = l1.next;
        }
        else{
            node.next = l2;
            l2 = l2.next;
        }
        node = node.next;
    }
    if(l1 != null){
        node.next = l1;
    }
    if(l2 != null){
        node.next = l2;
    }
    return dummpy.next;
}
