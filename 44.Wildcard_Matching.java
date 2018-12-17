/*
 这个是我参考第9题写的答案，这题更简单一些，第9题要求*只能指代preceding element
 时间复杂度：O(mn)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null) return false;
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        
        match[0][0] = true;
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i-1) == '*')
                match[0][i] = match[0][i-1];
        }
        for(int i=1; i<=s.length(); i++){
            for(int j=1; j<=p.length(); j++){
                if(p.charAt(j-1) == '?' || p.charAt(j-1)==s.charAt(i-1))
                    match[i][j] = match[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    //[i-1][j]表示用了*，[i][j-1]表示不用*
                    match[i][j] = match[i-1][j]||match[i][j-1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
