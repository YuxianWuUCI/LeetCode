/**这里的思路是先把每个String变量转换成char型数组
然后再对char型数组进行排序（我第一次知道有这么逆天的函数）
 接着把String变量加入到hashmap中
 
 每一个字符相同的String变量，将它们排序后的String变量都会完全相同
 **/
 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //如果输入的数组为空，返回一个空列表
        if(strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        //遍历strs里的String 变量
        for(String s : strs){
            //把String变量转成一个char型数组
            char[] ca = s.toCharArray();
            //我不知道有这么个函数啊
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            //如果map里目前没有anagrams of this String variable
            //add a new key to the list
            if(!ans.containsKey(key)) ans.put(key, new ArrayList());
            //then add the String to this key's List
            ans.get(key).add(s);
        }
        //seems like the values() functino will return a array of all the values
        //each value is a list
        //then ArrayList will transfer the array to a list
        //so it would be a list of the list<String>
        return new ArrayList(ans.values());
    }
}
