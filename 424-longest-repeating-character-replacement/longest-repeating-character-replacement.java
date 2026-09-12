class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int left=0;
        int ans=0;
        int maxfreq=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int right=0;right<n;right++){
            char curr=s.charAt(right);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            maxfreq=Math.max(maxfreq,mp.get(curr));
            while((right-left+1)-maxfreq>k){
                char prev=s.charAt(left);
                mp.put(prev,mp.get(prev)-1);
                if(mp.get(prev)==0){
                    mp.remove(prev);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}