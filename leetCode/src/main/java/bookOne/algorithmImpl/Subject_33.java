package bookOne.algorithmImpl;

/**
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
 * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 动态规划，制表法，空间优化
 */
public class Subject_33 {

    public int waysToStep(int n) {
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        if(n==3) {
            return 4;
        }
        long one=1,two=2,three=4;
        for(int i=4; i<=n; i++){
            long temp_two = two,temp_three = three;
            three = (one + two + three)%1000000007;
            two = temp_three;
            one = temp_two;
        }
        return (int)three;
    }
}
