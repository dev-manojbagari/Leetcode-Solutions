class Solution {
    public String reverseWords(String s) {
       StringBuilder sb = new StringBuilder();
	   Stack<String> stack = new Stack<>();

	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (Character.isDigit(c) || Character.isAlphabetic(c)) {
		sb.append(c);
		if (i == s.length() - 1)
		    stack.push(sb.toString());
	    } else if (sb.length() != 0) {
		stack.push(sb.toString());
		sb = new StringBuilder();
	    }
	}

	System.out.println(stack);

	StringBuilder res = new StringBuilder();
	while (!stack.isEmpty()) {
	    res.append(stack.pop());
	    if (stack.isEmpty())
		break;
	    res.append(" ");
	}

	return res.toString();
    }
}