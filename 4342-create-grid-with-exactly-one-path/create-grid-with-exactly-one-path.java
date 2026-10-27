class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans=new String[m];
        for(int i=0;i<m;i++){
            char[] ch=new char[n];
            for(int j=0;j<n;j++){
                ch[j]='#';
            }
            if(i==0){
                for(int j=0;j<n;j++){
                    ch[j]='.';
                }
            }
            if(i>0){
                ch[n-1]='.';
            }
            ans[i]=new String(ch);
        }
        return ans;
    }
}