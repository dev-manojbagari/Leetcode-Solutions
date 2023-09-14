class Solution {

    private class Pair {
        TreeNode node;
        int hd;
        int level;

        Pair(TreeNode node, int hd, int level) {
            this.node = node;
            this.hd = hd;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, List<Pair>> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        q.add(new Pair(root, 0, 0));
        int minHd = Integer.MAX_VALUE, maxHd = Integer.MIN_VALUE;
        int curLevel = -1;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            curLevel++;
            for (int i = 0; i < levelSize; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int hd = p.hd;

                minHd = Math.min(minHd, hd);
                maxHd = Math.max(maxHd, hd);

                if (map.containsKey(hd)) map.get(hd).add(p); else {
                    List<Pair> l = new ArrayList<>();
                    l.add(p);
                    map.put(hd, l);
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, hd - 1, curLevel));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, hd + 1, curLevel));
                }
            }
        }

        for (int i = minHd; i <= maxHd; i++) {
            Comparator<Pair> c = (a, b) -> {
                if (a.level < b.level) {
                    return -1;
                } else if (a.level > b.level) {
                    return 1;
                } else {
                    return Integer.compare(a.node.val, b.node.val);
                }
            };
            List<Pair> x = map.get(i);
            x.sort(c);
            List<Integer> tempList = new ArrayList<Integer>();
            x.forEach(h -> tempList.add(h.node.val));
            list.add(tempList);
        }

        return list;
    }
}
