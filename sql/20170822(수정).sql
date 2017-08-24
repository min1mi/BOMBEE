-- 회원
DROP TABLE IF EXISTS MEMB RESTRICT;

-- 강사
DROP TABLE IF EXISTS TCHER RESTRICT;

-- 쪽지
DROP TABLE IF EXISTS CHAT RESTRICT;

-- 프로모션
DROP TABLE IF EXISTS PROMOTION RESTRICT;

-- 개인트레이너
DROP TABLE IF EXISTS TCHER_TRAINER RESTRICT;

-- 프로모션사진
DROP TABLE IF EXISTS PROMOTIONIMG RESTRICT;

-- 일정
DROP TABLE IF EXISTS SCHEDULE RESTRICT;

-- 회원식단관리
DROP TABLE IF EXISTS MEMB_MANAGE RESTRICT;

-- 강사리뷰
DROP TABLE IF EXISTS TCHER_REVIEW RESTRICT;

-- 좋아요
DROP TABLE IF EXISTS F_LIKE RESTRICT;

-- 알람
DROP TABLE IF EXISTS ALERT RESTRICT;
-- 회원
CREATE TABLE `MEMB` (
	`MNO`         INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`ID`          VARCHAR(50)  NOT NULL COMMENT '아이디', -- 아이디
	`EMAIL`       VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
	`ACCOUNTTYPE` INTEGER      NOT NULL COMMENT '가입유형', -- 가입유형
	`IMG`         VARCHAR(255) NULL     COMMENT '사진경로', -- 사진경로
	`PWD`         VARCHAR(255) NOT NULL COMMENT '비밀번호', -- 비밀번호
	`NAME`        VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
	`MTYPE`       INT(11)      NOT NULL COMMENT '회원유형' -- 회원유형
)
COMMENT '회원';

-- 회원
ALTER TABLE `MEMB`
	ADD CONSTRAINT `PK_MEMB` -- 회원 기본키
		PRIMARY KEY (
			`MNO` -- 회원번호
		);

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX `UIX_MEMB`
	ON `MEMB` ( -- 회원
		`ID` ASC -- 아이디
	);

-- 회원 유니크 인덱스2
CREATE UNIQUE INDEX `UIX_MEMB2`
	ON `MEMB` ( -- 회원
		`EMAIL` ASC,       -- 이메일
		`ACCOUNTTYPE` ASC  -- 가입유형
	);

ALTER TABLE `MEMB`
	MODIFY COLUMN `MNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원번호';

-- 강사
CREATE TABLE `TCHER` (
	`TNO`           INTEGER      NOT NULL COMMENT '강사회원번호', -- 강사회원번호
	`INTRODUCTION`  TEXT         NULL     COMMENT '소개', -- 소개
	`COMPANY`       VARCHAR(50)  NOT NULL COMMENT '상호명', -- 상호명
	`ZIPCODE`       VARCHAR(255) NOT NULL COMMENT '우편번호', -- 우편번호
	`COMADDR`       VARCHAR(255) NOT NULL COMMENT '근무지주소', -- 근무지주소
	`COMDETAILADDR` VARCHAR(255) NOT NULL COMMENT '상세주소', -- 상세주소
	`SPONO`         INTEGER      NULL     COMMENT '운동명' -- 운동명
)
COMMENT '강사';

-- 강사
ALTER TABLE `TCHER`
	ADD CONSTRAINT `PK_TCHER` -- 강사 기본키
		PRIMARY KEY (
			`TNO` -- 강사회원번호
		);

-- 쪽지
CREATE TABLE `CHAT` (
	`CNO`     INTEGER      NOT NULL COMMENT '채팅번호', -- 채팅번호
	`MNO`     INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`TNO`     INTEGER      NOT NULL COMMENT '강사회원번호', -- 강사회원번호
	`WHOSEND` INTEGER      NOT NULL COMMENT '보낸사람', -- 보낸사람
	`MSG`     TEXT         NOT NULL COMMENT '메세지', -- 메세지
	`DATE`    VARCHAR(255) NOT NULL COMMENT '일시', -- 일시
	`CONFIRM` BOOLEAN      NOT NULL COMMENT '읽은여부' -- 읽은여부
)
COMMENT '쪽지';

-- 쪽지
ALTER TABLE `CHAT`
	ADD CONSTRAINT `PK_CHAT` -- 쪽지 Primary key
		PRIMARY KEY (
			`CNO` -- 채팅번호
		);

ALTER TABLE `CHAT`
	MODIFY COLUMN `CNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '채팅번호';

