package subject;

import java.util.*;

public class SubjectTwo {

    public List<List<Integer>> threeSum(int[] nums){
        List<Integer> tempResult = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>0){//最小的数大于0结束循环
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){//重复数据
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                if(nums[j]+nums[k] == -nums[i]){
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    if(j==nums.length-2 || k==1){//最后一组数
                        break;
                    }
                    while(nums[j+1]==nums[j]){
                        ++j;
                        if(j==nums.length-2){//最后一组
                            break;
                        }
                    }
                    while(nums[k-1]==nums[k]){
                        --k;
                        if(k==1){//最后一组
                            break;
                        }
                    }
                    ++j;
                    --k;
                }else if(nums[j]+nums[k] < -nums[i]){
                    ++j;
                }else{
                    --k;
                }
            }
        }
        return result;
    }
}
