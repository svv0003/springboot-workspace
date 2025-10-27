package edu.thejoeun.goodscommunity.common.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Spring Scheduler
 * 스프링에서 제공하는 일정 시간/주기마다 예정된 코드를 실행하는 객체
 *
 * [설정 방법]
 * 1. 프로젝트명칭Application.java 파일에 @EnableScheduling 어노테이션 추가한다.
 * 2. 스케줄러 코드를 작성할 별도 클래스를 생성한 후 Bean으로 등록한다.
 *    -> @Component 어노테이션 작성한다.
 * 3. 해당 클래스에 @Schedules(시간/주기) 어노테이션을 추가한 메서드를 작성한다.
 *
 * 주의사항
 * 해당 매서드는 반환형이 존재해서는 안 된다.
 *
 * @Slf4j       log를 작성할 수 있는 어노테이션
 * @Component   Bean으로 등록하여 스프링이 자동으로 스케줄링 코드를 수행하도록 한다.
 */
@Slf4j
@Component
public class TestScheduling {

    /*
    @Scheduled      매개변수
    fixedDelay      이전 작업이 끝난 후 다음 작업이 시작할 때까지의 시간을 지정한다.
    fixedRate       이전 작업이 시작한 후 다음 작업이 시작할 때까지의 시간을 지정한다.
    cron            UNIX 계열 잡 스케줄러 표현식이다.
                    "초 분 시 일 월 요일 [년도]" (일요일 1 ~ 토요일 7)
                    [2025년] 월요일 10월 27일 12시 50분 0초에 수행하도록 작성하려면
                    cron = "0 50 12 27 10 2 2025"
    특수문자별 의미
    *       모든 수
    -       두 사이의 값                     10-15 => 10 이상 15 이하
    ,       특정 값 지정                     분 자리에 3,6,9,12 => 3분 6분 9분 12분 동작한다.
    /       값 증가                          0/5 => 0부터 시작해서 5씩 증가할 때마다 수행한다.
    ?       특별한 값 없이 (월/요일만 가능)
    L       마지막 (월/요일만 가능)
     */

    // @Scheduled(fixedRate = 5000)           // ms 단위 (5000 = 5초)
    // @Scheduled(fixedDelay = 1000)
    // @Scheduled(cron = "0 * * * * *")       // 매 0초마다 수행한다. (1분 간격)
    // @Scheduled(cron = "30 * * * * *")      // 매 30초마다 수행한다. (30초 간격)
    // @Scheduled(cron = "0/7 * * * * *")     // 0초부터 7초마다 수행한다. (7초 간격)
    // @Scheduled(cron = "0 0 0 * * *")       // 매일 자정마다 수행한다. (24시간 간격)
    // @Scheduled(cron = "59 59 23 * * *")    // 매일 자정 1초 전마다 수행한다. (24시간 간격)
    public void testMethod() {
        log.info("스케줄러 테스트 중입니다.");
    }
}
