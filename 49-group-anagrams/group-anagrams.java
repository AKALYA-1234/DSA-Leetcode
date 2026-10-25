class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        HashMap<String,List<String>> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            String curr=strs[i];
            char[] ch=curr.toCharArray();
            Arrays.sort(ch);
            String s=new String(ch);
            if(!mp.containsKey(s)){
                mp.put(s,new ArrayList<>());
            }
            mp.get(s).add(curr);
        }
        List<List<String>> ans=new ArrayList<>();
        for(List<String> str:mp.values()){
            ans.add(str);
        }
        return ans;
    }
}