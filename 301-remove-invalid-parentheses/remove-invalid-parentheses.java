class Solution {

    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String current = queue.poll();
                if (isValid(current)) {
                    result.add(current);
                }
                if (!result.isEmpty()) {
                    continue;
                }
                for (int i = 0; i < current.length(); i++) {
                    char c = current.charAt(i);
                    if (c != '(' && c != ')') {
                        continue;
                    }
                    String next =
                        current.substring(0, i) +
                        current.substring(i + 1);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            if (!result.isEmpty()) {
                return result;
            }
        }
        return result;
    }
    private boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            }
            else if (c == ')') {
                balance--;

                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }
}