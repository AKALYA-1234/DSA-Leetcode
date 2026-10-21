class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        int max=0;
        int sum=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                sum-=1;
            }
            else{
                sum+=1;
            }
            if(mp.containsKey(sum)){
                int len=i-mp.get(sum);
                max=Math.max(max,len);
            }
            else{
                mp.put(sum,i);
            }
        }
        return max;
    }
}