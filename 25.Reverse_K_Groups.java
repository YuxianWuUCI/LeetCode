//读取k个元素，把他们的值分别存入数组，当k个值存满，将这k个ListNode的val按照reverse数组的反方向赋值
//有意思的地方在于保存prev指向k个ListNode的前面一个ListNode
//dummy的概念一直都很有用
//T(n) = O(n)
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        int[] reverse = new int[k];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode prev=dummy;
        while(dummy.next != null){
            dummy = dummy.next;
            reverse[count++] = dummy.val;
            if(count==k){
                //Do the reverse
                count = 0;
                prev = prev.next;
                for(int i = 0; i<k; i++){
                    prev.val = reverse[k-i-1];
                    prev = prev.next;
                }
                prev = dummy;
            }
        }
        return head;
    }
