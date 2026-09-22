class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int prefixsum=0;
        int ans=0;
        mp.put(0,1);
        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            int required=prefixsum-goal;
            if(mp.containsKey(required)){
                ans+=mp.get(required);
            }
            mp.put(prefixsum,mp.getOrDefault(prefixsum,0)+1);
        }
        return ans;
    }
}