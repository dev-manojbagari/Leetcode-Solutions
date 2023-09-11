class Solution {
    static class Pair {
        int ones;
        int zeros;

        public Pair(int zeros, int ones) {
            this.zeros = zeros;
            this.ones = ones;
        }
    }
    int[][][] dp;

    int findMaxForm(String[] strs, int m, int n) {
        dp = new int[strs.length + 1][m+1][n+1];

        // initialize the 3-D array
        Arrays.stream(dp)
                .flatMap(Arrays::stream)
                .forEach(col -> Arrays.fill(col, -1));

        List<Pair> pairs = new ArrayList<>();
        for (String str: strs) {
            int indx = 0, ones = 0, zeros = 0;
            while (indx < str.length()) {
                if (str.charAt(indx) == '1') {
                    ones++;
                } else {
                    zeros++;
                }
                indx++;
            }
            Pair p = new Pair(zeros, ones);
            pairs.add(p);
        }

        return sub(pairs, 0, m, n);
    }

    int sub(List<Pair> pairs, int index, int m, int n) {

        // base condition
        if (index == pairs.size() || (m == 0 && n == 0)) {
            return 0;
        }

        // dp[index][m][n] is already set, return the value
        if (dp[index][m][n] != -1) {
            return dp[index][m][n];
        }

        // for the index, if the number of ones or zeros are more than m or n - ignore the current pair/string and move to next string
        int mZeros = pairs.get(index).zeros;
        int nOnes = pairs.get(index).ones;
        if (mZeros > m || nOnes > n ) {
            dp[index][m][n] = sub(pairs, index + 1, m, n);
            return dp[index][m][n];
        }

        // determine whether to include or exclude the current string as part of the largest subset
        int include = 1 + sub(pairs, index + 1, m - mZeros, n - nOnes);
        int exclude = sub(pairs, index + 1, m, n);

        dp[index][m][n] = Math.max(include, exclude);

        return dp[index][m][n];
    }
}