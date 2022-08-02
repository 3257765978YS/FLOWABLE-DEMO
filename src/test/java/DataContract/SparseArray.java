package DataContract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author : 杨帅
 * @description:
 * @date： 2021/3/17 17:21
 */
public class SparseArray {


    public static void main(String[] args) throws FileNotFoundException {
        //创建一个原始的二维数组11*11
        //0：表示没有棋子，1表示黑子 2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //将二维数组转为稀疏数组的思路
        //1.先便利二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0的值存放到sparseArr中
        int count = 0;//定义一个计数器
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        /**
         * 将稀疏数组存到磁盘中
         */
        saveSparse(sparseArr);

        /**
         * 读取磁盘中的文件，转换为稀疏数组
         */

        int[][] sparseArr2 = readSparse();

        //将稀疏数组 -->恢复成原始的二维数组
        /**
         * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的chessArr2=int[11][11]
         * 2. 在读取稀疏数组的后几行的数据，并赋给原始的二维数组即可
         */
        if (sparseArr2 != null) {
            int chessArr2[][] = new int[sparseArr2[0][0]][sparseArr2[0][1]];
            for (int i = 1; i < sparseArr2.length; i++) {
                chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
            }

            //输出恢复后的二维数组
            System.out.println();
            System.out.println("恢复后的二维数组");

            for (int[] row : chessArr2) {
                for (int data : row) {
                    System.out.printf("%d\t", data);
                }
                System.out.println();
            }
        } else {//如果读取的文件没有数据，打印提示语句
            System.out.println("readSparse()方法返回的结果为null");
        }
    }

    public static void saveSparse(int[][] sparseArr) {
        //1.创建字符输出流
        FileWriter writeFile = null;
        try {
            //2.数据想写入的路径及文件
            File file = new File("sparseArray.txt");
            //3.如果该文件不存在，就创建
            if (!file.exists()) {
                file.createNewFile();
            }
            //4.给字节输出；流赋予实例
            writeFile = new FileWriter(file);
            //5.通过循环将数组写入txt文件中
            for (int i = 0; i < sparseArr.length; i++) {
                //6.数据前两列加入","
                for (int j = 0; j < 2; j++) {
                    writeFile.write(sparseArr[i][j] + ",");
                }
                //7.数组最后一列后面不加","
                writeFile.write(sparseArr[i][2] + "");
                //8.加上换行符
                writeFile.write("\r\n");
            }
            //9.把writeFile里的数据全部刷新一次，全部写入文件中
            writeFile.flush();
        } catch (Exception e) {//10.异常捕获
            e.printStackTrace();
        } finally {
            try {
                //11.如果writeFile不为空，就将其关闭
                if (writeFile != null)
                    writeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //读取磁盘中的文件，转换为稀疏数组
    public static int[][] readSparse() {
        //1.声明一个字符输入流
        FileReader reader = null;
        //2.声明一个字符输入缓冲流
        BufferedReader readerBuf = null;
        //3.声明一个二维数组
        int[][] sparseArr = null;
        try {
            //4.指定reader的读取路径
            reader = new FileReader("sparseArray.txt");
            //5.通过BufferedReader包装字符输入流
            readerBuf = new BufferedReader(reader);
            //6.创建一个集合，用来存放读取的文件的数据
            List<String> strList = new ArrayList<>();
            //7.用来存放一行的数据
            String lineStr;
            //8.逐行读取txt文件中的内容
            while((lineStr = readerBuf.readLine()) != null) {
                //9.把读取的行添加到list中
                strList.add(lineStr);
            }
            //10.获取文件有多少行
            int lineNum = strList.size();
            //11.根据文件行数创建对应的数组
            sparseArr = new int[strList.size()][3];
            //12.记录输出当前行
            int count = 0;
            //13.循环遍历集合，将集合中的数据放入数组中
            for(String str : strList) {
                //14.将读取的str按照","分割，用字符串数组来接收
                String[] strs = str.split("\\,");
                sparseArr[count][0] = Integer.valueOf(strs[0]);
                sparseArr[count][1] = Integer.valueOf(strs[1]);
                sparseArr[count][2] = Integer.valueOf(strs[2]);
                //15.将行数 + 1
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //16.关闭字符输入流
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //17.关闭字符输入缓冲流
            try {
                if(readerBuf != null)
                    readerBuf.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //18.返回稀疏数组
        return sparseArr;
    }
}
