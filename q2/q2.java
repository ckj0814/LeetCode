package q2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class q2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"cab","pug","pei","nay","ron","rae","ems","ida","mes"};
        List<List<String>>[] lists = solution.groupAnagrams(strs);
        System.out.println();
    }
}


class Solution {
    public List<List<String>>[] groupAnagrams(String[] strs) {
        Integer[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap map = new HashMap<Integer,HashMap>();
        for (int i = 0; i < strs.length; i++) {
            HashMap map2 = new HashMap<Integer, List<String>>();
            Integer sum = 1;
            for (int i1 = 0; i1 < strs[i].length(); i1++) {
                Integer index = Integer.valueOf(strs[i].charAt(i1)-'a');
                Integer value = prime[index];
                sum = sum*value;
            }
            if (!map.containsKey(strs[i].length())){
                List<String> v = new ArrayList<>();
                v.add(strs[i]);
                map2.put(sum,v);
                map.put(strs[i].length(),map2);
            }
            else {
                map2 = (HashMap) map.get(strs[i].length());
                if (!map2.containsKey(sum)){
                    List<String> l = new ArrayList<>();
                    l.add(strs[i]);
                    map2.put(sum,l);
                }else {
                    List<String> l= (List<String>) map2.get(sum);
                    l.add(strs[i]);
                }

                map.put(strs[i].length(),map2);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Object v: map.values()){
            for (Object v2 :((HashMap) v).values()){
                result.add((List<String>)v2);
            }
        }
          List<List<String>>[] lists = new List[1];
          lists[0] = result;
          return lists;
//        return result;
    }
}

/*
49. 字母异位词分组
        给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

        字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。



        示例 1:

        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        示例 2:

        输入: strs = [""]
        输出: [[""]]
        示例 3:

        输入: strs = ["a"]
        输出: [["a"]]


        提示：

        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
        strs[i] 仅包含小写字母*/
