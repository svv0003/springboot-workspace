package edu.thejoeun.goodscommunity.board.model.service;

import edu.thejoeun.goodscommunity.board.model.dto.Board;
import edu.thejoeun.goodscommunity.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    /*
    @Autowired
    BoardMapper boardMapper;

    Autowired보다 ReqiredArgsConstructor 처리해주는 것이
    상수화하여 Mapper를 사용할 수 있으므로 안전하다.
    -> 내부 매서드나 데이터 변경 불가하다.
     */
    private final BoardMapper boardMapper;

    @Override
    public List<Board> getAllBoard() {
        return boardMapper.getAllBoard();
    }

    @Override
    public Board getBoardById(int id) {
        Board b = boardMapper.getBoardById(id);
        return b != null ? b : null;
        /*
        게시물 상세 조회를 위해 id를 입력하고,
        입력한 id에 해당하는 게시물이 존재할 경우에는 조회된 데이터를 전달한다.
        존재하지 않을 경우에는 null을 전달한다.
         */
    }
}
