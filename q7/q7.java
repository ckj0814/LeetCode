package q7;

import java.util.TreeMap;

public class q7 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {4,2,0,3,2,5};
        int trap = solution.trap(height);

    }
}

class Solution {
    public int trap(int[] height) {
        int maxHeightIndex = 0;
        int maxHeight = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i]>maxHeight){
                maxHeight = height[i];
                maxHeightIndex = i;
            }
        }
        int sumLeft = 0;
        int sumRight = 0;
        int left = maxHeightIndex;
        if (left !=  height.length -1){
            while (true) {//向右
                int maxHeightTemp =0;
                int maxHeightIndexTemp = 0;
                for (int rightTemp = left + 1; rightTemp < height.length; rightTemp++) {
                    if (height[rightTemp]>=maxHeightTemp){
                        maxHeightTemp = height[rightTemp];
                        maxHeightIndexTemp = rightTemp;
                    }
                }
                sumRight = sumRight + height[maxHeightIndexTemp]*(maxHeightIndexTemp-left-1);
                for(int i = left + 1; i < maxHeightIndexTemp; i++){
                    sumRight = sumRight - height[i];
                }
                left = maxHeightIndexTemp;
                if (left == height.length-1){
                    break;
                }

            }
        }

        int right = maxHeightIndex;
        if (right!=0){
            while (true) {//向左
                int maxHeightTemp =0;
                int maxHeightIndexTemp = 0;
                for (int leftTemp = right - 1; leftTemp > -1 ; leftTemp--) {
                    if (height[leftTemp]>=maxHeightTemp){
                        maxHeightTemp = height[leftTemp];
                        maxHeightIndexTemp = leftTemp;
                    }
                }
                sumLeft = sumLeft + height[maxHeightIndexTemp]*(right-maxHeightIndexTemp-1);
                for(int i = right - 1; i > maxHeightIndexTemp; i--){
                    sumLeft = sumLeft - height[i];
                }
                right = maxHeightIndexTemp;
                if (right == 0){
                    break;
                }
            }
        }


        int sum = sumRight + sumLeft;
        System.out.println(sum);
        return 0;
    }
}

/*
42. 接雨水
        给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

        示例 1：

        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        输出：6
        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
        示例 2：

        输入：height = [4,2,0,3,2,5]
        输出：9


        提示：

        n == height.length
        1 <= n <= 2 * 104
        0 <= height[i] <= 105
        */
