import java.util.Arrays;
import java.util.HashMap;

public class DongArray_1_twoSum {


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15,-2};
        int target = 9;
        System.out.println(Arrays.toString(nums));
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            map.put(temp, i);
            if (map.containsKey(target-nums[i])) {
                System.out.println(target-nums[i]+" "+nums[i]);
            }
        }
    }

}
