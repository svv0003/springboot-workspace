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

    /**
     * 게시물 클릭 시 상세 조회한다.
     * @param id 에 해당하는
     * @return 게시물 데이터 반환
     */
    Board getBoardById(int id);

    /**
     * 작성한 게시물 저장한다.
     * @param board 게시물 데이터 가져온다.
     */
    void insertBoard(Board board);

    /**
     * 게시물 데이터 제목, 내용, 저자 수정 불가, 업데이트 일자 변경
     * @param board
     */
    void updateBoard(Board board);

    /**
     * 게시물 상세보기 선택 시 해당 게시물 조회 수 증가한다.
     * @param id
     */
    void updateViewCount(int id);
}
