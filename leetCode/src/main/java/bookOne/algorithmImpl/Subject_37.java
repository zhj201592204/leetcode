package bookOne.algorithmImpl;

/**
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 */
public class Subject_37 {

    public int multiply(int A, int B) {
        if(A<B) {
            if(A <=1) {
                return B;
            }
            return A%2==0? multiply(A/2,B) + multiply(A/2,B) : multiply(A/2,B) + multiply(A/2+1,B);
        }
        if(B <= 1) {
            return A;
        }
        return B%2==0? multiply(A,B/2) + multiply(A,B/2) : multiply(A,B/2) + multiply(A,B/2+1);
    }
}
