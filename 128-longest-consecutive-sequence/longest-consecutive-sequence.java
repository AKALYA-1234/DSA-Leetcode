class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        if(n!=0){
            list.add(nums[0]);
        }
        else{
            return 0;
        }
        for(int i=1;i<n;i++){
            if(list.get(list.size()-1)!=nums[i]){
                list.add(nums[i]);
            }
        }
        int count=1;
        int maxcount=0;
        for(int i=1;i<list.size();i++){
            if(list.get(i)-list.get(i-1)!=1){
                if(count>maxcount){
                    maxcount=count;
                }
                count=0;
            }
            count++;
        }
        if(count>maxcount){
            maxcount=count;
        }
        return maxcount;
    }
}