package com.billreminder.service;

import com.billreminder.domain.Board;
import com.billreminder.repository.BoardRepository;
import com.billreminder.service.exception.BoardExistException;
import com.billreminder.service.exception.BoardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public Board addNewBoard(Board board) throws BoardExistException {
        if (boardRepository
                .findByMonthAndYear(board.getMonth(), board.getYear()).isPresent()) {
            throw new BoardExistException();
        }
        return save(board);
    }

    public void deleteById(Long id) throws BoardNotFoundException {
        if (findById(id).isPresent()) {
            boardRepository.deleteById(id);
        } else {
            throw new BoardNotFoundException();
        }
    }

    public List<Board> getAll() {
        return boardRepository.findAll();
    }

    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }
}
