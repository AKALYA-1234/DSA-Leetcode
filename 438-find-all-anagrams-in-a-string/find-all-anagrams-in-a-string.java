class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int a=s.length();
        int b=p.length();
        if(b>a){
            return list;
        }
        HashMap<Character,Integer> mp1=new HashMap<>();
        HashMap<Character,Integer> mp2=new HashMap<>();
        for(int i=0;i<b;i++){
            char ch=p.charAt(i);
            mp1.put(ch,mp1.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<b;i++){
            char ch2=s.charAt(i);
            mp2.put(ch2,mp2.getOrDefault(ch2,0)+1);
        }
        if(mp1.equals(mp2)){
            list.add(0);
        }
        for(int i=b;i<a;i++){
            char curr=s.charAt(i);
            mp2.put(curr,mp2.getOrDefault(curr,0)+1);
            char prev=s.charAt(i-b);
            mp2.put(prev,mp2.get(prev)-1);
            if(mp2.get(prev)==0){
                mp2.remove(prev);
            }
            if(mp1.equals(mp2)){
                list.add(i-b+1);
            }
        }
        return list;
    }
}