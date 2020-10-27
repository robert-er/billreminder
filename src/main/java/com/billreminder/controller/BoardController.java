package com.billreminder.controller;

import com.billreminder.dto.BoardDto;
import com.billreminder.mapper.BoardMapper;
import com.billreminder.service.BoardService;
import com.billreminder.service.exception.BoardNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    @PostMapping
    public Long createBoard(@RequestBody BoardDto boardDto) {
        return boardService.addNewBoard(boardMapper.mapToBoard(boardDto)).getId();
    }

    @GetMapping
    public List<BoardDto> getAll() {
        return boardMapper.mapToBoardDtoList(boardService.getAll());
    }

    @GetMapping({"id"})
    public BoardDto getBoard(@PathVariable Long id) {
        return boardMapper.mapToBoardDto(boardService.findById(id).orElseThrow(BoardNotFoundException::new));
    }

    @DeleteMapping({"id"})
    public void deleteBoard(@PathVariable Long id) {
        boardService.deleteById(id);
    }

    @PutMapping
    public BoardDto updateBoard(@RequestBody BoardDto boardDto) {
        return boardService.findById(boardDto.getId())
                .map(board -> {
                    board.setMonth(boardDto.getMonth());
                    board.setYear(boardDto.getYear());
                    board.setMonthlyPayment(boardDto.getMonthlyPayment());
                    return boardMapper.mapToBoardDto(boardService.save(board));
                })
                .orElseThrow(BoardNotFoundException::new);
    }
}
