class Solution {
    public int findMaxLength(int[] nums) {
       int n=nums.length;
       int prefixsum=0;
       int ans=0;
       HashMap<Integer,Integer> mp=new HashMap<>();
       mp.put(0,-1);
       for(int i=0;i<n;i++){
        if(nums[i]==0){
            prefixsum-=1;
        }
        else{
            prefixsum+=1;
        }
        if(mp.containsKey(prefixsum)){
            int len=i-mp.get(prefixsum);
            ans=Math.max(ans,len);
        }
        else{
            mp.put(prefixsum,i);
        }
       } 
       return ans;
    }
}