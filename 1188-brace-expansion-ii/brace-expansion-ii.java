class Solution {

    int index = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> result = parseExpression(expression);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    Set<String> parseExpression(String s) {

        Set<String> result = parseTerm(s);

        while (index < s.length() && s.charAt(index) == ',') {
            index++; 

            Set<String> next = parseTerm(s);
            result.addAll(next);
        }

        return result;
    }

    Set<String> parseTerm(String s) {

        Set<String> result = new HashSet<>();
        result.add("");

        while (index < s.length()
                && s.charAt(index) != ','
                && s.charAt(index) != '}') {

            Set<String> next = parseFactor(s);

            Set<String> temp = new HashSet<>();

            for (String a : result) {
                for (String b : next) {
                    temp.add(a + b);
                }
            }

            result = temp;
        }

        return result;
    }

    Set<String> parseFactor(String s) {

        Set<String> result = new HashSet<>();

        if (s.charAt(index) == '{') {

            index++; 

            result = parseExpression(s);

            index++; 

        } else {

            result.add(String.valueOf(s.charAt(index)));
            index++;
        }

        return result;
    }
}