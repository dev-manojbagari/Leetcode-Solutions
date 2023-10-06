class Solution {

    public List<String> maxNumOfSubstrings(String s) {
        List<String> res = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new int[] { i, i }); else map.get(s.charAt(i))[1] = i;
        }

        int prevEnd = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int start = map.get(c)[0];
            if (start == i) {
                int curEnd = getEnd(s, start, map.get(c)[1], map);
                if (curEnd != -1) {
                    if (curEnd <= prevEnd) {
                        res.set(res.size() - 1, s.substring(start, curEnd + 1));
                    } else {
                        res.add(s.substring(start, curEnd + 1));
                    }
                    prevEnd = curEnd;
                }
            }
        }

        return res;
    }

    private int getEnd(String s, int start, int end, Map<Character, int[]> map) {
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (map.get(c)[0] < start) return -1;

            end = Math.max(end, map.get(c)[1]);
        }
        return end;
    }
}
