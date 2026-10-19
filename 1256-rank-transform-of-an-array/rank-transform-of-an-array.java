class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums=arr.clone();
        Arrays.sort(nums);
        int n=arr.length;
        HashMap<Integer,Integer> mp=new HashMap<>();
        int rank=1;
        for(int num:nums){
            if(!mp.containsKey(num)){
                mp.put(num,rank++);
            }
        }
        for(int i=0;i<n;i++){
            arr[i]=mp.get(arr[i]);
        }
        return arr;
    }
}