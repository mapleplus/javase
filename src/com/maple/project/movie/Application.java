package com.maple.project.movie;

import java.util.Scanner;

/**
 * @author maple
 */
public class Application {
    public static void main(String[] args) {
        Movie[] movies =new Movie[4];
        movies[0] =new Movie(1,"水门桥",39.9,"吴京","12万人想看") ;
        movies[1] =new Movie(2,"出拳吧",39.0,"田雨","3.5万人想看") ;
        movies[2]=new Movie(3,"月球陨落",42.0,"贝瑞","10.8万人想看") ;
        movies[3] =new Movie(4,"一点就到家",38.9,"刘昊然","13万人想看") ;
        Operator operator = new Operator(movies);
        operator.printAllMovies();
        int id;
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("-----选择-----");
            System.out.println("-----1：查看所有电影信息-----");
            System.out.println("-----2：根据ID查看电影信息-----");
            id = scanner.nextInt();
            switch (id){
                case 1:operator.printAllMovies();
                break;
                case 2:
                    System.out.println("-----输入您要查询的ID-----");
                    id = scanner.nextInt();
                    operator.printMovies(id);
                    break;
                default:
                    System.out.println("-----ID有误-----");
                    break;
            }
        }
    }
}
