package leetcode.array;

//https://leetcode.com/problems/3sum/

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums ){
        int desiredSum=0;
        int n=nums.length;
        int i=0, j=1, k=n-1;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //-4,-1,-1,0,1,2
        while(i<n-1){
            if( (i==0 || (i>0 && nums[i]!=nums[i-1]))){
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == desiredSum) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[k] == nums[k - 1])
                            k--;
                        while (j < k && nums[j] == nums[j + 1])
                            j++;
                        j++;
                        k--;
                    } else if (sum > desiredSum) {
                        k--;
                    } else if (sum < desiredSum) {
                        j++;
                    }
                }
            }
            i++;
            j=i+1;
            k=n-1;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};//{-2,0,1,1,2};//
        //-4,-1,-1,0,2
        List<List<Integer>> list = threeSum(arr);
        for(List<Integer> l: list){
            for(Integer i: l){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
