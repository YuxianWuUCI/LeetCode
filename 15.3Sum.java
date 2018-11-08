    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a+b+c = 0?
     * Find all unique triplets in the array which gives the sum of zero
     * Note: the solution must not contain duplicate triplets
     */
    //这是网上的一个最优算法，真的很强
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //if there is only 2 elements, then no triplet exist
        if(nums.length<=2) return res;

        //sort the arrays
        Arrays.sort(nums);
        for (int i = 0; i<nums.length; i++){
            int a = nums[i];

            //if the first element is bigger than 0, no further triplet will meet the requirements
            if (a>0) break;

            //to avoid duplicates
            if (i>0 && nums[i-1] == a) continue;

            for(int j = i+1, k = nums.length-1; j<k;){
                int b = nums[j], c = nums[k];
                int value = a + b + c;

                //if value is bigger than 0, the sum need to be smaller
                //so let the k go down, else let the j go up
                if(value>0) k--;
                else if (value<0) j++;
                else{
                    List<Integer> ele =  new ArrayList<Integer>();
                    ele.add(a);
                    ele.add(b);
                    ele.add(c);

                    res.add(ele);
                    //to avoid duplicates
                    while(j<k && nums[++j]==b);
                    while(j<k && nums[--k]==c);

                }
            }
        }
        return res;
    }
}
//my solution
//用的是把3Sum问题转换为多个2Sum问题来解决的思路
//但不行，因为题目要求不能出现重复的triplets，而我很难快速地记录元素是否被重复使用过
//简单的方法是每次把ele加入list前先对ele排序然后判断ele是否存在于list中，但这样做超时了
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer,Integer> used = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++)
            used.put(nums[i], 0);
        for(int i = 0; i<nums.length; i++){
            //divide the three sum problem to n two sum problmes

            int sums = -1 * nums[i];
            Map<Integer,Integer> map = new HashMap<Integer, Integer>();
            for(int j = i+1; j<nums.length; j++){

                int complement = sums - nums[j];
                if (!map.containsKey(complement)){
                    map.put(nums[j], j);
                }
                else{
                    List<Integer> ele = new ArrayList<Integer>();
                    if (used.get(nums[i]) == 1 && used.get(nums[j]) == 1 && used.get(complement)==1)
                        continue;
                    used.replace(nums[i], 1);
                    ele.add(nums[i]);
                    used.replace(complement, 1);
                    ele.add(complement);
                    used.replace(nums[j], 1);
                    ele.add(nums[j]);

                    res.add(ele);

                }
            }
        }
        return res;
    }
