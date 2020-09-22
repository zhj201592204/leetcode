package bookOne.algorithmImpl;
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

/**
 * 可以看成将字符串分为两串，拼接成新的字符串
 *
 * 本质上，我们是在寻找是否有一种方式可以把第一个字符串分成两部分，即x和y，如此一来，第一个字符串就是xy，第二个字符串就是yx。
 * 例如，x = wat，y = erbottle。那么，第一个字符串xy = waterbottle，第二个字符串yx = erbottlewat。
 *
 * yx + yx = yxyx = y + xy + x
 */
public class Subject_9 {

    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        String S = s2 + s2;
        return S.contains(s1);
    }
}
