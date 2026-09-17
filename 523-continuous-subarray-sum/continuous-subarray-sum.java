class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        int prefixsum=0;
        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            int remainder=prefixsum%k;
            if(mp.containsKey(remainder)){
                int previousindex=mp.get(remainder);
                if(i-previousindex>=2){
                    return true;
                }
            }
            else{
                mp.put(remainder,i);
            }
        }
        return false;
    }
}