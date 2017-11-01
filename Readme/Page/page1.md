# 1. 회원가입 / 로그인

## 페이지 소개
* 회원가입 및 로그인 페이지입니다.
<br><br>
## 구동원리
* 필수 항목 미 입력시 표시 및 회원가입 미처리
* Daum 우편번호 서비스를 이용하여 트레이너 회원가입 시 트레이닝 센터 위치를 입력받음
* SNS 로그인 시 일반회원으로 회원가입 처리
* 로그인시 DB의 정보와 맞지 않을시 로그인 실패 알림창 처리 (SweetAlert)
* 로그인 후 네비게이터바에서 프로필 사진 업로드 시 미리보기 이미지 생성 (blue-imp-fileupload)
* 사진 업로드시 서버에서 썸네일 처리 (thumbnailator)
<br><br>
## 화면
- Login

<img src="Readme/Image/봄비메인.jpg" width="250">

- Sign Up

<img src="./Readme/Image/회원가입1.jpg" width="250"> <img src="./Readme/Image/회원가입2.jpg" width="250">
<br><br>
## 사용기술
* JavaScript libraies : blue-imp-fileupload, jQuery-Ui,  SweetAlert2
* Java library : thumbnailator<br>
* Api : Daum 우편번호 서비스<br>

## [BOMBEE (돌아가기)](https://github.com/min1mi/BOMBEE)<br>
