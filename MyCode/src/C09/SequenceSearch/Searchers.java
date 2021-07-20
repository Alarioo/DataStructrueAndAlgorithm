package C09.SequenceSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alario
 */
public class Searchers {
    public static void main(String[] args) {
        int[] seq=new int[20];
        for(int i=0;i<20;i++){
            seq[i]=i+(int)Math.round(Math.random());
        }
        for(int i=0;i<seq.length;i++){
            System.out.print(seq[i]+" ");
        }
        System.out.println("\n"+"----输出结果------");
        //二分查找
        System.out.println("位置："+BinarySearch.search(seq,6));
    }
}
class BinarySearch{
    public static List<Integer> search(int[] seq, int obj){
        List<Integer> Index=new ArrayList<>();
        int left = seq[0];
        int right = seq[seq.length-1];
        while(left<right){
            int mid = (left+right)/2;
            if(seq[mid]==obj){
                Index.add(mid);
                //返回所有相同的值
                int temp =mid-1;
                while(temp>-1&&seq[temp]==obj) {
                    Index.add(temp);
                    temp--;
                }
                temp =mid+1;
                while(temp<seq.length&&seq[temp]==obj) {
                    Index.add(temp);
                    temp++;
                }
                break;
            }else if(seq[mid]<obj){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return Index;
    }
}