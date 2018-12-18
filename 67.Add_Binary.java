/*
 题目：将两个string的二进制相加返回对应结果的字符串
 这是网上的最优算法，我的算法模仿了之前的multiply string的方法，但速度很慢
 时间复杂度:O(max(m,n))
 空间复杂度:O(max(m,n))
 我的也是
 */
public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int ia;
        int ib;
        int digit;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0) {
            ia = i >= 0 ? a.charAt(i) - '0' : 0;
            ib = j >= 0 ? b.charAt(j) - '0' : 0; 
            digit = (ia + ib + carry) % 2;
            carry = (ia + ib + carry) / 2;
            sb.append(digit);
            i --;
            j --;
        }
        if(carry == 1) sb.append(carry);
        sb.reverse();
        return sb.toString();
    }

//这是我的算法，太慢了，创了很多不必要的变量还调用了好几次max函数
class Solution {
	public String addBinary(String a, String b) {
		int m = a.length(), n=b.length();
		int[] pos = new int[Math.max(m, n)+1];
		int i=m-1, j=n-1;
		while(i>=0 || j>=0){
				//calculate the sum
			int sum = ((i>=0)?(a.charAt(i)-'0'):0)+((j>=0)?(b.charAt(j)-'0'):0);
			System.out.println("sum: "+sum);
			int p = Math.max(i, j)+1;
			System.out.println("p: "+p);
			sum += pos[p];
			
			pos[p-1] = sum/2;
			pos[p] = sum%2;
			i--;
			j--;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int p : pos) if(!(sb.length()==0 && p==0))sb.append(p);
		return sb.length() == 0?"0":sb.toString();
	}
}
