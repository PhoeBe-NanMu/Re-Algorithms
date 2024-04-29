import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DongArray_2_threeSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15,-2,0,-4,6,8};
        int target = 9;

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // 剩余两个的目标和
            int targetSum = target - nums[i];
            int l = i+ 1;
            int r = nums.length - 1;
            // 排序之后如果 nums[i]>target 那么nums[i++]>target，那么 targetTreeSum > target
            if(nums[i]>target) break;
            // 正常情况下的计算过程。第一个加数不需要后移动。i == 0表示此时是第一个，必须加上。原因如下：
            // 因为nums[i]!=nums[i-1]表示从前往后两个数相同这不考虑nums[i](避免使用nums[i+1]导致数组越界)，但这样会导致nums[0]!=nums[-1]返回false。
            // 所要加上 i == 0 || ，当i == 0时，不会判断 nums[-1]
            if(i == 0 || nums[i]!=nums[i-1]){
                while (l < r) {
                    if(nums[l]+nums[r]==targetSum){
                        list.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    } else {
                        if (nums[l]+nums[r]<targetSum) {
                            l++;
                        }else{
                            r--;
                        }
                    }
                }
            }
        }
        System.out.println(list);
    }
}
