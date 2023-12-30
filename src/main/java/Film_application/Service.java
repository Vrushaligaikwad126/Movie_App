package Film_application;

import java.util.List;

public interface Service {

    int addFilm(Movie_info m1);

    int updateMovie(Movie_info m1);
    List<Movie_info> displayHighRated();
    List<Movie_info> nominated();

}
