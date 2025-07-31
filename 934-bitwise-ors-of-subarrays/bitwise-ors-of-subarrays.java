class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer>ans=new HashSet<>();
        Set<Integer>cur=new HashSet<>();
        for(int a:arr){
            Set<Integer>nxt=new HashSet<>();
            nxt.add(a);
            for(int x:cur){
                nxt.add(a|x);
            }
            cur=nxt;
            ans.addAll(cur);
        }
        return ans.size();
        
    }
}