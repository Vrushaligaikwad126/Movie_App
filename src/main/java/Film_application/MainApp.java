package Film_application;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    static Service service=new Implementation();
    public static void main(String[] args) {

        System.out.println("SELECT!!");
        System.out.println("*******************************");
        System.out.println("1.ADD A NEW MOVIE");
        System.out.println("2.UPDATE  A EXISTING MOVIE");
        System.out.println("3.DISPLAY ALL HIGH RATED MOVIES");
        System.out.println("4.DISPLAY MOVIES WHO GOT NOMINATED FOR OSCAR AWARD !!!");
        System.out.println("5.EXIT");
        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                addFilm();
                break;
            case 2:
                updateMovie();
                break;
            case 3:
                mustWatch();
                break;
            case 4:
                oscar();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("PLEASE  ENTER A VALID CHOICE");
        }
        main(args);
    }

    private static void oscar() {
        System.out.println("THIS MOVIES GOT NOMINATED FOR AN OSCAR AWARD!!!!");
        for (Movie_info m:service.nominated()) {
            System.out.println(m.getFilm_id()+"\t\t"+m.getFilm_name()+
                    "\t\t"+m.getRelease_year()+"\t\t"+m.getLang()+"\t\t"+m.getRating());
        }

    }

    private static void mustWatch() {
        System.out.println("HIGHLY RECOMMENDED MOVIES");
        for (Movie_info m:service.displayHighRated()) {
            System.out.println(m.getFilm_id()+"\t\t"+m.getFilm_name()+
                    "\t\t"+m.getRelease_year()+"\t\t"+m.getLang()+"\t\t"+m.getRating());
        }
    }

    private static void addFilm(){
        System.out.println("ENTER FILM NAME ");
        sc.nextLine();
        String film_name = sc.nextLine();
        System.out.println("ENTER THE YEAR OF FILM RELEASE");
        int release_year = sc.nextInt();
        System.out.println("ENTER THE LANGUAGE OF FILM");
        String lang = sc.next();
        System.out.println("ENTER FILM RATING");
        int rating = sc.nextInt();

      Movie_info m1=new Movie_info(film_name,release_year,lang,rating);
      int n=service.addFilm(m1);
      if(n==1) {
          System.out.println("MOVIE ADDED  SUCCESSFULLY");
      }else {
          System.out.println("MOVIE Not Added");
      }
    }
    private static void updateMovie(){
        System.out.println("ENTER MOVIE NAME");
        String film_name=sc.next();
        System.out.println("ENTER UPDATED RELEASE YEAR");
        int release_year= sc.nextInt();

        Movie_info m1=new Movie_info(film_name,release_year);



        int n=service.updateMovie(m1);
        if (n==1)
            System.out.println(n+"RECORD UPDATED");
        else
            System.out.println("OOPS SOMETHING WENT WRONG");
    }




}