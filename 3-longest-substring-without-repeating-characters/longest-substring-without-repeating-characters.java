class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int left=0;
        int ans=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int right=0;right<n;right++){
            char curr=s.charAt(right);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            while(mp.get(curr)>1){
                char prev=s.charAt(left);
                mp.put(prev,mp.get(prev)-1);
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}