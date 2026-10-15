class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int zero=0,one=0,two=0;
        int k=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
            else if(nums[i]==1){
                one++;
            }
            else{
                two++;
            }
        }
        while(zero>0){
            nums[k++]=0;
            zero--;
        }
        while(one>0){
            nums[k++]=1;
            one--;
        }
        while(two>0){
            nums[k++]=2;
            two--;
        }
    }
}