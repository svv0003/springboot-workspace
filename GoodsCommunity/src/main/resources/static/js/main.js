/* Cookie에서 Key가 일치하는 Value 얻어오기 함수 (=기능) */

// Cookie -> K=V, K=V 형식
// 배열.map(함수) : 배열의 각 요소를 이용해 함수 수행 후 결과 값으로 새로운 배열을 만들어서 반환한다.

const getCookie = key => {
    const cookies = document.cookie;

    const cookieList = cookies.split(";").map(el => el.trim().split("="))

    const obj = {}; // 비어있는 객체로 선언한다.

    for (let i=0; i<cookieList.length; i++) {
        const K=cookieList[i][0].trim();     // key 값
        const V = cookieList[i][1];          // value 값
        obj[K]=V;                                   // 객체에 추가한다.
    }
    return obj[key];    // 매개변수로 전달받은 key와 obj 객체에 저장된 키가 일치하는 요소의 값을 반환한다.

}

// id 값이 loginForm인 태그 내부에 input에서 name 명칭이 memberEmail인 태그의 값을
// loginEmail이라는 변수명에 담는다.
const loginEmail = document.querySelector("#loginForm input[name='memberEmail']");


// 로그인이 안 된 상태인 경우에만 수행한다.
if (loginEmail != null) {

    const saveId = getCookie("saveId"); // undefined 또는 이메일이 올 것이다.
    // saveId 값이 존재할 경우
    // 쿠키에서 saveId라는 키 명칭에 멤버이메일 데이터가 value 값으로 저장되어 있다.
    if (saveId != undefined) {
        // 쿠키에서 얻어온 값을 input에 value 값으로 세팅한다.
        loginEmail.value = saveId;
        // 아이디 저장 체크박스에 체크해두기
        document.querySelector("input[name='saveId']").checked = true;
    }
}


// 이메일 비밀번호 미작성 시 로그인 막기
const loginForm = document.querySelector("#loginForm");

const loginPw = document.querySelector("#loginForm input[name='memberPassword']")

if (loginForm != null) {
    //로그인 버튼을 클릭해서 form 내부에 작성한 내용을 제출한다는 동작이 발생한 경우 (button 기본값은 submit)
    loginForm.addEventListener("submit", e => {

        // 이메일 미작성한 경우
        if (loginEmail.value.trim().length === 0) {
            alert ("이메일을 작성해주세요.");
            e.preventDefault(); // 기본 제출 막기
            loginEmail.focus(); // 작성 안 된 곳으로 초점 이동하기
            return;
        }

        // 비밀번호 미작성한 경우
        if (loginPw.value.trim().length === 0) {
            alert ("비밀번호를 작성해주세요.");
            e.preventDefault(); // 기본 제출 막기
            loginPw.focus(); // 작성 안 된 곳으로 초점 이동하기
            return;
        }
    })
}