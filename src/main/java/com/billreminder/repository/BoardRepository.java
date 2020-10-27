package com.billreminder.repository;

import com.billreminder.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Override
    <S extends Board> S save(S board);

    @Override
    void deleteById(Long id);

    @Override
    List<Board> findAll();

    @Override
    Optional<Board> findById(Long id);

    Optional<Board> findByMonthAndYear(int month, int year);
}
