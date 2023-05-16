package q3;


import java.util.*;
import java.util.stream.Collectors;

public class q3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int i = solution.longestConsecutive(nums);
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Integer LEN = nums.length;
        int maxLen = 0;
        int maxIndex = 0;
        List<Integer> maxList = new ArrayList<>();
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (Integer s :set) {
            if(!map.containsKey(s)){
                Integer key = s;
                List<Integer> value = new ArrayList<>();


                if(map.containsKey(key-1) && map.containsKey(key+1)){

                }else if(map.containsKey(key-1) && !map.containsKey(key+1)){
                    List<Integer> v = map.get(key-1);
                    if (v.size()==0){

                    }
                }if(!map.containsKey(key-1) && map.containsKey(key+1)){

                }else {
                    map.put(key,value);
                }

                for (Integer k: map.keySet()) {
                    if (map.get(k).size() ==0){
                        if(Math.abs(key-k)==1){
                            if(key-k>0){
                                value.add(k);
                                value.add(key);
                            }
                            else {
                                value.add(key);
                                value.add(k);
                            }
                        }
                    }else {
//                        if(key)
                    }
                    if (k<key+LEN && k>key-LEN){
                        value.add(k);
                    }
                }
                if (value.size()+1>maxLen){
                    maxLen = value.size()+1;
//                    maxIndex = i;
                }
                map.put(key,value);
            }
        }
        List<Integer> integers = map.get(nums[maxIndex]);
//        for (Integer i : integers)

        return maxLen;
    }
}

/*
128. 最长连续序列
        给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

        请你设计并实现时间复杂度为 O(n) 的算法解决此问题。



        示例 1：

        输入：nums = [100,4,200,1,3,2]
        输出：4
        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
        示例 2：

        输入：nums = [0,3,7,2,5,8,4,6,0,1]
        输出：9


        提示：

        0 <= nums.length <= 105
        -109 <= nums[i] <= 109

 */