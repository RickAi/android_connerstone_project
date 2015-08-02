package top.navyblue.connerstone.managers;

/**
 * Created by CIR on 8/2/15.
 */
public class UrlManager {

    public static final String DOUBAN_API = "http://api.douban.com";


    // Douban movie:
    // http://api.douban.com/v2/movie/top250
    public static String getTop250(){
        String url = DOUBAN_API + "/v2/movie/top250";
        return url;
    }

    // http://api.douban.com/v2/movie/weekly
    public static String getWeekly(){
        String url = DOUBAN_API + "/v2/movie/weekly";
        return url;
    }

    // http://api.douban.com/v2/movie/us_box
    public static String getUsbox(){
        String url = DOUBAN_API + "/v2/movie/us_box";
        return url;
    }

    // http://api.douban.com/v2/movie/new_movies
    public static String getNewmovies(){
        String url = DOUBAN_API + "/v2/movie/new_movies";
        return url;
    }

}
