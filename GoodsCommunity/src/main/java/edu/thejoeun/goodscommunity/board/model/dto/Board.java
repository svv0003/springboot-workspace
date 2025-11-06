package edu.thejoeun.goodscommunity.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Entity          JPA 데이터베이스 자체를 자바에서 생성하여 DB 컬럼을 관리한다. => 사용 안 한다.
 * @Builder
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    /*
    JPA로 상태 관리할 때 기본키라는 설정
    @Id
    @GeneratedValue
     */
    private int id;
    private String title;
    private String content;
    private String writer;
    private int viewCount;
    private String createdAt;   // DB 명칭은 created_at
    private String updatedAt;   // DB 명칭은 updated_at

    // 인기글 전용 필드 (일반 게시글 조회 시에는 null)
    // private int ranking;         // 인기글 순위
    private Integer ranking;        // 인기글 순위
    private String popularUpdateAt; // 인기글 업데이트 시간

}


