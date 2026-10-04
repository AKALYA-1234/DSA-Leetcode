class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n*2];
        for(int i=0;i<2*n;i++){
            arr[i]=nums[i%n];
        }
        int totalone=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                totalone++;
            }
        }
        int left=0;
        int currone=0;
        int maxone=0;
        for(int i=0;i<2*n;i++){
            if(arr[i]==1){
                currone++;
            }
            while(i-left+1>totalone){
                if(arr[left]==1){
                    currone--;
                }
                left++;
            }
            maxone=Math.max(maxone,currone);
        }
        return totalone-maxone;
    }
}