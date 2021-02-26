package bookOne.algorithmImpl;

/**
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 */
public class Subject_54 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        if(row < 0) {
            return false;
        }
        int col = matrix[0].length;
        int j= 0;
        while(row >=0 && j < col) {
            if(target < matrix[row][j]) {
                --row;
            }else if(target > matrix[row][j]) {
                ++j;
            }else if(target == matrix[row][j]) {
                return true;
            }
        }
        return false;
    }
}
