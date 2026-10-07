class Solution {
    public int largestRectangleArea(int[] nums) {
        int n=nums.length;
        int[] pse=new int[n];
        Arrays.fill(pse,-1);
        int[] nse=new int[n];
        Arrays.fill(nse,n);
        Stack<Integer> st=new Stack<>();
        //next smallest element
        for(int i=0;i<n;i++){
            int curr=i;
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i]=st.peek();
            }
            st.push(curr);
        }
        st.clear();
        //previous smallest element
        for(int i=n-1;i>=0;i--){
            int curr=i;
            while(!st.isEmpty()&&nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i]=st.peek();
            }
            st.push(curr);
        }
        int maxarea=0;
        for(int i=0;i<n;i++){
            int width=nse[i]-pse[i]-1;
            int area=nums[i]*width;
            if(area>maxarea){
                maxarea=area;
            }
        }
        return maxarea;
    }
}