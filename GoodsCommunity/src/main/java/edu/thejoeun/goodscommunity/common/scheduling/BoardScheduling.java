package edu.thejoeun.goodscommunity.common.scheduling;

import edu.thejoeun.goodscommunity.common.scheduling.schedulingService.SchedulingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @Slf4j       log.info()를 사용할 수 있는 어노테이션.
 * @Component   Service나 Controller처럼 특정 명칭을 지정하지 않는 파일이면서
 *              Spring Boot에 @Bean으로 등록할 때 사용하는 어노테이션.
 */
@Slf4j
@Component
@RequiredArgsConstructor        // 이제 Autowired 안 쓰고 @RequiredArgsConstructor 사용하기.
public class BoardScheduling {

    // 오버라이드 되어 사용된 기능을 사용하기 때문에 Service 또는 ServiceImpl 가져와
    private final SchedulingService schedulingService;

    /*
    매일 23시 59분에 인기글 목록 업데이트
    cron = "초 분 시 일 월 요일 [년도]" (일요일 1 ~ 토요일 7)
    0 59 23 * * *

    controller에 작성하지 않아도 알아서 23시 59분이 되면 자동으로 데이터 저장과 삭제를 할 것이기 때문에
    postMapping이나 deleteMapping을 따로 api 설정해서 연결하지 않아도 된다.
    소비자에게 보여주는 것이 아니라 우리 회사의 페이지를 위해 개발자가 자동 업데이트 처리를 진행한 것이기 때문이다.
     */
    /*
    실제 배포용 스케줄링
    @Scheduled(cron = "0 59 23 * * *")
    개발자 확인용 스케줄링
    인기글을 23시 59분까지 기다리지 않고, 인기글 업데이트가 무사히 잘 되는지 개발자가 확인하는 방법 1탄
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void updatePopularBoards() {

        String startTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("===인기글 업데이트 스케줄러 시작 [{}]===", startTime);
        // printf()처럼 중괄호{}를 작성하면 쉼표(,) 뒤 변수명에 존재하는 데이터가 중괄호{} 내부에 작성된다.
        // ===인기글 업데이트 스케줄러 시작 [2025-10-28 23:59:00]===

        // 서비스에서 update 인기 게시물 가져오기 작업할 것이다.
        try {
            // result 내부에는 delete하고, insert를 몇 개 완료했는지 DB에 저장되는 개수가 저장될 것이고, log로 확인할 것이다.
            // "" 사이에 데이터 값이 들어가지 않아도 되면 쉼표(,)를 사용해서 이어서 진행하면 된다.
            int result = schedulingService.updatePopularBoards();
            log.info("인기글 업데이트 완료 : {}", result);
        } catch (Exception e) {
            log.error("인기글 업데이트 중 오류 발생 : " + e);
        }

        String endTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("===인기글 업데이트 스케줄러 종료 [{}]===", endTime);
        // ===인기글 업데이트 스케줄러 종료 [2025-10-28 23:59:01]===

    }
}

/*
dev     개발
stage   배포 전 회사 테스트
prod    실제 배포
 */