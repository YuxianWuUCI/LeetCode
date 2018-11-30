//我还以为会有KMP算法，结果就是这样就搞定了
//T(n) = O(mn)，m是haystack的长度，n是needle的长度，最差的情况是每一位都要比对needle到最后一位才知道不是
class Solution {
    public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            if (haystack.substring(i, i + needle.length()).compareTo(needle)==0) 
                return i;
        }
        return -1;
    }
}
