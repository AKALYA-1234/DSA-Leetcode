class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            mp.put(curr,mp.getOrDefault(curr,0)+1);
        }
        int flag=0;
        int total=0;
        for(int value:mp.values()){
            if(value%2==0){
                total+=value;
            }
            else{
                total+=value-1;
                flag=1;
            }
        }
        if(flag==1){
            return total+1;
        }
        return total;
    }
}