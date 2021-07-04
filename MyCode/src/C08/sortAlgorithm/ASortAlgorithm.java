package C08.sortAlgorithm;


import java.util.Arrays;
import java.util.Date;

/**
 * @author alario
 * @Date 2021/7/2 14:37
 */
public class ASortAlgorithm {
    public static void main(String[] args) {
        int size=20;       //排序数组大小
        int[] arr=new int[size];
        //随机生成数组
        for (int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*size*100);
        }
        int[] order;
        //冒泡排序
/*       order=BubbleSort.sort(arr);
        show(arr,order);*/
        //选择排序
 /*       order=SelectSort.sort(arr);
        show(arr,order);*/
        //插入排序
        order=InsertionSort.sort(arr);
        show(arr,order);
        }

    public static void show(int[] arr,int[] arr2){
        System.out.println("原数组：");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n"+"排序后:");
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }
}
class BubbleSort {
    public static int[] sort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order= Arrays.copyOf(arr,arr.length);
        int m=order.length;
        if(m!=1){
            for(int i=0;i<m-1;i++) {
                boolean flag=false;  //若某次循环没有变更提前退出
                for (int j = m - 1; j > i ; j--) {
                    if(order[j]<order[j-1]){
                        int temp=order[j-1];
                        order[j-1]=order[j];
                        order[j]=temp;
                        flag=true;
                    }
                }
                if(!flag){
                    break;
                }
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("选择排序用时"+((end-start)/1000)+"秒");
        return order;
    }
}
class SelectSort{
    public static int[] sort(int[] arr) {
        long start=System.currentTimeMillis();
        int[] order= Arrays.copyOf(arr,arr.length);
        int m=order.length;
        if(m!=1) {
            for(int i=0;i<m;i++) {
                int min=i;
                for (int j = i; j < m; j++) {
                    if(order[j]<order[min]){
                        min=j;
                    }
                    int temp=order[i];
                    order[i]=order[min];
                    order[min]=temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序用时"+((end-start)/1000)+"秒");
        return order;
    }
}
class InsertionSort{
    public static int[] sort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order=Arrays.copyOf(arr,arr.length);
        int m=arr.length;
        if(m!=1){
            for(int i=1;i<m;i++){
                int insertVal=order[i];    //待插入值
                int index=i-1;
                while(index>=0&&order[index]>insertVal){
                    order[index+1]=order[index];
                    index--;
                }
                order[index+1]=insertVal;
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("插入排序用时"+((end-start)/1000)+"秒");
        return order;
    }
    public static int[] mysort(int[] arr){
        long start=System.currentTimeMillis();
        int[] order=Arrays.copyOf(arr,arr.length);
        int m=arr.length;
        if(m!=1){
            for(int i=1;i<m;i++){
                int p=-1;    //默认i比第0位小
                for(int j=i-1;j>=0;j--){
                    if (order[j]<order[i]){
                        p=j;   //插入位置p+1
                        break;
                    }
                }
                //p+1到i-1依次往后移一位，p+1处等于i处 ,不好为了移位置又遍历一遍
                int temp=order[i];
                for(int k=i;k>p+1;k--){
                    order[k]=order[k-1];
                }
                order[p+1]=temp;
            }
        }
        long end=System.currentTimeMillis();
        System.out.println("插入排序用时"+((end-start)/1000)+"秒");
        return order;
    }
}


