package C01.SparseArray;

import java.io.*;

public class SparseArray {
    /*
    生成原始棋盘
    生成稀疏数组 方法1
    输出。data
    读出。data 方法2
    生成棋盘
    */
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("MyCode\\src\\C01\\SparseArray\\map.data"));
        BufferedReader br=new BufferedReader(new FileReader("MyCode\\src\\C01\\SparseArray\\map.data"));
        int[][]  chess=new int[18][18];
        chess[1][2] =1;
        chess[2][3] =1;
        chess[7][5] =1;
        System.out.println("原始数组");
        showTable(chess);

        System.out.println("生成稀疏数组及相应.data文件");
        int[][] sa=getSparseArray(chess,bw);
        showTable(sa);

        System.out.println("读取稀疏数组.data生成稀疏数组");
        int[][] origin=getOrigin(br);

        System.out.println("还原数组");
        showTable(origin);
        //释放资源
        bw.close();
        br.close();
    }
    public static void showTable(int[][] arr){
        for (int[] row :arr){
            for(int data:row){
                System.out.printf("%d\t",data); //printf 格式化输出
            }
            System.out.println();
        }
    }
    public static int[][] getSparseArray(int[][] chess,BufferedWriter bw) throws IOException{
        //判断是否为二维非空数组
        if(chess.length==0||chess[0].length==0){
            throw new RuntimeException("输入数组非二维非空数组");
        }
        int row=chess.length;
        int colum=chess[0].length;
        int sum=0;
        for(int i=0;i<row;i++){
            for (int j=0;j<colum;j++){
                if(chess[i][j]>0){
                    sum++;
                }
            }
        }
        int[][] ret=new int[sum+1][3];
        ret[0][0]=row;
        ret[0][1]=colum;
        ret[0][2]=sum;
        int count=1;
        for(int i=0;i<row;i++){
            for (int j=0;j<colum;j++){
                if(chess[i][j]>0){
                    ret[count][0]=i;
                    ret[count][1]=j;
                    ret[count][2]=chess[i][j];
                    count++;
                }
            }
        }
        //输出.data文件
        for(int i=0;i<sum+1;i++){
            StringBuilder sb=new StringBuilder();
            for (int j=0;j<2;j++){
                sb.append(ret[i][j]+",");
                }
            sb.append(ret[i][2]);
            bw.write(sb.toString());
            bw.newLine();
        }
        bw.flush();     //记得要要flush
        return ret;
    }
    public static int[][] getOrigin(BufferedReader br)throws IOException{
        //读取第1行确定稀疏数组大小
        String[] str=br.readLine().split(",");  //String[] str=line.split(",|：");   // 用 |  区分多个换行符
        int sum=Integer.parseInt(str[2]);
        int[][] arr=new int[sum+1][3];
        arr[0][0]=Integer.parseInt(str[0]);
        arr[0][1]=Integer.parseInt(str[1]);
        arr[0][2]=Integer.parseInt(str[2]);
        //默认在第2行开始读取
        int row=1;
        String line;
        while((line=br.readLine())!=null){
            str=line.split(",");
            arr[row][0]=Integer.parseInt(str[0]);
            arr[row][1]=Integer.parseInt(str[1]);
            arr[row][2]=Integer.parseInt(str[2]);
            row++;
        }
        showTable(arr);
        //由稀疏数组返回原数组
        int[][] ori=new int[arr[0][0]][arr[0][1]];
        int num=1;
        for(int i=0;i<arr[0][2];i++){
            ori[arr[num][0]][arr[num][1]]=arr[num][2];
            num++;
        }
        return ori;
    }
}
