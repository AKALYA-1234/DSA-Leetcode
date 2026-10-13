class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int left=0;
        int right=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i]==nums2[j]){
                    left++;
                    break;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(nums2[i]==nums1[j]){
                    right++;
                    break;
                }
            }
        }
        int[] ans=new int[2];
        ans[0]=left;
        ans[1]=right;
        return ans;
    }
}