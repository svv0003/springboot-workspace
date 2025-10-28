package edu.thejoeun.goodscommunity.common.scheduling.schedulingMapper;

import edu.thejoeun.goodscommunity.board.model.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchedulingMapper {

    /*
    인기 테이블 전체 삭제

    void는 단순히 삭제 유무만 확인할 때
    int는 몇 개가 삭제되었는지 삭제된 개수를 반환하여 클라이언트나 개발자가 확인해야 할 때 사용한다.
     */
    void deleteAllPopularBoards();

    /*
    조회수 기준 상위 게시글 인기글로 등록

    void는 단순히 저장 유무만 확인하고, 저장이 잘 되면 가입이 완료되었습니다. 게시글이 등록되었습니다.
    int는 몇 개의 데이터가 저장되었는지 DB row에 작성된 insert 데이터 개수를
    클라이언트에게 반환하거나 개발자에게 반환하여 몇 개가 저장되었다. 표기
    @return 등록된 게시글 수
     */
    int insertPopularBoards();

    // 인기글 목록 조회
    List<Board> selectAllBoards();

}
