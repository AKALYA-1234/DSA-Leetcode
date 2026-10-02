class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans=new int[m+n];
        int l1=0;
        int l2=0;
        int k=0;
        while(l1<m&&l2<n){
            if(nums1[l1]<=nums2[l2]){
                ans[k++]=nums1[l1];
                l1++;
            }
            else{
                ans[k++]=nums2[l2];
                l2++;
            }
        }
        while(l1<m){
            ans[k++]=nums1[l1++];
        }
        while(l2<n){
            ans[k++]=nums2[l2++];
        }
        for(int i=0;i<m+n;i++){
            nums1[i]=ans[i];
        }
    }
}