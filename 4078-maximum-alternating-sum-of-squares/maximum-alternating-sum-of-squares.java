class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                nums[i]=-nums[i];
            }
        }
        Arrays.sort(nums);
        int j=0;
        int k=1;
        while(k<n){
            arr[k]=nums[j++];
            k+=2;
        }
        k=0;
        while(k<n){
            arr[k]=nums[j++];
            k+=2;
        }
        long sum=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                sum+=arr[i]*arr[i];
            }
            else{
                sum-=arr[i]*arr[i];
            }
        }
        return sum;
    }
}