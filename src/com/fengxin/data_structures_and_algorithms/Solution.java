package com.fengxin.data_structures_and_algorithms;

/**
 * @author FENGXIN
 **/

public class Solution {
    public static void main (String[] args) {
        int n = 3;
        int num = n/2;
        int offset = 1;
        int startX = 0,startY = 0,count = 1;
        int i = startX;
        int j = startY;
        int[][] arr = new int[n][n];
        while(num != 0){
            // 最外围一圈
            // 上横行,i不变j变
            for( j = startY;j < n - offset; j++){
                arr[startX][j] = count++;
            }
            // 右竖行,i变j不变
            for( i = startX; i < n - offset; i++){
                arr[i][j] = count++;
            }
            // 下横行,i不变j变
            for(  ; j > startY ; j--){
                arr[i][j] = count++;
            }
            // 左竖行,i变j不变
            for(  ; i > startX; i--){
                arr[i][j] = count++;
            }
            // 循环结束一圈后更新相应变量
            offset++;
            startX++;
            startY++;
            num-- ;
        }
        if(n%2 != 0)
        {
            arr[startX][startY] = count;
        }
        
        // 打印数组
        for(i = 0;i < n;i++){
            for(j = 0;j < n;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}



