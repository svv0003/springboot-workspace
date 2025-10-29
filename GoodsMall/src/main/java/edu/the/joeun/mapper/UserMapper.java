package edu.the.joeun.mapper;

import edu.the.joeun.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    // user로 된 목록을 가져올 때 List 사용한다.
    List<User> getAllUser();

    /*
    insert의 경우는 void와 int 둘 다 가능하다.

    int - return = 저장된 데이터 수 반환한다.
    여러 개의 데이터를 한 번에 저장할 때 몇 개의 데이터가 저장되었고,
    몇 개의 데이터가 저장되지 않았는지 클라이언트에게 전달하고자 할 때 사용한다.

    void - 저장 결과 유무 확인 가능하다.
    단일 데이터를 저장하고, 데이터가 몇 개 저장되었는지
    클라이언트에게 전달하지 않을 때 주로 사용한다. (단순 저장)

    select, update, delete는 insert와 비슷하게 상황에 따라 int, void 사용한다.

    만약 몇 개의 데이터를 조회(검색)했는지 확인하고자 할 때는 int 사용하고,
    몇 개의 데이터를 수정, 삭제했는지 확인하고자 할 때 int 사용한다.
    하지만 단순 조회, 수정, 삭제를 할 경우에는 void나 User와 같은 자료형을 활용하기도 한다.
    개발자가 원하는 결과 상황에 따라 자료형은 void, int User와 같은 자료형을 사용한다.
     */
    // 단순 저장 확인용 void (=반환 데이터 없음) 선택
    void insertUser(User user);

    /*
    @Insert("INSERT INTO user (name, email, role) VALUES (#{name}, #{email}, #{role})")
    void insertUser();

    AI 또는 인터넷에서 위와 같은 방식을 추천할 경우
    쿼리가 작동하긴 하지만 유지보수가 어려워서 사용은 지양한다.
     */

    /**
     * 이메일로 사용자 조회 (로그인 용도)
     * 특정 회원 한 명만 조회하는 것이기 때문에 User 자료형 사용한다.
     *
     * @param email html -> js -> controller -> service 에서 가져온 email 값을 매개변수로 받아온다.
     * @return email을 활용한 회원 정보를 service에 전달 email 존재 유무에 따라 전달 여부를 설정한다.
     */
    User getUserByEmail(String email);
}
