class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE;;
        for(int i=0;i<n;i++){
            if(nums[i]<9){
                if(nums[i]==i){
                    if(i<min){
                        min=i;
                    }
                }
            }
            else{
                int num=nums[i];
                int sum=0;
                while(num!=0){
                    int temp=num%10;
                    sum+=temp;
                    num=num/10;
                }
                if(sum==i){
                    if(i<min){
                        min=i;
                    }
                }
            }
        }
        if(min==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return min;
        }
    }
}