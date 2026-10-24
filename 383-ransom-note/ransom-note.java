class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n1=ransomNote.length();
        int n2=magazine.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<n2;i++){
            char curr=magazine.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        for(int i=0;i<n1;i++){
            char curr=ransomNote.charAt(i);
            if(!mp.containsKey(curr)){
                return false;
            }
            mp.put(curr,mp.get(curr)-1);
            if(mp.get(curr)==0){
                mp.remove(curr);
            }
        }
        return true;
    }
}