-- 프로모션
CREATE TABLE `PROMOTION` (
	`PNO`     INTEGER      NOT NULL COMMENT '프로모션 번호', -- 프로모션 번호
	`TITL`    VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
	`PRIC`    INTEGER      NOT NULL COMMENT '가격', -- 가격
	`CONTENT` VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
	`SDT`     VARCHAR(255) NOT NULL COMMENT '시작날짜', -- 시작날짜
	`EDT`     VARCHAR(255) NOT NULL COMMENT '종료날짜', -- 종료날짜
	`TNO`     INTEGER      NOT NULL COMMENT '강사회원번호', -- 강사회원번호
	`lat`     DOUBLE       NULL     COMMENT '위도', -- 위도
	`lng`     DOUBLE       NULL     COMMENT '경도' -- 경도
)
COMMENT '프로모션';

-- 프로모션
ALTER TABLE `PROMOTION`
	ADD CONSTRAINT `PK_PROMOTION` -- 프로모션 기본키
		PRIMARY KEY (
			`PNO` -- 프로모션 번호
		);

ALTER TABLE `PROMOTION`
	MODIFY COLUMN `PNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로모션 번호';

-- 개인트레이너
CREATE TABLE `TCHER_TRAINER` (
	`TRANO`    INTEGER      NOT NULL COMMENT '개인트레이너일련번호', -- 개인트레이너일련번호
	`MNO`      INTEGER      NOT NULL COMMENT '회원번호', -- 회원번호
	`TNO`      INTEGER      NOT NULL COMMENT '강사회원번호', -- 강사회원번호
	`PNO`      INTEGER      NOT NULL COMMENT '프로모션 번호', -- 프로모션 번호
	`SDT`      VARCHAR(255) NOT NULL COMMENT '시작일', -- 시작일
	`EDT`      VARCHAR(255) NOT NULL COMMENT '종료일', -- 종료일
	`PERIOD`   INTEGER      NOT NULL COMMENT '기간', -- 기간
	`CONFIRM`  BOOLEAN      NOT NULL COMMENT '수락여부', -- 수락여부
	`REQDATE`  VARCHAR(255) NOT NULL COMMENT '요청날짜', -- 요청날짜
	`WISHTIME` INTEGER      NOT NULL COMMENT '원하는타임', -- 원하는타임
	`WRITEREV` BOOLEAN      NULL     COMMENT '리뷰작성' -- 리뷰작성
)
COMMENT '개인트레이너';

-- 개인트레이너
ALTER TABLE `TCHER_TRAINER`
	ADD CONSTRAINT `PK_TCHER_TRAINER` -- 개인트레이너 기본키
		PRIMARY KEY (
			`TRANO` -- 개인트레이너일련번호
		);

-- 개인트레이너 유니크 인덱스
CREATE UNIQUE INDEX `UIX_TCHER_TRAINER`
	ON `TCHER_TRAINER` ( -- 개인트레이너
	);

ALTER TABLE `TCHER_TRAINER`
	MODIFY COLUMN `TRANO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '개인트레이너일련번호';

-- 프로모션사진
CREATE TABLE `PROMOTIONIMG` (
	`IMGNO`    INTEGER      NOT NULL COMMENT '프로모션사진일련번호', -- 프로모션사진일련번호
	`PNO`      INTEGER      NOT NULL COMMENT '프로모션 번호', -- 프로모션 번호
	`PIMG`     VARCHAR(255) NOT NULL COMMENT '사진경로', -- 사진경로
	`titlePic` BOOLEAN      NULL     COMMENT '타이틀사진유무' -- 타이틀사진유무
)
COMMENT '프로모션사진';

