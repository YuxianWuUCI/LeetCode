/*
 题目：输入两个二进制字符串，返回两者相乘的结果的字符串形式
 这个是网上找到的一段代码，非常厉害
 我原本的打算是笨拙地用string直接模拟乘法口诀，但是这样switch要例举的case太多，非常麻烦
 我觉得网上这段代码最厉害的地方就是它用int数组的index表示一个整数的第几位，这真的很厉害
 */
class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
				//这个用ASCII码的差来直接得出int值的方法我觉得很狡猾，但是确实很好用
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				//第i位和第j位的两个数相乘得出的结果存在结果的第i+j和i+j+1位这点非常厉害
                int p1 = i + j, p2 = i + j + 1;
				//要与原本存着的结果想加
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
