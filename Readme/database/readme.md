- DB table

<img src="./ReadmeImage/database/테이블구조1.PNG">

| ACCOUNT MEMB 테이블(일반 사용자)|||
| :-----: | :-: |:-: |
| MNO **`(PK)`**	|회원번호	|INTEGER NOT NULL|
| ID	| 아이디		| VARCHAR(50)	NOT NULL|
| EMAIL	| 이메일		| VARCHAR(50)	NOT NULL|
| ACCOUNTTYPE	| 가입유형		|INTEGER	NOT NULL|
| IMG	| 사진경로	| VARCHAR(255) |
| MTYPE	| 사용자 타입	| INT(11)	NOT NULL|
| NAME	|이름		| VARCHAR(255)	NOT NULL|
| PASSWORD	|비번		| VARCHAR(255)	NOT NULL|

| ACCOUNT TCHER 테이블(트레이너)|||
| :-----: | :-: |:-: |
| TNO **`(PK)`**	|회원번호	|INTEGER NOT NULL|
| INTRODUCTION | 소개	| VARCHAR(255) |
| COMPANY	| 회사명	| VARCHAR(50)	NOT NULL|
| ZIPCODE	| 우편번호	| VARCHAR(255)	NOT NULL|
| COMADDR	| 회사주소	| VARCHAR(255) NOT NULL|
| COMDETAILADDR	| 상세주소	| VARCHAR(255)	NOT NULL|
| SPONO	| 운동번호	| INTEGER |


| PROMOTION 테이블(프로모션)|||
| :-----: | :-: |:-: |
| PNO **`(PK)`**	| 프로모션 번호	| INTEGER NOT NULL	|
| TNO **`(FK)`** | 강사 번호	| INTEGER	NOT NULL|
| TITL	| 타이틀	| VARCHAR(50)	NOT NULL|
| CONTENT | 프로모션 내용	| TEXT	NOT NULL|
| SDT	| 프로모션 시작일	|VARCHAR(255) NOT NULL|
| EDT	| 프로모션 종료일	|VARCHAR(255) NOT NULL|
| PRIC	| 가격	| INTEGER NOT NULL|
| LAT	| 위도	| DOUBLE |
| LNG	| 경도	| DOUBLE |
| EXPIRE	| 만료 여부	| INTEGER |

| PROMOTIONIMG 테이블(프로모션 이미지)|||
| :-----: | :-: |:-: |
| IMGNO **`(PK)`**	| 이미지 번호	| INTEGER NOT NULL	|
| PNO **`(FK)`** | 프로모션 번호	| INTEGER	NOT NULL|
| PIMG	| 이미지 경로	| VARCHAR(255)	NOT NULL|
| TITLEPIC	| 타이틀 사진 여부	| BOOLEAN |

| MEMB_MANAGE 테이블(진행 프로모션)|||
| :-----: | :-: |:-: |
| MEALNO **`(PK)`**	| 진행 프로모션 번호	| INTEGER NOT NULL	|
| TRANO	**`(FK)`**| 연결된 개인트레이너 번호	| INTEGER NOT NULL|
| MEALTYPE | 끼니	| VARCHAR(255)	NOT NULL|
| MEALPIC | 끼니 사진	경로 | VARCHAR(255)	NOT NULL	|
| MEALCAL	| 칼로리	| INTEGER NOT NULL |
| MEALNAME	| 식단 이름	| VARCHAR(255)	NOT NULL |
| DATE	| 일시	| DATE NOT NULL |
| DAY	| 요일 	| VARCHAR(255) NOT NULL |
| CONFIRM	| 확인 여부 	| BOOLEAN NOT NULL |


| TCHER_TRAINER 테이블(매칭시 개인트레이너)|||
| :-----: | :-: |:-: |
| TRANO **`(PK)`**	| 연결된 개인트레이너 번호	| INTEGER NOT NULL	|
| MNO	**`(FK)`**| 연결된 멤버 번호	| INTEGER NOT NULL|
| TNO	**`(FK)`**| 연결된 강사 번호	| INTEGER NOT NULL|
| PNO	**`(FK)`**| 연결된 프로모션 번호	| INTEGER NOT NULL|
| SDT	| 프로모션 시작일	|VARCHAR(255) NOT NULL|
| EDT	| 프로모션 종료일	|VARCHAR(255) NOT NULL|
| PERIOD	| 신청 개월 수		| INTEGER	|
| CONFIRM	| 확인 여부 	| BOOLEAN NOT NULL |
| REQDATE	| 요청 날짜	| DATE NOT NULL	|
| WISHTIME	| 원하는 시간	| INTEGER NOT NULL	|
| WRITEREV	| 리뷰 여부	| BOOLEAN	NOT NULL|
| TITLE		|제목			| VARCHAR(255) NOT NULL	|

| ALERT 테이블(알람)|||
| :-----: | :-: |:-: |
| ALNO **`(PK)`**	| 알람 번호	| INTEGER NOT NULL|
| OTHERNAME | 상대방 이름	| VARCHAR(255) NOT NULL|
| MYMNO | 요청한 사람 회원번호	| INTEGER	NOT NULL|
| KINDS | 알람 종류 | VARCHAR(255)	NOT NULL|
| DATE | 알람 발생 날짜 | VARCHAR(50)	NOT NULL|
| CONFIRM	| 확인 여부 	| BOOLEAN NOT NULL |
| TYPE | 알람 종류 분류	| INTEGER NOT NULL |
| OTHERMNO | 상대방 사용자 번호	| INTEGER NOT NULL |

| SCHEDULE 테이블(강사 스케줄)|||
| :-----: | :-: |:-: |
| SCHNO **`(PK)`**	| 스케쥴 번호	| INTEGER NOT NULL|
| TNO	**`(FK)`**| 강사 번호	| INTEGER NOT NULL|
| DAY | 요일	| VARCHAR(255)	NOT NULL|
| TIME | 시간 | VARCHAR(255)	NOT NULL|

| TCHER_REVIEW 테이블(리뷰)|||
| :-----: | :-: |:-: |
| REVIEWNO **`(PK)`**	| 리뷰 번호	| INTEGER NOT NULL|
| TRANO **`(FK)`**| 연결된 개인트레이너 번호	| INTEGER NOT NULL|
| SCORE | 평점	| INTEGER	NOT NULL|
| PNO | 연결된 프로모션 번호 | INTEGER	NOT NULL|
| PROTITL | 연결된 프로모션 타이틀 | VARCHAR(255)	NOT NULL|
| DATE | 리뷰 작성 날짜	| VARCHAR(255) NOT NULL|

| CHAT 테이블(채팅)|||
| :-----: | :-: |:-: |
| CNO **`(PK)`**| 채팅 번호	| INTEGER NOT NULL|
| MNO	**`(FK)`**| 멤버 번호	| INTEGER NOT NULL|
| TNO	**`(FK)`**| 강사 번호	| INTEGER NOT NULL|
| WHOSEND | 보낸 사람	| INTEGER	NOT NULL|
| MSG | 메세지	| TEXT	NOT NULL|
| CONFIRM | 확인 여부 | BOOLEAN NOT NULL|
