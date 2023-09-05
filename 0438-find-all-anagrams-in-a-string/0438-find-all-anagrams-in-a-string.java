class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> output = new ArrayList<>();

        if (s.length() < p.length()) {
            return output;
        }

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        int i = p.length();
        while (i < s.length()) {
            if (isAnagram(pCount, sCount)) {
                output.add(i - p.length());
            }
            sCount[s.charAt(i - p.length()) - 'a']--;
            sCount[s.charAt(i) - 'a']++;
            i++;
        }
        if (isAnagram(pCount, sCount)) {
            output.add(i - p.length());
        }

        return output;
    }

    private boolean isAnagram(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }
}
