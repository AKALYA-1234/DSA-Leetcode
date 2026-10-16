class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        HashMap<Character,Integer> mp2=new HashMap<>();
        for(int i=0;i<m;i++){
            mp2.put(t.charAt(i),mp2.getOrDefault(t.charAt(i),0)+1);
        }
        int left=0;
        int count=0;
        int startindex=-1;
        int min=Integer.MAX_VALUE;
        for(int right=0;right<n;right++){
            char curr=s.charAt(right);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
            if(mp2.containsKey(curr)){
                if(mp.get(curr)<=mp2.get(curr)){
                    count++;
                }
            }
            while(count==m){
                if(right-left+1<min){
                    min=right-left+1;
                    startindex=left;
                }
                min=Math.min(right-left+1,min);
                char prev=s.charAt(left);
                mp.put(prev,mp.get(prev)-1);
                if(mp2.containsKey(prev)){
                    if(mp.get(prev)<mp2.get(prev)){
                        count--;
                    }
                }
                left++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startindex,startindex+min);
    }
}