public List<List<Integer>> subsets(int[] S) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
   
    if(S.length == 0){
        return result;
    }
    
    Arrays.sort(S);
    dfs(S, 0, new ArrayList<Integer>(), result);
    return result;
}

public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
    result.add(new ArrayList<Integer>(path));
    
    for(int i = index; i < s.length; i++){
        path.add(s[i]);
        dfs(s, i+1, path, result);
        path.remove(path.size()-1);
    }
}
