class Solution {
    public int mostFrequentEven(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int num:nums){
            if(num%2==0){
                mp.put(num,mp.getOrDefault(num,0)+1);
            }
        }
        if(mp.isEmpty()){
            return -1;
        }
        int max=0;
        int maxele=Integer.MIN_VALUE;
        for(int key:mp.keySet()){
            if(mp.get(key)>max||(mp.get(key)==max&&key<maxele)){
                max=mp.get(key);
                maxele=key;
            }
        }
        return maxele;
    }
}