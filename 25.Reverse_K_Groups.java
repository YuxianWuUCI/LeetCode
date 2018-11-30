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
            //System.out.println("dummy = "+dummy.val);
            if(count==k){
                //Do the reverse
                //System.out.println("count "+count);
                count = 0;
                prev = prev.next;
                for(int i = 0; i<k; i++){
                    prev.val = reverse[k-i-1];
                    prev = prev.next;
                }
                prev = dummy;
                //System.out.println("prev = "+prev.val);
            }
        }
        return head;
    }
