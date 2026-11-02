class Solution {
    public String greatestLetter(String s) {
        int n=s.length();
        char max='\0';
        int flag=0;
        HashMap<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                mp.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                if(mp.containsKey((char)(s.charAt(i)+32))){
                    if(s.charAt(i)>max){
                        max=s.charAt(i);
                    }
                    flag=1;
                }
            }
        }
        if(flag==0){
            return "";
        }
        return String.valueOf(max);
    }
}