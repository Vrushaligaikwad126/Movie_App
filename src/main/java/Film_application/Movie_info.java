package Film_application;

public class Movie_info {
    private int film_id;
    private String film_name;
    private int release_year;
    private String lang;
    private int rating;

    public Movie_info() {
    }

    public Movie_info(int film_id, String film_name, int release_year, String lang, int rating) {
        this.film_id = film_id;
        this.film_name = film_name;
        this.release_year = release_year;
        this.lang = lang;
        this.rating = rating;
    }

    public Movie_info(String film_name, int release_year, String lang, int rating) {
        this.film_name = film_name;
        this.release_year = release_year;
        this.lang = lang;
        this.rating = rating;
    }

    public Movie_info(String film_name, int release_year) {
        this.film_name = film_name;
        this.release_year = release_year;
    }

    public int getFilm_id() {
        return film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
