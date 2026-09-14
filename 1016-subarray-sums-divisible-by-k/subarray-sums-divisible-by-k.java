class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int prefixsum=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            int remainder = ((prefixsum % k) + k) % k;
            if(mp.containsKey(remainder)){
                count+=mp.get(remainder);
            }
            mp.put(remainder,mp.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}