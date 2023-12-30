package Film_application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Implementation implements Service{

    static Connection conn=null;

    static {
        String url="jdbc:mysql://localhost:3306/film";
        String username="root";
        String password="sql123";
        try {
            conn= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int addFilm(Movie_info m1) {
        int n=0;
        String insertQuery="INSERT INTO FILM_INFO(film_name,release_year,film_lang,film_rating)" +
                "VALUES(?,?,?,?)";
        try {
            PreparedStatement pstmt=conn.prepareStatement(insertQuery);

            pstmt.setString(1,m1.getFilm_name());
            pstmt.setInt(2,m1.getRelease_year());
            pstmt.setString(3,m1.getLang());
            pstmt.setInt(4,m1.getRating());


            n=pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        return n;
    }

    @Override
    public int updateMovie(Movie_info m1) {
    String updateQuery="update film_info set release_year ="+m1.getRelease_year()+" where film_name='"+m1.getFilm_name()+"'";
        try {
            Statement stmt=conn.createStatement();
            return stmt.executeUpdate(updateQuery);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        return 0;
    }

    @Override
    public List<Movie_info> displayHighRated() {
        String displayQuery="select  * from film_info where film_rating >=9 ";
        List<Movie_info>movieList=new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(displayQuery);

            while (rs.next()){
                int id= rs.getInt(1);
                String name=rs.getString(2);
                int year =rs.getInt(3);
                String lang=rs.getString(4);
                int rate= rs.getInt(5);

                Movie_info m1=new Movie_info(id,name,year,lang,rate);
                movieList.add(m1);

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movieList ;
    }

    @Override
    public List<Movie_info> nominated() {

        String displayQuery="select  * from film_info where film_rating >9 ";
        List<Movie_info>movieList=new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(displayQuery);

            while (rs.next()){
                int id= rs.getInt(1);
                String name=rs.getString(2);
                int year =rs.getInt(3);
                String lang=rs.getString(4);
                int rate= rs.getInt(5);

                Movie_info m1=new Movie_info(id,name,year,lang,rate);
                movieList.add(m1);

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movieList ;
    }
}



