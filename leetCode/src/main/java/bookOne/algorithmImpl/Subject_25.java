package bookOne.algorithmImpl;

import bookOne.helperClass.ListNode;
import bookOne.helperClass.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 */
public class Subject_25 {

    public ListNode[] listOfDepth(TreeNode tree) {
        HashMap<Integer, ArrayList<Integer>> dataMap = new HashMap<>();
        if(tree == null) {
            return null;
        }
        getDataMap(dataMap,tree,0);
        ListNode[] resultList = new ListNode[dataMap.size()];
        Iterator it = dataMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            int key = (int) entry.getKey();
            ArrayList<Integer> value = (ArrayList<Integer>) entry.getValue();
            ListNode listNode = new ListNode(value.get(0));
            if(value.size() > 1) {
                ListNode p = listNode;
                for(int i=1; i<value.size();i++) {
                    p.setNext(new ListNode(value.get(i)));
                    p = p.getNext();
                }
            }
            resultList[key] = listNode;
        }
        return resultList;
    }

    private void getDataMap(HashMap<Integer,ArrayList<Integer>> dataMap,TreeNode tree,int index) {
        if(null == dataMap.get(index)) {
            ArrayList<Integer> dataList = new ArrayList<>();
            dataList.add(tree.getVal());
            dataMap.put(index,dataList);
        }else {
            ArrayList<Integer> dataList = dataMap.get(index);
            dataList.add(tree.getVal());
            dataMap.put(index,dataList);
        }
        if(tree.getLeft() != null) {
            getDataMap(dataMap,tree.getLeft(),index+1);
        }
        if(tree.getRight() != null) {
            getDataMap(dataMap,tree.getRight(),index+1);
        }
    }
}
