package com.example.app111_movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app111_movie.model.Movie;
import com.example.app111_movie.repository.MovieRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	private final MovieRepository movieRepository;
	// 추가
	public Movie insert(Movie movie) {
		return movieRepository.save(movie);
	}

	// 전체보기
	public List<Movie> list() {
		return movieRepository.findAll();
	}

	// 삭제
	public void delete(Long movieid) {
		movieRepository.deleteById(movieid);	
	}

}
