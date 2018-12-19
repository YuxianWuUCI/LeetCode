/*
 题目:Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 
 Note: You are not suppose to use the library's sort function for this problem.
 
 Example:
 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 方法：
 这是网上的方法，非常强，希望我有一天也能想到这么棒的算法
 时间复杂度:O(n)
 空间复杂度:O(1)
 1 0 2 2 1 0
 ^         ^
 L         H
 M
 
 Mid != 0 || 2
 Mid++
 
 1 0 2 2 1 0
 ^ ^       ^
 L M       H
 
 Mid == 0
 Swap Low and Mid
 Mid++
 Low++
 
 0 1 2 2 1 0
 ^ ^     ^
 L M     H
 
 Mid == 2
 Swap High and Mid
 High--
 
 0 1 0 2 1 2
 ^ ^   ^
 L M   H
 
 Mid == 0
 Swap Low and Mid
 Mid++
 Low++
 
 0 0 1 2 1 2
 ^ ^ ^
 L M H
 
 Mid == 2
 Swap High and Mid
 High--
 
 0 0 1 1 2 2
 ^ ^
 L M
 H
 
 Mid <= High is our exit case
 */
class Solution {
	public void sortColors(int[] nums) {
		int L = 0, M = 0, H = nums.length-1;
		int temp = 0;
		while(M<=H){
			switch(nums[M]){
				case 0:
					temp = nums[M];
					nums[M] = nums[L];
					nums[L] = temp;
					L++;
					M++;
					break;
				case 1:
					M++;
					break;
				case 2:
					temp = nums[M];
					nums[M] = nums[H];
					nums[H] = temp;
					H--;
					break;
			}
		}
		
		
	}
}
