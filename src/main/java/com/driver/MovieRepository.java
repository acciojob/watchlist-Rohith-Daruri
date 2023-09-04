package com.driver;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
HashMap<String,Movie> movieHashMap = new HashMap<>();
HashMap<String,Director>directorHashMap = new HashMap<>();
HashMap<String, List<String>> pair = new HashMap<>();
    public String addMovie(Movie movie) {
            movieHashMap.put(movie.getName(),movie);
        return "success";
    }

    public String addDirector(Director director) {
        directorHashMap.put(director.getName(),director);
        return "success";
    }

    public String addMovieDirectorPair(String movie, String director) {
        if(movieHashMap.containsKey(movie) && directorHashMap.containsKey(director)) {
            if (pair.containsKey(director)) {
                List<String> a = pair.get(director);
                a.add(movie);
                pair.put(director, a);
            } else {
                List<String> a = new ArrayList<>();
                a.add(movie);
                pair.put(director, a);
            }
        }
        return "success";
    }

    public Object getMovieByName(String movie) {
        return movieHashMap.get(movie);
    }

    public Object getDirectorByName(String director) {
        return directorHashMap.get(director);
    }

    public List<String> getMovieByDirectorName(String director) {
        return pair.get(director);
    }

    public List<String> findAllMovies() {
        List<String> result = new ArrayList<>();
        for(String str:movieHashMap.keySet()){
            result.add(str);
        }
        return result;
    }

    public String deleteDirectorByName(String director) {
        if(directorHashMap.containsKey(director)){
            directorHashMap.remove(director);
        }
        if(pair.containsKey(director)){
            pair.remove(director);
        }
        return "success";
    }

    public String deleteAllDirectors() {
        for(String dir:directorHashMap.keySet()){
            if(pair.containsKey(dir)==true){
                List<String> a = pair.get(dir);
                for(String s:a){
                    if(movieHashMap.containsKey(s)) {
                        movieHashMap.remove(s);
                    }
                }
            }
            directorHashMap.remove(dir);
        }
        return "success";
    }
}
