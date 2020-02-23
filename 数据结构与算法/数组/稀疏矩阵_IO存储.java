package 数据结构与算法.数组;

import java.io.*;

/**
 * @Author bennyrhys
 * @Date 2020-02-22 20:10
 */
public class 稀疏矩阵_IO存储 {
    public static void main(String[] args) throws IOException {
        // 【初始化数组-棋盘1】
        // 定义11*11的二维数组
        int[][] chessArr1 = new int[12][11];
        // 0表示空子，1表示白子，2表示黑子
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        // 输出11*11棋盘
        System.out.println("============【初始化数组-棋盘1】===============");
        for (int[] row : chessArr1) {
            for (int colData : row) {
                System.out.print(colData+" \t");
            }
            System.out.println();
        }

        // 【转稀疏数组】
        // 统计数组-棋盘1非零个数
        int sum = 0;
        System.out.println("============【转稀疏数组】===============");
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }
        System.out.println("非零个数："+sum);

        // 创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];

        // 赋值-稀疏数组第一行 行、列、非零个数
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非零值存放其中
            // 非零计数器
        int count = 0;
            // 统计数组-棋盘1非零个数
        System.out.println("============【转稀疏数组】===============");
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;

                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        // 遍历稀疏矩阵
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }

        // 【稀疏数组-》普通数组-棋盘2】
        // 创建数组-棋盘2
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 赋值
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 遍历输出-棋盘2
        System.out.println("============【稀疏数组-》普通数组-棋盘2】===============");
        for (int[] row : chessArr2) {
            for (int colData : row) {
                System.out.print(colData+" \t");
            }
            System.out.println();
        }



//        测试文件/Users/bennyrhys/Documents/Idea_Demo/interview/src/数据结构与算法/数组/
        String url = "/Users/bennyrhys/Documents/Idea_Demo/interview/src/数据结构与算法/数组/Arr.txt";
        File file = new File(url);

//        检测文件是否存在
        if (!file.exists()) {
            file.createNewFile();
        }

//       写入文件 【抛异常】
        Writer writer = new FileWriter(file);

//      数组转字符串
        String data = "";
        for (int[] row : sparseArr) {
            for (int colData : row) {
                data += colData+" \t";
            }
            data += "\n";
        }
//      检验并写入文件
        System.out.println(data);
        writer.write(data);

//      常规关闭
        writer.flush();
        writer.close();


        FileReader reader = new FileReader(url);
        int temp = 0;
        String readArr = ""+reader.read();

        while (reader.read() != -1){
            readArr += reader.read();
            System.out.println("读出："+readArr);
        }

        reader.close();

    }
}
