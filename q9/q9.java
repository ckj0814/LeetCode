package q9;

import java.util.*;

public class q9 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abab";
        String p = "ab";

        List<Integer> anagrams = solution.findAnagrams(s, p);
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            Integer key = p.charAt(i) - 'a';
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        int[] c = new int[26];
        int index = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i+p.length()-1>=s.length()){
                break;
            }
            for (int offset = 0; offset < p.length(); offset++) {
                index = s.charAt(i + offset) - 'a';
                if (!map.containsKey(index)) {
                    c = new int[26];
                    break;
                }
                c[index]++;
            }
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            int flag = 0;
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                Integer key = next.getKey();
                Integer value = next.getValue();
                if (c[key] != value) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                result.add(i);
            }
            c = new int[26];
        }

        return result;
    }
}
/*
438. 找到字符串中所有字母异位词
        给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

        异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。



        示例 1:

        输入: s = "cbaebabacd", p = "abc"
        输出: [0,6]
        解释:
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
        示例 2:

        输入: s = "abab", p = "ab"
        输出: [0,1,2]
        解释:
        起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
        起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
        起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。


        提示:

        1 <= s.length, p.length <= 3 * 104
        s 和 p 仅包含小写字母*/
