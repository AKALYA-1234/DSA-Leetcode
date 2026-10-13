class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<suits.length;i++){
            set.add(suits[i]);
        }
        if(set.size()==1){
            return "Flush";
        }
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<ranks.length;i++){
            mp.put(ranks[i],mp.getOrDefault(ranks[i],0)+1);
        }
        int pair=0;
        for(int i:mp.keySet()){
            if(mp.get(i)>=3){
                return "Three of a Kind";
            }
            else if(mp.get(i)==2){
                pair=1;
            }
        }
        if(pair==1){
            return "Pair";
        }
        return "High Card";
    }
}