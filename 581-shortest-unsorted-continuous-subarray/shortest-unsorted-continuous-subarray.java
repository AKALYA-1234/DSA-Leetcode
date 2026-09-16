class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int right=0;
        int left=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=nums[i]){
                left=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(arr[i]!=nums[i]){
                right=i+1;
                break;
            }
        }
        return right-left;
    }
}