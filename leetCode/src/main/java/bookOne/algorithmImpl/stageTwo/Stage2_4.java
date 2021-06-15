package bookOne.algorithmImpl.stageTwo;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 示例：
 * 输入: [1]
 * 输出: [2,3]
 */
public class Stage2_4 {

    public int[] missingTwo(int[] nums) {
        int sum=0,square_sum=0,i=0;
        for(i=0; i<nums.length; i++) {
            sum += (i+1);
            square_sum += (i+1)*(i+1);
            sum -= nums[i];
            square_sum -= nums[i]*nums[i];
        }
        sum += i+1;
        square_sum += (i+1)*(i+1);
        ++i;
        sum += i+1;
        square_sum += (i+1)*(i+1);
        //sum是二者之和，square_sum是二者平方的和
        double tempy = Math.sqrt(square_sum * 2 - sum * sum);
        i = new Double(tempy).intValue();
        return new int[]{(sum+i)/2,(sum-i)/2};
    }
}
