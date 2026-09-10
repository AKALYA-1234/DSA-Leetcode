class Solution {
    public int totalFruit(int[] nums) {
        int n=nums.length;
        int left=0;
        int ans=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int right=0;right<n;right++){
            int curr=nums[right];
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            while(mp.size()>2){
                int prev=nums[left];
                mp.put(prev,mp.get(prev)-1);
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