-- 프로모션사진
ALTER TABLE `PROMOTIONIMG`
	ADD CONSTRAINT `PK_PROMOTIONIMG` -- 프로모션사진 기본키
		PRIMARY KEY (
			`IMGNO` -- 프로모션사진일련번호
		);

ALTER TABLE `PROMOTIONIMG`
	MODIFY COLUMN `IMGNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '프로모션사진일련번호';

-- 일정
CREATE TABLE `SCHEDULE` (
	`SCHNO` INTEGER      NOT NULL COMMENT '일정번호', -- 일정번호
	`TNO`   INTEGER      NOT NULL COMMENT '강사회원번호', -- 강사회원번호
	`DAY`   VARCHAR(255) NOT NULL COMMENT '요일', -- 요일
	`TIME`  VARCHAR(255) NOT NULL COMMENT '시간' -- 시간
)
COMMENT '일정';

-- 일정
ALTER TABLE `SCHEDULE`
	ADD CONSTRAINT `PK_SCHEDULE` -- 일정 기본키
		PRIMARY KEY (
			`SCHNO` -- 일정번호
		);

-- 일정 유니크 인덱스
CREATE UNIQUE INDEX `UIX_SCHEDULE`
	ON `SCHEDULE` ( -- 일정
		`TNO` ASC,  -- 강사회원번호
		`DAY` ASC,  -- 요일
		`TIME` ASC  -- 시간
	);

ALTER TABLE `SCHEDULE`
	MODIFY COLUMN `SCHNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '일정번호';

-- 회원식단관리
CREATE TABLE `MEMB_MANAGE` (
	`MEALNO`   INTEGER      NOT NULL COMMENT '회원식단일련번호', -- 회원식단일련번호
	`MEALTYPE` VARCHAR(255) NOT NULL COMMENT '끼니', -- 끼니
	`MEALPIC`  VARCHAR(255) NOT NULL COMMENT '식단사진', -- 식단사진
	`MEALKCAL` INTEGER      NOT NULL COMMENT '칼로리', -- 칼로리
	`MEALNAME` VARCHAR(50)  NOT NULL COMMENT '식단이름', -- 식단이름
	`DATE`     DATE         NOT NULL COMMENT '날짜', -- 날짜
	`DAY`      VARCHAR(255) NOT NULL COMMENT '요일별명', -- 요일별명
	`CONFIRM`  BOOLEAN      NOT NULL COMMENT '확인여부', -- 확인여부
	`TRANO`    INTEGER      NOT NULL COMMENT '개인트레이너일련번호' -- 개인트레이너일련번호
)
COMMENT '회원식단관리';

-- 회원식단관리
ALTER TABLE `MEMB_MANAGE`
	ADD CONSTRAINT `PK_MEMB_MANAGE` -- 회원식단관리 기본키
		PRIMARY KEY (
			`MEALNO` -- 회원식단일련번호
		);

ALTER TABLE `MEMB_MANAGE`
	MODIFY COLUMN `MEALNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '회원식단일련번호';

-- 강사리뷰
CREATE TABLE `TCHER_REVIEW` (
	`REVIEWNO` INTEGER NOT NULL COMMENT '강사리뷰번호', -- 강사리뷰번호
	`TRANO`    INTEGER NOT NULL COMMENT '개인트레이너일련번호', -- 개인트레이너일련번호
	`SCORE`    INTEGER NOT NULL COMMENT '평점', -- 평점
	`REVIEW`   TEXT    NULL     COMMENT '코멘트' -- 코멘트
)
COMMENT '강사리뷰';

-- 강사리뷰
ALTER TABLE `TCHER_REVIEW`
	ADD CONSTRAINT `PK_TCHER_REVIEW` -- 강사리뷰 기본키
		PRIMARY KEY (
			`REVIEWNO` -- 강사리뷰번호
		);

ALTER TABLE `TCHER_REVIEW`
	MODIFY COLUMN `REVIEWNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '강사리뷰번호';

