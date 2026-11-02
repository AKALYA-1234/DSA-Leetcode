class Solution {
    public int numberOfSpecialChars(String word) {
        int n=word.length();
        int count=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            char curr=word.charAt(i);
            if(curr>='A'&&curr<='Z'){
                mp.put((char)(curr+32),1);
            }
        }
        for(int i=0;i<n;i++){
            char curr=word.charAt(i);
            if(mp.containsKey(curr)){
                count++;
                mp.remove(curr);
            }
        }
        return count;
    }
}