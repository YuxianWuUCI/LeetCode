/*
 题目：开根号操作，返回整数，去除小数点后的值，溢出是一个需要考虑的重要情况
 Input: 8
 Output: 2
 这是我根据discussion改的自己的代码
 时间：O(logn)
 空间：O(1)
 */
class Solution {
	public int mySqrt(int x) {
		if(x == 0) return 0;
		if(x == 1) return 1;
		int a=0, b=x;
		int mid = 0;
		while(a<=b){
			mid = a + (b-a)/2;
			//这个很拖累速度的
			System.out.println("a: "+a+" b: "+b);
			//完美避免了溢出的情况
			//还有一种方法是申请long的变量，这样就不怕溢出了
			if(mid<=x/mid && (mid+1)>x/(mid+1)) return mid;
			else if(mid>x/mid) b = mid-1;
			else a = mid+1;
		}
		return a;
	}
}
