package com.example.app111_movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.app111_movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
