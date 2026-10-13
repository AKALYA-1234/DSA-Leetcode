class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        int n=nums1.length;
        int m=nums2.length;
        int left=0,right=0;
        for(int i=0;i<n;i++){
            set.add(nums1[i]);
        } 
        for(int i=0;i<m;i++){
            set2.add(nums2[i]);
        }
        for(int i=0;i<n;i++){
            if(set2.contains(nums1[i])){
                left++;
            }
        }
        for(int i=0;i<m;i++){
            if(set.contains(nums2[i])){
                right++;
            }
        }
        int[] ans=new int[2];
        ans[0]=left;
        ans[1]=right;
        return ans;
    }
}