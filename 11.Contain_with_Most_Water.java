/*
 Solution
 这就是一种没经历过的思考方式，拓宽了自己的视野
 时间复杂度：O(n)
 */
class Solution {
	public int maxArea(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			//把更短的边向里移动
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxarea;
	}
}
