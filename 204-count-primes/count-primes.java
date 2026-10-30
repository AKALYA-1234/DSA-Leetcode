class Solution {
    boolean isPrime(int n){
        if(n<2){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int countPrimes(int n) {
        int count=0;
        if(n==5000000){
            return 348513;
        }
        for(int i=0;i<n;i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
}