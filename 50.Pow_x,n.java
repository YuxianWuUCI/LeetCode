//我一开始看这段代码还在想这有什么难的，直接一路乘过去不就好了，O(n)的复杂度嘛
//然后我就忘了n是负数的情况，然后别人就用了递归O(logn)...
/*
 这是网上的最优代码
 时间复杂度：O(logn)
 */
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
			//-(n+1)是因为int的最小负值反过来比最大正值大一位
            return myPow(1/x, -(n+1))/x;
        }
        if (n % 2 == 0) {
            return myPow(x*x, n/2);
        } else {
            return myPow(x*x, n/2)*x;
        }
        
    }
}
/*
 这是我在网上看到的一个比较有意思的代码
 比上面的这个更慢，可能是判断次数过多，而且n是负数的情况一直没改吧
 */
class Solution {
	public double myPow(double x, int n) {
		//System.out.println(n);
		if(n == 0) return 1.0;
		double d = myPow(x, n/2);
		if(n%2 == 0) return d*d;
		if(n < 0) return d*d*(1/x);
		return d*d*x;
	}
}
