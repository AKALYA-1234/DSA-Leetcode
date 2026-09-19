class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> bad=new HashSet<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i])){
                count++;
                set.add(nums[i]);
            }
            else if(nums[i]!=nums[i-1]&&!bad.contains(nums[i])){
                count--;
                bad.add(nums[i]);
            }
        }
        return count;
    }
}