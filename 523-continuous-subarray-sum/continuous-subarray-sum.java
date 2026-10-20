class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int sum=0;
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int required=sum%k;
            if(mp.containsKey(required)){
                int prev_index=mp.get(required);
                if(i-prev_index>=2){
                    return true;
                }
            }
            else{
                mp.put(required,i);
            }
        }   
        return false;
    }
}