-- 좋아요
CREATE TABLE `F_LIKE` (
	`TNO` INTEGER NOT NULL COMMENT '강사회원번호', -- 강사회원번호
	`MNO` INTEGER NOT NULL COMMENT '회원번호' -- 회원번호
)
COMMENT '좋아요';

-- 좋아요
ALTER TABLE `F_LIKE`
	ADD CONSTRAINT `PK_F_LIKE` -- 좋아요 기본키
		PRIMARY KEY (
			`TNO`, -- 강사회원번호
			`MNO`  -- 회원번호
		);

-- 친구
CREATE TABLE `TABLE` (
	`COL2` <데이터 타입 없음> NULL     COMMENT '친구번호', -- 친구번호
	`MNO`  INTEGER            NULL     COMMENT '회원번호', -- 회원번호
	`TNO`  INTEGER            NOT NULL COMMENT '강사회원번호', -- 강사회원번호
	`COL`  <데이터 타입 없음> NULL     COMMENT '수락여부' -- 수락여부
)
COMMENT '친구';

ALTER TABLE `TABLE`
	MODIFY COLUMN `COL2` <데이터 타입 없음> NULL AUTO_INCREMENT COMMENT '친구번호';

-- 알람
CREATE TABLE `ALERT` (
	`ALNO`      INTEGER      NOT NULL COMMENT '알람일련번호', -- 알람일련번호
	`OTHERNAME` VARCHAR(50)  NOT NULL COMMENT '누가', -- 누가
	`MYMNO`     INTEGER      NOT NULL COMMENT '누구한테', -- 누구한테
	`KINDS`     VARCHAR(255) NOT NULL COMMENT '무엇을', -- 무엇을
	`DATE`      VARCHAR(50)  NOT NULL COMMENT '시간', -- 시간
	`CONFIRM`   BOOLEAN      NOT NULL COMMENT '확인여부', -- 확인여부
	`TYPE`      INTEGER      NOT NULL COMMENT '유형' -- 유형
)
COMMENT '알람';

-- 알람
ALTER TABLE `ALERT`
	ADD CONSTRAINT `PK_ALERT` -- 알람 기본키
		PRIMARY KEY (
			`ALNO` -- 알람일련번호
		);

ALTER TABLE `ALERT`
	MODIFY COLUMN `ALNO` INTEGER NOT NULL AUTO_INCREMENT COMMENT '알람일련번호';

-- 강사
ALTER TABLE `TCHER`
	ADD CONSTRAINT `FK_MEMB_TO_TCHER` -- 회원 -> 강사
		FOREIGN KEY (
			`TNO` -- 강사회원번호
		)
		REFERENCES `MEMB` ( -- 회원
			`MNO` -- 회원번호
		);

-- 쪽지
ALTER TABLE `CHAT`
	ADD CONSTRAINT `FK_MEMB_TO_CHAT` -- 회원 -> 쪽지
		FOREIGN KEY (
			`MNO` -- 회원번호
		)
		REFERENCES `MEMB` ( -- 회원
			`MNO` -- 회원번호
		);

-- 쪽지
ALTER TABLE `CHAT`
	ADD CONSTRAINT `FK_TCHER_TO_CHAT` -- 강사 -> 쪽지
		FOREIGN KEY (
			`TNO` -- 강사회원번호
		)
		REFERENCES `TCHER` ( -- 강사
			`TNO` -- 강사회원번호
		);

-- 프로모션
ALTER TABLE `PROMOTION`
	ADD CONSTRAINT `FK_TCHER_TO_PROMOTION` -- 강사 -> 프로모션
		FOREIGN KEY (
			`TNO` -- 강사회원번호
		)
		REFERENCES `TCHER` ( -- 강사
			`TNO` -- 강사회원번호
		);

