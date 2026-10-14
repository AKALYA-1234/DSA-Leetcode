class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>num*9){
            return "";
        }
        StringBuilder s=new StringBuilder();
        for(int i=1;i<=num;i++){
            int digit=Math.min(9,sum);
            s.append(digit);
            sum-=digit;
        }
        return s.toString();
    }
}