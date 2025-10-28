package edu.thejoeun.goodscommunity.common.scheduling.schedulingService;

import edu.thejoeun.goodscommunity.board.model.dto.Board;
import edu.thejoeun.goodscommunity.common.scheduling.schedulingMapper.SchedulingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulingServiceImpl implements SchedulingService {

    // Service에서 추상 메서드만 호출할 뿐
    // Mapper에서 기능 가져와서 메서드 기능을 정의한다.
    private final SchedulingMapper schedulingMapper;

    @Override
    public int updatePopularBoards() {

        // 만약 지난 인기글 내역을 삭제하지 않고, 보존하고 싶다면 삭제 메서드 주석처리한다.
        // 1. 기존 인기글 테이블 초기화한다.
        schedulingMapper.deleteAllPopularBoards();

        // 2. 조회수 기준 상위 10개 게시글을 인기글로 등록한다.
        return schedulingMapper.insertPopularBoards();
    }

    @Override
    public List<Board> getPopularBoards() {
        return schedulingMapper.selectAllBoards();
    }
}
