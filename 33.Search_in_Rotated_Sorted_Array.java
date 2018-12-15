//这是我的算法，用的递归，时间复杂度应该是O(logn)
//网上的最优算法判断方式和我相似，但不是用递归而是用i, j这些指针来标位置
class Solution {
    public int search(int[] nums, int target) {
        return binary_search(nums, target, 0, nums.length-1);
    }
    public int binary_search(int[] nums, int target, int a, int b){
        if(a==b)
            return (nums[a] == target)?a:-1;
        if(a>b)
            return -1;
        int mid = (a+b)/2;
        System.out.println(a+" "+b+" "+mid);
        if(target>nums[mid]){
            if (nums[mid] > nums[a])
                return binary_search(nums, target, mid+1, b);
            else{
                if(target<=nums[b])
                    return binary_search(nums, target, mid+1, b);
                else
                    return binary_search(nums, target, a, mid-1);
            }
        }
        else if(target<nums[mid]){
            if(nums[mid]<nums[a])
                return binary_search(nums, target, a, mid-1);
            else{
                if(target>=nums[a])
                    return binary_search(nums, target, a, mid-1);
                else
                    return binary_search(nums, target, mid+1, b); 
            }
                
        }
        else
            return mid;
    }
}

//网上的最优算法
class Solution {
    public int search(int[] nums, int target) {
       if(nums.length == 0) return -1;
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int mid = (i + j) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] == nums[i]) i++;
            else if(nums[mid] > nums[i]) {
                if(nums[mid] > target && nums[i] <= target) j = mid - 1;
                else i = mid + 1;
            } else {
                if(nums[mid] < target && nums[j] >= target) i = mid + 1;
                else j = mid - 1;
            }
        }
        return -1;
    }
}
