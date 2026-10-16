class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        long ans=0;
        long sum=0;
        int left=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            mp.put(nums[right],mp.getOrDefault(nums[right],0)+1);
            if(right-left+1==k){
                if(mp.size()==k){
                    ans=Math.max(ans,sum);
                }
                sum-=nums[left];
                mp.put(nums[left],mp.get(nums[left])-1);
                if(mp.get(nums[left])==0){
                    mp.remove(nums[left]);
                }
                left++;
            }
        }
        return ans;
    }
}