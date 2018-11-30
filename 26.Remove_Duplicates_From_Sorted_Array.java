//第一个是我的方法，很慢，因为我每次发现重复就把重复元素后面的元素往前移一位
//T = O(n^2)
	public int removeDuplicates(int[] nums) {
        if(nums.length==0) return 0;
        int temp = nums[0], length = nums.length;
        for(int i = 1; i<length; i++){
            if(temp == nums[i]){
                for(int j = i; j<length-1; j++)
                    nums[j] = nums[j+1];
                length--;
				//既然后面的元素向前移了一位，i就要保持原地不动
                i--;
            }
            temp = nums[i];
            System.out.println("temp "+temp);
        }
        return length;
    }
//这是网上的最优方法之一，统计偏移量index，把后面的值向前移动”偏移量“的位置
//T = O(n)
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int index = 0;
        int prior = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if(prior == nums[i]) {
                index++;
            } else {
                prior = nums[i];
                nums[i - index] = nums[i];
            }
        }
        
        return nums.length - index;
    }
//这是网站的标准答案，更好，保存两个位置指针，一个负责存值，一个负责读值
//T = O(n)
public int removeDuplicates(int[] nums) {
	if (nums.length == 0) return 0;
	int i = 0;
	for (int j = 1; j < nums.length; j++) {
		if (nums[j] != nums[i]) {
			i++;
			nums[i] = nums[j];
		}
	}
	return i + 1;
}
