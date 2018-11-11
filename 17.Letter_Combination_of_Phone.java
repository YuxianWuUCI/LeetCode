class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return new ArrayList<String>();
         //Build map from digit to letters
        Map<Character, String> digitmap = new HashMap<Character, String>();
        digitmap.put('2', "abc");
        digitmap.put('3', "def");
        digitmap.put('4', "ghi");
        digitmap.put('5', "jkl");
        digitmap.put('6', "mno");
        digitmap.put('7', "pqrs");
        digitmap.put('8', "tuv");
        digitmap.put('9', "wxyz");

        //divide the digits to array of digit
        char[] nums = digits.toCharArray();
        String[] letters = new String[nums.length];

        for(int i = 0; i<nums.length; i++){
            letters[i] =  digitmap.get(nums[i]);
        }
        //to pick up the char from each letter, we need to know the subindex
        //like if the whole index is 0, means the first element in res,
        //its subindex would be like 0, 0, ..., 0
        //whole index = 1, subindex 0,0,.., 0, 1
        //last element in result, subindex 3 or 4, 3 or 4, ..., 3 or 4
        int[] length = new int[nums.length];
        int[] mod = new int[nums.length];
        
        length[nums.length-1] = letters[nums.length-1].length();
        mod[nums.length-1] = 1;
        //record each digit's letter's length and to compute the subindex in this letter, which number the whole index should be divided
        for(int i = nums.length - 2; i>=0; i--){
            length[i] = letters[i].length();
            mod[i] = length[i+1] * mod[i+1];
        }
        List<String> res = new ArrayList<String>();
        for(int i = 0; i<mod[0]*length[0]; i++){
            String ele = new String();
            for(int j = 0; j<nums.length; j++){
                //to compute the subindex in letter[i]
                ele+=letters[j].charAt((i/mod[j])%length[j]);
            }
            res.add(ele);
        }
        return res;
    }
}

