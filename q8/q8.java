package q8;

public class q8 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "dvdf";
        int i = solution.lengthOfLongestSubstring(s);
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] c = new int[95];
        int maxLengh = 0;
        int index = 0;
        int tempLengh = 0;
//        if (s.length() == 1){
//            return 1;
//        }
//        int iTemp = 0;
        for (int i = 0; i < s.length(); ) {
            index = s.charAt(i) - ' ';
            if (c[index] == 0) {
                c[index] = 1;
                tempLengh ++;
                i++;
                if(i==s.length()){
                    if (tempLengh > maxLengh) {
                        maxLengh = tempLengh;
                    }
                }
            }else {
                if (tempLengh > maxLengh) {
                    maxLengh = tempLengh;
                }
                i = i - tempLengh + 1;
                c = new int[95];
                tempLengh = 0;
            }
        }
        System.out.println(maxLengh);
        return maxLengh;
    }
}

/*

3. 无重复字符的最长子串
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



        示例 1:

        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


        提示：

        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成*/
