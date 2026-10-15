class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<=j;k++){
                    set.add(nums.get(k));
                }
                ans+=set.size()*set.size();
                set.clear();
            }
        }
        return ans;
    }
}