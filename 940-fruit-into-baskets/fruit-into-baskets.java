class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int ans=0;
        int left=0;
        for(int right=0;right<n;right++){
            int curr=fruits[right];
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            while(mp.size()>2){
                int prev=fruits[left];
                mp.put(prev,mp.getOrDefault(prev,0)-1);
                if(mp.get(prev)==0){
                    mp.remove(prev);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}