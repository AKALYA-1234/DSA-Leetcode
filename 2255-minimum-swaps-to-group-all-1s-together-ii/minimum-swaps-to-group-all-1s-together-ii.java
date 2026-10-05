class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[] arr=new int[2*n];
        for(int i=0;i<2*n;i++){
            arr[i]=nums[i%n];
        }
        int one=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                one++;
            }
        }
        int currone=0;
        int ans=0;
        int left=0;
        for(int i=0;i<2*n;i++){
            if(arr[i]==1){
                currone++;
            }
            while(i-left+1>one){
                if(arr[left]==1){
                    currone--;
                }
                left++;
            }
            ans=Math.max(ans,currone);
        }
        return one-ans;
    }
}