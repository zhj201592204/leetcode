package bookOne.algorithmImpl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 *
 * 关键点在于理解图以及将图转化为邻接表
 */
public class Subject_23 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        LinkedList<Integer>[] linkedTable = new LinkedList [n];
        int i;
        //初始化
        for(i=0; i<linkedTable.length; i++) {
            linkedTable[i] = new LinkedList<>();
        }
        //将图存入邻接表
        for(i=0; i<graph.length; i++) {
            linkedTable[graph[i][0]].add(graph[i][1]);
        }
        int[] visited = new int[n];//已经访问过的节点
        Deque<Integer> queue = new ArrayDeque<>();
        queue.addFirst(start);
        while(!queue.isEmpty()) {
            int node = queue.pollFirst();
            visited[node] = 1;
            for(int j=0; j<linkedTable[node].size(); j++) {
                if(1 != visited[linkedTable[node].get(j)]) {
                    if(linkedTable[node].get(j) == target) {
                        return true;
                    }
                    queue.addLast(linkedTable[node].get(j));
                }
            }
        }
        return false;
    }
}
