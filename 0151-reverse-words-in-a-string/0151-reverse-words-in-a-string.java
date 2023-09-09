class Solution {
    public String reverseWords(String s) {
  StringBuilder sb = new StringBuilder();
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (Character.isDigit(c) || Character.isAlphabetic(c))
		sb.append(c);
	    else {
		if (sb.length() > 0 &&( Character.isDigit(sb.charAt(sb.length() - 1))
			|| Character.isAlphabetic(sb.charAt(sb.length() - 1))))
		    sb.append(" ");
	    }
	}

	String words[] = sb.toString().split(" ");
	Stack<String> stack = new Stack<>();
	for (String word : words) {
	    stack.push(word);
	}
	sb = new StringBuilder();
	while (!stack.isEmpty()) {
	    String str = stack.pop();
	    if (str.length() > 0 && (Character.isDigit(str.charAt(0)) || Character.isAlphabetic(str.charAt(0))))
		sb.append(str);
	    if (!stack.isEmpty())
		sb.append(" ");
	}

	return sb.toString();        
        
        
    }
}