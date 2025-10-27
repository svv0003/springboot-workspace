function submitUser(event) {
    event.preventDefault();

    const name = document.getElementById('name').value.trim();
    const email = document.getElementById('email').value.trim();
    const password = document.getElementById('password').value.trim();
    // input 태그 중에서 name이 role인 것 중에 check된 것을 확인하여 백엔드로 전달하는 방식
    const role = document.querySelector('input[name="role"]:checked').value.trim();
    // select - option 형태에서 id 값으로 role을 확인하여 백엔드로 전달하는 방식
    // const role = document.getElementById('role').value.trim();

    if (!name || !email || !role || !password) {
        showAlert('error', '이름과 이메일, 비밀번호, 사용자 구분을 모두 입력해주세요.');
        return;
    }

    const userData = {
        name: name,
        email: email,
        password: password,
        role: role,
    };

    const submitBtn = event.target.querySelector('.btn-submit');
    submitBtn.disabled = true;
    submitBtn.textContent = '등록 중...';

    fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
    })
        /*
        백엔드에서 처리 결과에 대해 프론트엔드로 반환할 때 사용한다.

        .then(response => {
            if (!response.ok) {
                return response.json().then(err => {
                    throw new Error(err.message || '서버 응답 오류: ' + response.status)
                }).catch(() => {
                    throw new Error('서버 응답 오류: ' + response.status)
                });
            }
            return response.json();
        })
         */
        // 아래는 백엔드 서버에서 데이터 저장 유무에 대해 프론트엔드로 응답하지 않을 경우에 사용한다.
        .then(response => {
            if (!response.ok) {
                throw new Error('서버 응답 오류: ' + response.status);
            }
            return response.text();
        })
        .then(data => {
            showAlert('success', '사용자가 성공적으로 등록되었습니다!');
            document.getElementById('userForm').reset();

            setTimeout(() => {
                if (confirm('사용자 목록을 확인하시겠습니까?')) {
                    goToList();
                }
            }, 1500);
        })
        .catch(error => {
            console.error('Error:', error);
            showAlert('error', '사용자 등록에 실패했습니다: ' + error.message);
        })
        .finally(() => {
            submitBtn.disabled = false;
            submitBtn.textContent = '등록하기';
        });
}

function showAlert(type, message) {
    const alertBox = document.getElementById('alertBox');
    const alertClass = type === 'success' ? 'alert-success' : 'alert-error';
    const icon = type === 'success' ? '✅' : '❌';

    alertBox.innerHTML = `
                <div class="alert ${alertClass}">
                    <span class="alert-icon">${icon}</span>
                    ${message}
                </div>
            `;

    setTimeout(() => {
        alertBox.innerHTML = '';
    }, 5000);

    window.scrollTo({ top: 0, behavior: 'smooth' });
}

function goToList() {
    window.location.href = '/user/list';
}