package subject;

import java.util.*;

public class SubjectFour {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> result = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(!result.containsKey(words[i])){
                result.put(words[i],1);//初始化
            }
            Integer value = result.get(words[i]);
            result.put(words[i],++value);
        }

        return null;
    }
}
