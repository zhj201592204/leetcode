package BookOne;
//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
public class Subject_1 {

    public boolean isUnique(String astr) {
        for(int i=0; i<astr.length()-1; i++) {
            if(astr.substring(i+1).contains(astr.substring(i,i+1))) {
                return false;
            }
        }
        return true;
    }
}
