class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
        int left=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int ans=0;
        for(int right=0;right<n;right++){
            mp.put(nums[right],mp.getOrDefault(nums[right],0)+1);
            while(mp.get(nums[right])>1){
                mp.put(nums[left],mp.get(nums[left])-1);
                left++;
            }
            int sum=0;
            for(int i=left;i<=right;i++){
                sum+=nums[i];
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}