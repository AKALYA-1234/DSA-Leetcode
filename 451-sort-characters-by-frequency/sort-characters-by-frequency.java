class Solution {
    public String frequencySort(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq=new PriorityQueue<>(
            (a,b)->mp.get(b)-mp.get(a)
        );
        pq.addAll(mp.keySet());
        StringBuilder ans=new StringBuilder();
        while(!pq.isEmpty()){
            char ch=pq.poll();
            for(int i=0;i<mp.get(ch);i++){
                ans.append(ch);
            }
        }
        return new String(ans);
    }
}