package bookOne.algorithmImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 */
public class Subject_38 {


    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        //把A的最顶上一个元素移动到B上，然后把A所有的元素移动到C上，然后B移动到C上
        hnt(A.size(),A,B,C);
    }

    private void hnt(int level,List<Integer> A, List<Integer> B, List<Integer> C) {
        if(level == 1) {
            //A只剩一个元素，移动到C
            C.add(A.get(A.size()-1));
            A.remove(A.size()-1);
        }else {
            hnt(level-1,A,C,B);
            C.add(A.get(A.size()-1));
            A.remove(A.size()-1);
            hnt(level-1,B,A,C);
        }
    }
}
