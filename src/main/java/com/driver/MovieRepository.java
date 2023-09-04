package com.driver;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class MovieRepository {
HashMap<String,Movie> movieHashMap = new HashMap<>();
HashMap<String,Director>directorHashMap = new HashMap<>();
HashMap<String, ArrayList<String>> pair = new HashMap<>();
    public String addMovie(Movie movie) {
            movieHashMap.put(movie.getName(),movie);
        return "success";
    }

    public Object addDirector(Director director) {
        directorHashMap.put(director.getName(),director);
        return "success";
    }

    public String addMovieDirectorPair(String movie, String director) {
        if(pair.containsKey(director)){
            ArrayList<String> a = pair.get(director);
            a.add(movie);
            pair.put(director,a);
        }
        else{
            ArrayList<String> a = new ArrayList<>();
            a.add(movie);
            pair.put(director,a);
        }
        return "success";
    }

    public Object getMovieByName(String movie) {
        return movieHashMap.get(movie);
    }

    public Object getDirectorByName(String director) {
        return directorHashMap.get(director);
    }

    public Object getMovieByDirectorName(String director) {
        return pair.get(director);
    }

    public Object findAllMovies() {
        ArrayList<String> result = new ArrayList<>();
        for(String str:movieHashMap.keySet()){
            result.add(str);
        }
        return result;
    }

    public Object deleteDirectorByName(String director) {
        if(directorHashMap.containsKey(director)){
            directorHashMap.remove(director);
        }
        if(pair.containsKey(director)){
            pair.remove(director);
        }
        return "success";
    }

    public Object deleteAllDirectors() {
        for(String dir:directorHashMap.keySet()){
            if(pair.containsKey(dir)==true){
                ArrayList<String> a = pair.get(dir);
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
