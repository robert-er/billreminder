package com.billreminder.mapper;

import com.billreminder.domain.Board;
import com.billreminder.dto.BoardDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BoardMapper {

    public Board mapToBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setMonth(boardDto.getMonth());
        board.setYear(boardDto.getYear());
        board.setMonthlyPayment(boardDto.getMonthlyPayment());
        return board;
    }

    public BoardDto mapToBoardDto(Board board) {
        return new BoardDto(board.getId(),
                board.getMonth(),
                board.getYear(),
                board.getMonthlyPayment());
    }

    public List<BoardDto> mapToBoardDtoList(List<Board> boardList) {
        return boardList.stream()
                .map(this::mapToBoardDto)
                .collect(Collectors.toList());
    }
}
