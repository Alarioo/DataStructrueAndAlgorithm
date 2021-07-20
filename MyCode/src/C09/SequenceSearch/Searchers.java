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
/*        //二分查找
        System.out.println("位置："+BinarySearch.search(seq,6));*/
        //插值查找
        System.out.println("位置："+InsertSearch.search(seq,6));
    }
}
class BinarySearch{
    public static List<Integer> search(int[] seq, int obj){
        List<Integer> Index=new ArrayList<>();
        int left = 0;
        int right = seq.length-1;
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
class InsertSearch{
    public static List<Integer> search(int[] seq,int obj){
        List<Integer> Index=new ArrayList<>();
        int left = 0;
        int right = seq.length-1;
        while(left<right){
            //系数由1/2改为(obj-seq[left])/(seq[right]-seq[left])
            int mid = (obj-seq[left])/(seq[right]-seq[left])*(right-left)+left;
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
class FibonacciSearch{
    public static int[] fib(int size){
        int[] f = new int[size];
        f[0]=1;
        f[1]=1;
        for (int i = 2 ;f[i]<size ;i++){
            f[i] =f[i-1]+f[i-2];
        }
        return f;
    }
}