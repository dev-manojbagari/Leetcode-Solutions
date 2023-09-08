class Solution {
    class Interval{
        int start;
        int end;
        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    
    public List<Integer> partitionLabels(String s) {
        Map<Character, Interval> map = new HashMap<>();

	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (!map.containsKey(c)) {
		map.put(c, new Interval(i, i));
	    } else {
		Interval curInterval = map.get(c);
		curInterval.end = i;
	    }
	}

	List<Interval> intervals = new ArrayList<>();
	for (char key : map.keySet()) {
	    // if (map.get(key).end != -1) {
		intervals.add(map.get(key));
	    // }
	}
	intervals.sort((a, b) -> a.start - b.start);
	List<Interval> mergedIntervals = new ArrayList<>();

	mergedIntervals.add(intervals.get(0));

	for (int i = 1; i < intervals.size(); i++) {
	    Interval prev = mergedIntervals.get(mergedIntervals.size() - 1);
	    Interval curr = intervals.get(i);

	    if (prev.end > curr.start) {
		prev.end = Math.max(prev.end, curr.end);
	    } else {
		mergedIntervals.add(curr);
	    }
	}

	List<Integer> res = new ArrayList<>();

	for (Interval curInterval : mergedIntervals) {
	    res.add(curInterval.end - curInterval.start + 1);
	}

	return res;
    }
}