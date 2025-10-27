package edu.thejoeun.goodscommunity.board.model.mapper;

import edu.thejoeun.goodscommunity.board.model.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    /*
    mapper.xml에 작성한 id와 메서드명 일치하도록 작성한다.
     */
    List<Board> getAllBoard();
    Board getBoardById(int id);
}
