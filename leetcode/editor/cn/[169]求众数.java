//给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在众数。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int res = 0,max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
//                map.put(num, map.get(num)+1);
                int count = map.get(num);
                map.put(num,++count);
            } else {
                map.put(num,1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        int len = nums.length;
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            int key = (int)entry.getKey();
            int val = (int)entry.getValue();
            if (val >= max) {
                max = val;
                res = key;
            }
        }
        return res;

        /*Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();*/

    }
}
//leetcode submit region end(Prohibit modification and deletion)
