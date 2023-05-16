package q4;

import java.util.Arrays;

public class q4 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
//        int[] nums = {0,1,0,3,12]};
        solution.moveZeroes(nums);

    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        Integer zeroIndex = -1;
        Integer noZeroIndex = 0;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[noZeroIndex] = nums[i];
                noZeroIndex ++;
            }else {
//                newNums[nums.length+zeroIndex] = nums[i];
//                zeroIndex --;
            }
        }
        for (int i = noZeroIndex; i < nums.length; i++){
            nums[i] = 0;
        }
//        nums = newNums;
        System.out.println(Arrays.toString(nums));
//        System.out.print('[');
//        for(int i=0 ;i<newNums.length-1;i++){
//            System.out.print(newNums[i]);
//            System.out.print(',');
//        }
//        System.out.print(newNums[newNums.length-1]);
//        System.out.print(']');
//        System.out.println(Arrays.toString(newNums));
    }
}

/*283. 移动零
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

        请注意 ，必须在不复制数组的情况下原地对数组进行操作。



        示例 1:

        输入: nums = [0,1,0,3,12]
        输出: [1,3,12,0,0]
        示例 2:

        输入: nums = [0]
        输出: [0]


        提示:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1


        进阶：你能尽量减少完成的操作次数吗？*/
