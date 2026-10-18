class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m){
            return false;
        }
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> mp2=new HashMap<>();
        for(int i=0;i<n;i++){
            mp2.put(s1.charAt(i),mp2.getOrDefault(s1.charAt(i),0)+1);
        }
        for(int i=0;i<n;i++){
            mp.put(s2.charAt(i),mp.getOrDefault(s2.charAt(i),0)+1);
        }
        if(mp2.equals(mp)){
            return true;
        }
        int left=0;
        for(int i=n;i<m;i++){
            char curr=s2.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            char prev=s2.charAt(left);
            mp.put(prev,mp.get(prev)-1);
            if(mp.get(prev)==0){
                mp.remove(prev);
            }
            left++;
            if(mp2.equals(mp)){
                return true;
            }
        }
        return false;
    }
}