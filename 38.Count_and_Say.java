/*
 我自己的算法，速度有点慢
 网上的最优算法感觉和我的差不多，但是用了一个stringbuilder类，好像在append操作上比string更快
 */
class Solution {
    public String countAndSay(int n) {
        String result="";
        if(n<1 || n>30) return result;
        result = "1";
        for(int i = 1; i<n; i++){
            result = FindNext(result);
            System.out.println(result);
        }
            
        return result;
    }
    public String FindNext(String a){
        int i = 0, num = 0;
        String result="";
        char temp=a.charAt(0);
        while(i < a.length()){
            if(a.charAt(i) == temp)
                num++;
            else{
                result = result+String.valueOf(num)+temp;
                temp = a.charAt(i);
                num=1;
            }
            i++;
        }
        result = result+String.valueOf(num)+temp;
        return result;
    }
}

/*
 网上的算法
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
		//用数组存上一次的值这点有意思
        char[] pre = countAndSay(n - 1).toCharArray();
        int i = 0, j = 0;
		//这个类之前没听说过
        StringBuilder sb = new StringBuilder();
        while (j < pre.length) {
            int count = 0;
            while (j < pre.length && pre[i] == pre[j]) {
                count++;
                j++;
            }
			//两个append一起用也很有意思
            sb.append(count).append(pre[i]);
            i = j;
        }
        return sb.toString();
    }
}
