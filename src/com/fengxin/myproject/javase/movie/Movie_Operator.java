package com.fengxin.myproject.javase.movie;

/**
 * @author FENGXIN
 */
public class Movie_Operator {
    private Movie[] movies;
    public Movie_Operator (){

    }
    public Movie_Operator (Movie[] movies) {
        this.movies = movies;
    }
    public void printAllMovies (){
        System.out.println("-----电影信息-----");
        for (Movie movie : movies) {
            System.out.println("ID：" + movie.getId ());
            System.out.println("名称：" + movie.getName ());
            System.out.println("价格：" + movie.getPrice ());
            System.out.println("导演：" + movie.getActor ());
            System.out.println("其它：" + movie.getInfo ());
            System.out.println("--------------");
        }
    }
    public void printIDMovies (int ID){
        for (Movie movie : movies) {
            if (movie.getId () == ID) {
                System.out.println("-----电影信息如下-----");
                System.out.println("名称：" + movie.getName ());
                System.out.println("价格：" + movie.getPrice ());
                System.out.println("导演：" + movie.getActor ());
                System.out.println("其它：" + movie.getInfo ());
                System.out.println("--------------");
            }
        }
    }

}
