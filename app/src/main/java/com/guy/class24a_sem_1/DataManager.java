package com.guy.class24a_sem_1;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Movie> generateDB() {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie()
                .setTitle("Harry Potter")
                .setImage("https://www.themoviedb.org/t/p/w1280/jltsWuPiQhXK8bDdQubUU8xb7UY.jpg")
                .setGenre(Movie.GENRE.DRAMA)
                .setDuration(180)
                .setRating(4.5)
                .setInNetflix(false)
        );

        movies.add(new Movie()
                .setTitle("Rocky")
                .setImage("https://www.themoviedb.org/t/p/w1280/cqxg1CihGR5ge0i1wYXr4Rdeppu.jpg")
                .setGenre(Movie.GENRE.DRAMA)
                .setDuration(140)
                .setRating(4.6)
                .setInNetflix(true)
        );

        movies.add(new Movie()
                .setTitle("Oppenheimer")
                .setImage("https://www.themoviedb.org/t/p/w1280/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg")
                .setGenre(Movie.GENRE.ACTION)
                .setDuration(140)
                .setRating(4.7)
                .setInNetflix(true)
        );

        movies.add(new Movie()
                .setTitle("ted")
                .setImage("https://www.themoviedb.org/t/p/w1280/cPn71YFDENH0JkWUezlsLyWmLfN.jpg")
                .setGenre(Movie.GENRE.COMEDY)
                .setDuration(134)
                .setRating(134)
                .setInNetflix(true)
        );

        movies.add(new Movie()
                .setTitle("Spider-Man: No Way Home")
                .setImage("https://www.themoviedb.org/t/p/w1280/5weKu49pzJCt06OPpjvT80efnQj.jpg")
                .setGenre(Movie.GENRE.ACTION)
                .setDuration(134)
                .setRating(4.6)
                .setInNetflix(true)
        );

        movies.add(new Movie()
                .setTitle("Reacher")
                .setImage("https://www.themoviedb.org/t/p/w1280/jFuH0md41x5mB4qj5344mSmtHrO.jpg")
                .setGenre(Movie.GENRE.ACTION)
                .setDuration(45)
                .setRating(4.9)
                .setInNetflix(true)
        );

        return movies;
    }
}
