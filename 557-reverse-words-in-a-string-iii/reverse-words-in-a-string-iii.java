class Solution {
    public String reverseWords(String s) {
        String[] str=s.split("\\s+");
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<str.length;i++){
            String curr=str[i];
            StringBuilder sb=new StringBuilder();
            for(int j=curr.length()-1;j>=0;j--){
                sb.append(curr.charAt(j));
            }
            ans.append(sb);
            if(i!=str.length-1){
                ans.append(" ");
            }
        }
        return new String(ans);
    }
}