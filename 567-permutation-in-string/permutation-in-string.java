class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int a=s1.length();
        int b=s2.length();
        if(a>b){
            return false;
        }
        HashMap<Character,Integer> mp1=new HashMap<>();
        HashMap<Character,Integer> mp2=new HashMap<>();
        for(int i=0;i<a;i++){
            char ch=s1.charAt(i);
            mp1.put(ch,mp1.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<a;i++){
            char ch2=s2.charAt(i);
            mp2.put(ch2,mp2.getOrDefault(ch2,0)+1);
        }
        if(mp1.equals(mp2)){
            return true;
        }
        for(int i=a;i<b;i++){
            char curr=s2.charAt(i);
            mp2.put(curr,mp2.getOrDefault(curr,0)+1);
            char prev=s2.charAt(i-a);
            mp2.put(prev,mp2.get(prev)-1);
            if(mp2.get(prev)==0){
                mp2.remove(prev);
            }
            if(mp1.equals(mp2)){
                return true;
            }
        }
        return false;
    }
}