import java.util.HashMap;
import java.util.Map;


public class FindingAbsoluteDiff {
	public int findAD(int[] nums, int k) {
		if (nums.length <= 1 || k < 0) {
			return 0;// if nums is empty or just one element,or k is less than
						// 0, just return 0 pairs
		} else {
			Map<Integer, Integer> map = new HashMap<>();
			int count = 0;
			for (int i : nums) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}

			for (Map.Entry<Integer, Integer> ele : map.entrySet()) {
				if (k == 0) {
					if (ele.getValue() >= 2) {
						count++;
					}
				} else {
					if (map.containsKey(ele.getKey() + k)) {
						count++;
					}
				}
			}
			map.clear();
			System.out.println((map.isEmpty() ? "map is empty" : "map is not empty"));
			return count;
		}
	}
}

