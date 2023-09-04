package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping()
    public ResponseEntity addMovie(@RequestBody Movie movie){
        return new ResponseEntity(movieService.addMovie(movie), HttpStatus.ACCEPTED);
    }
    @PostMapping()
    public ResponseEntity addDirector(@RequestBody Director director){
        return new ResponseEntity(movieService.addDirector(director),HttpStatus.ACCEPTED);
    }
    @PutMapping("PUT /movies/add-movie-director-pair")
        public ResponseEntity addMovieDirectorPair(@RequestParam("q") String movie,@RequestParam("q") String director) {
        return new ResponseEntity(movieService.addMovieDirectorPair(movie, director), HttpStatus.ACCEPTED);
    }
    @GetMapping("GET /movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathParam("name") String movie){
        return new ResponseEntity(movieService.getMovieByName(movie),HttpStatus.FOUND);
    }
    @GetMapping(" GET /movies/get-movies-by-director-name/{director}")
    public ResponseEntity getDirectorByName(@PathParam("director") String director){
        return new ResponseEntity(movieService.getDirectorByName(director),HttpStatus.FOUND);
    }
    @GetMapping(" GET /movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathParam("director") String director){
        return new ResponseEntity(movieService.getMoviesByDirectorName(director),HttpStatus.FOUND);
    }
    @GetMapping("GET /movies/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity(movieService.findAllMovies(),HttpStatus.FOUND);
    }
    @DeleteMapping("DELETE /movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name") String director){
        return new ResponseEntity(movieService.deleteDirectorByName(director),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("DELETE /movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        return new ResponseEntity(movieService.deleteAllDirectors(),HttpStatus.ACCEPTED);
    }


}