-- 개인트레이너
ALTER TABLE `TCHER_TRAINER`
	ADD CONSTRAINT `FK_MEMB_TO_TCHER_TRAINER` -- 회원 -> 개인트레이너
		FOREIGN KEY (
			`MNO` -- 회원번호
		)
		REFERENCES `MEMB` ( -- 회원
			`MNO` -- 회원번호
		);

-- 개인트레이너
ALTER TABLE `TCHER_TRAINER`
	ADD CONSTRAINT `FK_TCHER_TO_TCHER_TRAINER` -- 강사 -> 개인트레이너
		FOREIGN KEY (
			`TNO` -- 강사회원번호
		)
		REFERENCES `TCHER` ( -- 강사
			`TNO` -- 강사회원번호
		);

-- 개인트레이너
ALTER TABLE `TCHER_TRAINER`
	ADD CONSTRAINT `FK_PROMOTION_TO_TCHER_TRAINER` -- 프로모션 -> 개인트레이너
		FOREIGN KEY (
			`PNO` -- 프로모션 번호
		)
		REFERENCES `PROMOTION` ( -- 프로모션
			`PNO` -- 프로모션 번호
		);

-- 프로모션사진
ALTER TABLE `PROMOTIONIMG`
	ADD CONSTRAINT `FK_PROMOTION_TO_PROMOTIONIMG` -- 프로모션 -> 프로모션사진
		FOREIGN KEY (
			`PNO` -- 프로모션 번호
		)
		REFERENCES `PROMOTION` ( -- 프로모션
			`PNO` -- 프로모션 번호
		);

-- 일정
ALTER TABLE `SCHEDULE`
	ADD CONSTRAINT `FK_TCHER_TO_SCHEDULE` -- 강사 -> 일정
		FOREIGN KEY (
			`TNO` -- 강사회원번호
		)
		REFERENCES `TCHER` ( -- 강사
			`TNO` -- 강사회원번호
		);

-- 회원식단관리
ALTER TABLE `MEMB_MANAGE`
	ADD CONSTRAINT `FK_TCHER_TRAINER_TO_MEMB_MANAGE` -- 개인트레이너 -> 회원식단관리
		FOREIGN KEY (
			`TRANO` -- 개인트레이너일련번호
		)
		REFERENCES `TCHER_TRAINER` ( -- 개인트레이너
			`TRANO` -- 개인트레이너일련번호
		);

-- 강사리뷰
ALTER TABLE `TCHER_REVIEW`
	ADD CONSTRAINT `FK_TCHER_TRAINER_TO_TCHER_REVIEW` -- 개인트레이너 -> 강사리뷰
		FOREIGN KEY (
			`TRANO` -- 개인트레이너일련번호
		)
		REFERENCES `TCHER_TRAINER` ( -- 개인트레이너
			`TRANO` -- 개인트레이너일련번호
		);

-- 좋아요
ALTER TABLE `F_LIKE`
	ADD CONSTRAINT `FK_TCHER_TO_F_LIKE` -- 강사 -> 좋아요
		FOREIGN KEY (
			`TNO` -- 강사회원번호
		)
		REFERENCES `TCHER` ( -- 강사
			`TNO` -- 강사회원번호
		);

-- 좋아요
ALTER TABLE `F_LIKE`
	ADD CONSTRAINT `FK_MEMB_TO_F_LIKE` -- 회원 -> 좋아요
		FOREIGN KEY (
			`MNO` -- 회원번호
		)
		REFERENCES `MEMB` ( -- 회원
			`MNO` -- 회원번호
		);

-- 친구
ALTER TABLE `TABLE`
	ADD CONSTRAINT `FK_MEMB_TO_TABLE` -- 회원 -> 친구
		FOREIGN KEY (
			`MNO` -- 회원번호
		)
		REFERENCES `MEMB` ( -- 회원
			`MNO` -- 회원번호
		);

-- 친구
ALTER TABLE `TABLE`
	ADD CONSTRAINT `FK_TCHER_TO_TABLE` -- 강사 -> 친구
		FOREIGN KEY (
			`TNO` -- 강사회원번호
		)
		REFERENCES `TCHER` ( -- 강사
			`TNO` -- 강사회원번호
		);