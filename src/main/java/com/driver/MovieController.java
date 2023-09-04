package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        return new ResponseEntity(movieService.addMovie(movie), HttpStatus.ACCEPTED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        return new ResponseEntity(movieService.addDirector(director),HttpStatus.ACCEPTED);
    }
    @PutMapping("/add-movie-director-pair")
        public ResponseEntity addMovieDirectorPair(@RequestParam("q") String movie,@RequestParam("q") String director) {
        return new ResponseEntity(movieService.addMovieDirectorPair(movie, director), HttpStatus.ACCEPTED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathParam("name") String movie){
        return new ResponseEntity(movieService.getMovieByName(movie),HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathParam("director") String director){
        return new ResponseEntity(movieService.getDirectorByName(director),HttpStatus.FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathParam("director") String director){
        return new ResponseEntity(movieService.getMoviesByDirectorName(director),HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity(movieService.findAllMovies(),HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String director){
        return new ResponseEntity(movieService.deleteDirectorByName(director),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return new ResponseEntity(movieService.deleteAllDirectors(),HttpStatus.ACCEPTED);
    }


}
