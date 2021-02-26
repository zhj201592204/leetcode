package bookOne.algorithmImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。
 * 有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。
 * 给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。
 * 设计一个算法打印出每个真实名字的实际频率。
 * 注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * 在结果列表中，选择 字典序最小 的名字作为真实名字。
 *
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
 * synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 *
 */
public class Subject_67 {

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String,Integer> data = new HashMap<>();//名字频率
        Map<String,String> nameMerge = new HashMap<>();//名字查并集
        for(String name : names) {
            String[] nameCount = name.split("\\(");
            String count = nameCount[1].substring(0,nameCount[1].length()-1);
            data.put(nameCount[0],Integer.parseInt(count));
        }
        for(String s : synonyms) {
            String[] nameArr = s.split(",");
            String name1 = nameArr[0].substring(1);
            String name2 = nameArr[1].substring(0,nameArr[1].length()-1);
            while(nameMerge.containsKey(name1)) {
                name1 = nameMerge.get(name1);//找name1的祖宗
            }
            while(nameMerge.containsKey(name2)) {
                name2 = nameMerge.get(name2);//找name2的祖宗
            }
            if(!(name1.equals(name2))) {//祖宗不同则合并
                int allCount = data.getOrDefault(name1,0) + data.getOrDefault(name2,0);
                String tName = name2.compareTo(name1) < 0 ? name2 : name1;//真名，字母大的阿斯克码值小
                String fName = name2.compareTo(name1) > 0 ? name2 : name1;//小名
                nameMerge.put(fName,tName);//大名是小名的祖宗
                data.remove(fName);
                data.put(tName,allCount);
            }
        }
        String[] res = new String[data.size()];
        int k=0;
        for(Map.Entry<String,Integer> entry : data.entrySet()) {
            String nameCount = entry.getKey() + "(" + entry.getValue() + ")";
            res[k++] = nameCount;
        }
        return res;
    }
}
