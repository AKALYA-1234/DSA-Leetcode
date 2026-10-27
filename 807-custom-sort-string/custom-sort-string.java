class Solution {
    public String customSortString(String order, String s) {
        int m=order.length();
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s.charAt(j)==order.charAt(i)){
                    sb.append(order.charAt(i));
                }
            }
        }
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(order.indexOf(ch)==-1){
                sb.append(ch);  
            }
        }
        return new String(sb);
    }
}