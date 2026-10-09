class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        if(n!=0){
            set.add(nums[0]);
        }
        int maxcount=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]>1){
                if(set.size()>maxcount){
                    maxcount=set.size();
                }
                set.clear();
            }
            set.add(nums[i]);
        }
        if(set.size()>maxcount){
            maxcount=set.size();
        }
        return maxcount;
    }
}