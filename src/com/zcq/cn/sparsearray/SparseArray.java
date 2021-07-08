package com.zcq.cn.sparsearray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 棋盘的存储和还原
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个二维数组来存放棋盘
        // 0代表没有棋子，1代表黑子，2白子
//        int chessArr[][] = new int[11][11];
//        // 存储的棋子
//        int count = 0;
//        chessArr[2][3] = 1;
//        count += 1;
//        chessArr[3][4] = 2;
//        count += 1;
//        sparseArrayWrite(chessArr, count);


        Map<String, List<Integer>> map = null;
        try {
            map = sparseArrayRead("temp.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Integer> list =  map.get("0");
        int chessArr2[][] = new int[list.get(0)][list.get(1)];
        map.remove("0");

        map.forEach((s, o) -> {
            chessArr2[o.get(0)][o.get(1)] = o.get(2);
        });

        for (int[] ints : chessArr2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * 二维数组转稀疏数组并写入文件（参数：二维数组，棋子数量）
     */
    private static void sparseArrayWrite(int[][] chessArr, int count) throws IOException{
        // 创建稀疏数组sparseArr = row: 棋子数（count+1）,col: 3
        int sparseArr[][] = new int[count + 1][3];
        // 第一列赋值
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = count;

        // 稀疏数组的第一行
        int i = 1;

        // 循环棋盘数组，给稀疏数组赋值
        for (int a = 0; a < chessArr.length; a++) {
            for (int b = 0; b < chessArr[a].length; b++) {
                if (count <= 0) {
                    break;
                }
                if (chessArr[a][b] != 0) {
                    // 赋值
                    sparseArr[i][0] = a;
                    sparseArr[i][1] = b;
                    sparseArr[i][2] = chessArr[a][b];
                    i += 1;
                    count--;
                }
            }
        }

        // 存储到文件
        FileWriter fileWriter = null;

        fileWriter = new FileWriter("temp.txt");
        for (int[] aSparseArr : sparseArr) {
            for (int anASparseArr : aSparseArr) {
                fileWriter.write(anASparseArr + "\t");
            }
            fileWriter.write("\r\n");
        }

        fileWriter.close();
    }

    /**
     * 读取文件并转成二位数组(参数：文件名)
     * @return treeMap(自动排序)
     */
    private static Map<String, List<Integer>> sparseArrayRead(String filename) throws IOException {
        Map<String, List<Integer>> map = new TreeMap<>();
        File file = new File(filename);

        // 逐行读取
        BufferedReader in = null;
        String line;

        int k = 0;
        in = new BufferedReader(new FileReader(file));
        while ((line = in.readLine()) != null) {
            String[] temp = line.split("\t");
            List<Integer> slist = new ArrayList<>();
            for (String aTemp : temp) {
                slist.add(Integer.valueOf(aTemp));
            }
            map.put(k + "", slist);
            k++;
        }
        return map;
    }
}