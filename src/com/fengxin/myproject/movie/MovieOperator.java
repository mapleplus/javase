package com.fengxin.myproject.movie;

public class MovieOperator {
    private Movie[] movies;
    public MovieOperator(){

    }
    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }
    public void PrintAllMovies(){
        System.out.println("-----电影信息-----");
        for (Movie movie : movies) {
            System.out.println("ID：" + movie.getID());
            System.out.println("名称：" + movie.getNAME());
            System.out.println("价格：" + movie.getPRICE());
            System.out.println("导演：" + movie.getACTOR());
            System.out.println("其它：" + movie.getINFO());
            System.out.println("--------------");
        }
    }
    public void PrintIDMovies(int ID){
        for (Movie movie : movies) {
            if (movie.getID() == ID) {
                System.out.println("-----电影信息如下-----");
                System.out.println("名称：" + movie.getNAME());
                System.out.println("价格：" + movie.getPRICE());
                System.out.println("导演：" + movie.getACTOR());
                System.out.println("其它：" + movie.getINFO());
                System.out.println("--------------");
            }
        }
    }

}
