package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public Object addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String movie, String director) {
        return movieRepository.addMovieDirectorPair(movie,director);
    }

    public Object getMovieByName(String movie) {
        return movieRepository.getMovieByName(movie);
    }

    public Object getDirectorByName(String director) {
        return movieRepository.getDirectorByName(director);
    }

    public Object findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public Object deleteDirectorByName(String director) {
        return movieRepository.deleteDirectorByName(director);
    }

    public Object deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }

    public Object getMoviesByDirectorName(String director) {
        return movieRepository.getMovieByDirectorName(director);
    }
}
