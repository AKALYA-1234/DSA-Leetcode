class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int prefixsum=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            int required=prefixsum-k;
            if(mp.containsKey(required)){
                count+=mp.get(required);
            }
            mp.put(prefixsum,mp.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}