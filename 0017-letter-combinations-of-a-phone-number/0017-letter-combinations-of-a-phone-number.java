class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0)
            return list;
        String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        letterCombinations(0, digits, letters, list, "");
        return list;
    }

    void letterCombinations(int index, String digits, String[] letters, List<String> list, String str) {
        if (index == digits.length()) {
            list.add(str);
            return;
        }

        int num = digits.charAt(index) - '0';
        for (char ch : letters[num].toCharArray()) {
            letterCombinations(index + 1, digits, letters, list, str + ch);
        }
    }
}
