class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int left=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=arr[i]){
                left=i;
                break;
            }
        }
        int right=0;
        for(int i=n-1;i>=0;i--){
            if(nums[i]!=arr[i]){
                right=i+1;
                break;
            }
        }
        return right-left;
    }
}