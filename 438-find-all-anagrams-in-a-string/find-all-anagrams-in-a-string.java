class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int m=p.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> mp2=new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        if(m>n){
            return ans;
        }
        for(int i=0;i<m;i++){
            char curr=p.charAt(i);
            mp2.put(curr,mp2.getOrDefault(curr,0)+1);
        }
        for(int i=0;i<m;i++){
            char curr=s.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        if(mp.equals(mp2)){
            ans.add(0);
        }
        int left=0;
        for(int i=m;i<n;i++){
            char curr=s.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            char prev=s.charAt(left);
            mp.put(prev,mp.get(prev)-1);
            if(mp.get(prev)==0){
                mp.remove(prev);
            }
            left++;
            if(mp.equals(mp2)){
                ans.add(left);
            }
        }
        return ans;
    }
}