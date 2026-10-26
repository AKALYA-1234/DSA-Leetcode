class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m=s.length();
        int n=p.length();
        List<Integer> ans=new ArrayList<>();
        if(m<n){
            return ans;
        }
        HashMap<Character,Integer> original=new HashMap<>();
        HashMap<Character,Integer> curr=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=p.charAt(i);
            original.put(ch,original.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            curr.put(ch,curr.getOrDefault(ch,0)+1);
        }
        if(original.equals(curr)){
            ans.add(0);
        }
        int left=0;
        for(int right=n;right<m;right++){
            char ch=s.charAt(right);
            curr.put(ch,curr.getOrDefault(ch,0)+1);
            char prev=s.charAt(left);
            curr.put(prev,curr.get(prev)-1);
            if(curr.get(prev)==0){
                curr.remove(prev);
            }
            left++;
            if(curr.equals(original)){
                ans.add(left);
            }
        }
        return ans;
    }
}