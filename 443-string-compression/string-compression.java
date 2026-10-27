class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int count=1;
        int k=0;
        for(int i=1;i<n;i++){
            if(chars[i]==chars[i-1]){
                count++;
            }
            else{
                chars[k++]=chars[i-1];
                if(count>1){
                    String temp=String.valueOf(count);
                    for(int j=0;j<temp.length();j++){
                        chars[k++]=temp.charAt(j);
                    }
                }
                count=1;
            }
        }   
        chars[k++]=chars[n-1];
        if(count>1){
            String temp=String.valueOf(count);
            for(int i=0;i<temp.length();i++){
                chars[k++]=temp.charAt(i);
            }
        }
        return k;
    }
}