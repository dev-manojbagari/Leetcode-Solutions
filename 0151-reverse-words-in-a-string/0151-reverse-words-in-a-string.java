class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        
        // Remove leading and trailing white spaces
        int start = 0;
        while (start < n && s.charAt(start) == ' ') {
            start++;
        }
        
        int end = n - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        
        // Reverse each word and append to the result
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            
            int j = i;
            
            // Find the start index of the current word
            while (j >= start && s.charAt(j) != ' ') {
                j--;
            }
            
            // Append the reversed word to the result
            for (int k = j + 1; k <= i; k++) {
                sb.append(s.charAt(k));
            }
            
			// Append a space between words except for the last word
			if (j >= start) {
				sb.append(' ');
			}
			
			i = j + 1; // Move to the next word
		}
		
		return sb.toString();
    }
}
