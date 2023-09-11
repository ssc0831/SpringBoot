package com.example.app07_board.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.app07_board.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
