class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n=words.length;
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            int currlen=words[i].length();
            for(int j=0;j<currlen;j++){
                if(words[i].charAt(j)==x){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}