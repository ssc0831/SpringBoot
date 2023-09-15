package com.example.app111_movie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app111_movie.model.Movie;
import com.example.app111_movie.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MovieController {
	private final MovieService movieService;
	
	// 추가
	@PostMapping("/movie/insert")
	public Movie insert(@RequestBody Movie movie) {
		return movieService.insert(movie);
	}
	
	// 전체보기
	@GetMapping("/movie/list")
	public List<Movie> list() {
		return movieService.list();
	}
	
	// 삭제
	@DeleteMapping("/movie/delete/{num}")
	public void delete(@PathVariable Long movieid) {
		movieService.delete(movieid);
	}
}
