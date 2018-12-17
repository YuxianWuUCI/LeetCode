/*
 这是网上的一个最优算法，用的是动态规划
 时间复杂度O(mn)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
		//match[i][j]表示s[0~i-1]和p[0~j-1]两个子字符串的匹配情况
        boolean[][] match = new boolean[s.length() +1][p.length() + 1];
        
        match[0][0] = true;
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i -1) == '*')
                //第一位应该不能为*，因为*前面需要一个preceding element
                match[0][i] = match[0][i-2];
        }
        
        for (int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= p.length(); j++){
                if(p.charAt(j -1) == '.' || s.charAt(i -1) == p.charAt(j -1)){
					//这是最普通的情况
                    match[i][j] = match[i -1][j -1];
                }else if (p.charAt(j-1) == '*'){
					//如果j-1是*那么这个*表示的就是j-2的element
                    //This means p[j-2] match s[i-1]
                    if(p.charAt(j-2) == s.charAt(i - 1) || p.charAt(j -2) == '.'){
						//如果p[j-2]和s[i-1]匹配分两种可能
						//1. 用j-2的字符
						//2. 不用j-2的字符
                        //even it matches, the program still needs to check [i][j-2] which means it may not need p[j-2] for the maching
                        match[i][j] = match[i][j-2] || match[i-1][j];
                        
                    }else{
                        match[i][j] = match[i][j -2];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}

public static boolean isMatch(String s, String p){
        //if pattern is empty then only s is empty will cause true
        if(p.isEmpty()) return s.isEmpty();
        //see whether the first character match
        boolean first_match = (!s.isEmpty() && (p.charAt(0)==s.charAt(0) || p.charAt(0) == '.'));
        //consider about the wild card
        if(p.length() >= 2 &&  p.charAt(1)=='*'){
            //if first march is true, move the pointer of text 1 step forward
            //else move the pointer of pattern 2 steps forward
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1),p)));
        }
        else{
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
}
    enum Result {
        TRUE, FALSE
    }
    Result[][]memo;
    public boolean isMatch_DP(String s, String p){
        memo = new Result[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }
    public boolean dp(int i, int j, String text, String pattern){
        if(memo[i][j] != null){
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if(j == pattern.length()){
            ans = i == text.length();
        }else{
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j)=='.'));
            if(j+1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) || first_match && dp(i+1, j, text, pattern));
            }else{
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;

    }


