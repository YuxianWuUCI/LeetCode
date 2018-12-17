/*
 这道题我直接用的solution，因为我想给list排序但不会用自带的排序算法
 Solution给了两种算法，这是简单的那种
 时间复杂度:O(nlogn)
 空间复杂度:O(1 or n)取决于排序时要不要创建一个copy
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
	//这就是java里实现比较重载的方法，小于返回-1，等于返回0，大于返回1
	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval a, Interval b) {
			//连用两个三元操作符的想法很棒
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new IntervalComparator());
		
		LinkedList<Interval> merged = new LinkedList<Interval>();
		for (Interval interval : intervals) {
				// if the list of merged intervals is empty or if the current
				// interval does not overlap with the previous, simply append it.
			//细心考虑到empty的情况
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			}
				// otherwise, there is overlap, so we merge the current and previous
				// intervals.
			else {
				//两个interval重叠，end要取其中更远的那个
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}
		
		return merged;
	}
}
