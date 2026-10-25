class Solution {
    public boolean isAnagram(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(n!=m){
            return false;
        }
        HashMap<Character,Integer> mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            if(!mp.containsKey(t.charAt(i))){
                return false;
            }
            mp.put(t.charAt(i),mp.get(t.charAt(i))-1);
            if(mp.get(t.charAt(i))==0){
                mp.remove(t.charAt(i));
            }
        }
        return true;
    }
}