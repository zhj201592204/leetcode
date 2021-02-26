package bookOne.algorithmImpl;

import java.util.HashMap;
import java.util.Map;

public class Subject_64 {

    private Map<Integer,Integer> data;
    private int maxLen;
    private int useLen;
    private Map<Integer,Integer> useTime;

    public Subject_64(int capacity) {
        maxLen = capacity;
        data = new HashMap<>();
        useTime = new HashMap<>();
    }

    public int get(int key) {
        if(data.containsKey(key)) {
            useTime.put(key,useTime.get(key)+1);
            return data.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        int minTime = 99999999;
        int minKey = -1;
        if(!data.containsKey(key)) {
            if(useLen == maxLen) {
                for(int index : useTime.keySet()) {
                    if(useTime.get(index) < minTime) {
                        minTime = useTime.get(index);
                        minKey = index;
                    }
                }
                useTime.remove(minKey);
                data.remove(minKey);
                data.put(key,value);
                useTime.put(key,1);
            }else {
                data.put(key,value);
                ++useLen;
                useTime.put(key,1);
            }
        }

    }
}
