class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        boolean foundB=false;
        for(int i=0;i<n;i++){
            char curr=s.charAt(i);
            if(curr=='b'){
                foundB=true;
            }
            if(curr=='a'&&foundB){
                return false;
            }
        }
        return true;
    }
}