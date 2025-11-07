package edu.thejoeun.goodscommunity.board.model.service;

import edu.thejoeun.goodscommunity.board.model.dto.Board;

import java.util.List;

public interface BoardService {

    List<Board> getAllBoard();
    Board getBoardById(int id);
    void createBoard(Board board);
    void updateBoard(Board board);
}
