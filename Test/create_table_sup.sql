/* 회원 */
CREATE TABLE sup.member (
	member_id VARCHAR2(20) NOT NULL, /* 회원 id */
	member_password VARCHAR2(15) NOT NULL, /* 비밀번호 */
	member_name VARCHAR2(30) NOT NULL, /* 이름 */
	member_gender VARCHAR2(10) NOT NULL, /* 성별 */
	member_birthday DATE NOT NULL, /* 생년월일 */
	member_email VARCHAR2(30) NOT NULL, /* 이메일 */
	member_phone VARCHAR2(30) NOT NULL, /* 전화번호 */
	member_activated CHAR(1) NOT NULL, /* 활성화 구분 */
	member_code CHAR(1) NOT NULL, /* 회원 구분 */
	member_business_id VARCHAR2(30), /* 사업자등록번호 */
	member_address VARCHAR2(200), /* 주소 */
	member_account VARCHAR2(30), /* 계좌번호 */
	member_terms CHAR(1) NOT NULL, /* 약관동의여부 */
	member_date DATE NOT NULL /* 가입 일자 */
);

COMMENT ON TABLE sup.member IS '회원';

COMMENT ON COLUMN sup.member.member_id IS '회원 id';

COMMENT ON COLUMN sup.member.member_password IS '비밀번호';

COMMENT ON COLUMN sup.member.member_name IS '이름';

COMMENT ON COLUMN sup.member.member_gender IS '성별';

COMMENT ON COLUMN sup.member.member_birthday IS '생년월일';

COMMENT ON COLUMN sup.member.member_email IS '이메일';

COMMENT ON COLUMN sup.member.member_phone IS '전화번호';

COMMENT ON COLUMN sup.member.member_activated IS '활성화 구분';

COMMENT ON COLUMN sup.member.member_code IS '회원 구분';

COMMENT ON COLUMN sup.member.member_business_id IS '사업자등록번호';

COMMENT ON COLUMN sup.member.member_address IS '주소';

COMMENT ON COLUMN sup.member.member_account IS '계좌번호';

COMMENT ON COLUMN sup.member.member_terms IS '약관동의여부';

COMMENT ON COLUMN sup.member.member_date IS '가입 일자';

CREATE UNIQUE INDEX sup.PK_member
	ON sup.member (
		member_id ASC
	);

ALTER TABLE sup.member
	ADD
		CONSTRAINT PK_member
		PRIMARY KEY (
			member_id
		);

/* 상품 */
CREATE TABLE sup.product (
	product_id NUMBER(38) NOT NULL, /* 상품 아이디 */
	member_id VARCHAR2(20) NOT NULL, /* 판매자 id */
	product_name VARCHAR2(50) NOT NULL, /* 상품 이름 */
	product_img VARCHAR2(50) NOT NULL, /* 상품 이미지 */
	product_price NUMBER(38) NOT NULL, /* 상품 가격 */
	product_brand VARCHAR2(100), /* 상품 브랜드 */
	product_detail VARCHAR2(4000) NOT NULL, /* 상품 상세설명 */
	product_category VARCHAR2(100) NOT NULL, /* 상품 형태(카테고리) */
	product_quantity NUMBER(38) NOT NULL, /* 상품 수량 */
	product_activated CHAR(1) NOT NULL, /* 활성화 구분 */
	product_date DATE NOT NULL /* 업데이트 일자 */
);

COMMENT ON TABLE sup.product IS '상품';

COMMENT ON COLUMN sup.product.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.product.member_id IS '판매자 id';

COMMENT ON COLUMN sup.product.product_name IS '상품 이름';

COMMENT ON COLUMN sup.product.product_img IS '상품 이미지';

COMMENT ON COLUMN sup.product.product_price IS '상품 가격';

COMMENT ON COLUMN sup.product.product_brand IS '상품 브랜드';

COMMENT ON COLUMN sup.product.product_detail IS '상품 상세설명';

COMMENT ON COLUMN sup.product.product_category IS '상품 형태(카테고리)';

COMMENT ON COLUMN sup.product.product_quantity IS '상품 수량';

COMMENT ON COLUMN sup.product.product_activated IS '활성화 구분';

COMMENT ON COLUMN sup.product.product_date IS '업데이트 일자';

CREATE UNIQUE INDEX sup.PK_product
	ON sup.product (
		product_id ASC
	);

ALTER TABLE sup.product
	ADD
		CONSTRAINT PK_product
		PRIMARY KEY (
			product_id
		);

/* 구매 */
CREATE TABLE sup.purchase (
	purchase_id NUMBER(38) NOT NULL, /* 구매 번호 */
	product_id NUMBER(38) NOT NULL, /* 상품 아이디 */
	sender_id VARCHAR2(20) NOT NULL, /* 선물한사람ID */
	recepient_id VARCHAR2(20) NOT NULL, /* 선물받은사람ID */
	purchase_state CHAR(1) NOT NULL, /* 주문 상태(사용/미사용/거절) */
	purchase_date DATE NOT NULL /* 구매 날짜 */
);

COMMENT ON TABLE sup.purchase IS '구매';

COMMENT ON COLUMN sup.purchase.purchase_id IS '구매 번호';

COMMENT ON COLUMN sup.purchase.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.purchase.sender_id IS '선물한사람ID';

COMMENT ON COLUMN sup.purchase.recepient_id IS '선물받은사람ID';

COMMENT ON COLUMN sup.purchase.purchase_state IS '주문 상태(사용/미사용/거절)';

COMMENT ON COLUMN sup.purchase.purchase_date IS '구매 날짜';

CREATE UNIQUE INDEX sup.PK_purchase
	ON sup.purchase (
		purchase_id ASC
	);

ALTER TABLE sup.purchase
	ADD
		CONSTRAINT PK_purchase
		PRIMARY KEY (
			purchase_id
		);


/* 친구관계목록 */
CREATE TABLE sup.friend (
	member_id VARCHAR2(20) NOT NULL, /* 회원 id */
	friend_list VARCHAR2(4000) NOT NULL, /* 친구들 */
	friend_date DATE NOT NULL /* 갱신 날짜 */
);

COMMENT ON TABLE sup.friend IS '친구관계목록';

COMMENT ON COLUMN sup.friend.member_id IS '회원 id';

COMMENT ON COLUMN sup.friend.friend_list IS '친구들';

COMMENT ON COLUMN sup.friend.friend_date IS '갱신 날짜';

CREATE UNIQUE INDEX sup.PK_friend
	ON sup.friend (
		member_id ASC
	);

ALTER TABLE sup.friend
	ADD
		CONSTRAINT PK_friend
		PRIMARY KEY (
			member_id
		);
/* 신고 */
CREATE TABLE sup.report (
	report_id NUMBER(38) NOT NULL, /* 신고 기본키 */
	sender_id VARCHAR2(20) NOT NULL, /* 보낸사람 */
	recepient_id VARCHAR2(20) NOT NULL, /* 받는사람 */
	product_id NUMBER(38), /* 상품 아이디 */
	post_id NUMBER(38), /* 글 아이디 */
	report_content VARCHAR2(4000) NOT NULL, /* 신고 내용 */
	prev_report_id NUMBER(38), /* 이전 신고 아이디 */
	report_checked CHAR(1) NOT NULL, /* 글확인여부 */
	report_date DATE NOT NULL /* 신고 날짜 */
);

COMMENT ON TABLE sup.report IS '신고';

COMMENT ON COLUMN sup.report.report_id IS '신고 기본키';

COMMENT ON COLUMN sup.report.sender_id IS '보낸사람';

COMMENT ON COLUMN sup.report.recepient_id IS '받는사람';

COMMENT ON COLUMN sup.report.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.report.post_id IS '글 아이디';

COMMENT ON COLUMN sup.report.report_content IS '신고 내용';

COMMENT ON COLUMN sup.report.prev_report_id IS '이전 신고 아이디';

COMMENT ON COLUMN sup.report.report_checked IS '글확인여부';

COMMENT ON COLUMN sup.report.report_date IS '신고 날짜';

CREATE UNIQUE INDEX sup.PK_report
	ON sup.report (
		report_id ASC
	);

ALTER TABLE sup.report
	ADD
		CONSTRAINT PK_report
		PRIMARY KEY (
			report_id
		);

/* 글 */
CREATE TABLE sup.post (
	post_id NUMBER(38) NOT NULL, /* 글 아이디 */
	product_id NUMBER(38) NOT NULL, /* 상품 아이디 */
	member_id VARCHAR2(20) NOT NULL, /* 작성자 id */
	post_content VARCHAR2(4000) NOT NULL, /* 글 내용 */
	post_shared_range CHAR(1) NOT NULL, /* 공유 범위 */
	post_like_count NUMBER(38) NOT NULL, /* 글 좋아요 수 */
	post_date DATE NOT NULL /* 작성 날짜 */
);

COMMENT ON TABLE sup.post IS '글';

COMMENT ON COLUMN sup.post.post_id IS '글 아이디';

COMMENT ON COLUMN sup.post.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.post.member_id IS '작성자 id';

COMMENT ON COLUMN sup.post.post_content IS '글 내용';

COMMENT ON COLUMN sup.post.post_shared_range IS '공유 범위';

COMMENT ON COLUMN sup.post.post_like_count IS '글 좋아요 수';

COMMENT ON COLUMN sup.post.post_date IS '작성 날짜';

CREATE UNIQUE INDEX sup.PK_post
	ON sup.post (
		post_id ASC
	);

ALTER TABLE sup.post
	ADD
		CONSTRAINT PK_post
		PRIMARY KEY (
			post_id
		);

/* 글 좋아요 */
CREATE TABLE sup.like_post (
	like_post_id NUMBER(38) NOT NULL, /* 좋아요 기본키 */
	post_id NUMBER(38) NOT NULL, /* 글 아이디 */
	member_id VARCHAR2(20) NOT NULL, /* 좋아요한 회원 id */
	like_post_date DATE NOT NULL /* 좋아요 날짜 */
);

COMMENT ON TABLE sup.like_post IS '글 좋아요';

COMMENT ON COLUMN sup.like_post.like_post_id IS '좋아요 기본키';

COMMENT ON COLUMN sup.like_post.post_id IS '글 아이디';

COMMENT ON COLUMN sup.like_post.member_id IS '좋아요한 회원 id';

COMMENT ON COLUMN sup.like_post.like_post_date IS '좋아요 날짜';

CREATE UNIQUE INDEX sup.PK_like_post
	ON sup.like_post (
		like_post_id ASC
	);

ALTER TABLE sup.like_post
	ADD
		CONSTRAINT PK_like_post
		PRIMARY KEY (
			like_post_id
		);

/* 상품 좋아요 */
CREATE TABLE sup.like_product (
	like_product_id NUMBER(38) NOT NULL, /* 기본키 */
	product_id NUMBER(38) NOT NULL, /* 상품 아이디 */
	member_id VARCHAR2(20) NOT NULL, /* 좋아요한 id */
	like_product_date DATE NOT NULL /* 좋아요 날짜 */
);

COMMENT ON TABLE sup.like_product IS '상품 좋아요';

COMMENT ON COLUMN sup.like_product.like_product_id IS '기본키';

COMMENT ON COLUMN sup.like_product.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.like_product.member_id IS '좋아요한 id';

COMMENT ON COLUMN sup.like_product.like_product_date IS '좋아요 날짜';

CREATE UNIQUE INDEX sup.PK_like_product
	ON sup.like_product (
		like_product_id ASC
	);

ALTER TABLE sup.like_product
	ADD
		CONSTRAINT PK_like_product
		PRIMARY KEY (
			like_product_id
		);

/* 위시리스트 */
CREATE TABLE sup.wishlist (
	wishlist_id NUMBER(38) NOT NULL, /* 기본키 */
	product_id NUMBER(38) NOT NULL, /* 상품 아이디 */
	member_id VARCHAR2(20) NOT NULL, /* 회원 ID */
	wishlist_name VARCHAR2(100), /* 위시리스트 이름 */
	wishlist_date DATE NOT NULL /* 업데이트 날짜 */
);

COMMENT ON TABLE sup.wishlist IS '위시리스트';

COMMENT ON COLUMN sup.wishlist.wishlist_id IS '기본키';

COMMENT ON COLUMN sup.wishlist.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.wishlist.member_id IS '회원 ID';

COMMENT ON COLUMN sup.wishlist.wishlist_name IS '위시리스트 이름';

COMMENT ON COLUMN sup.wishlist.wishlist_date IS '업데이트 날짜';

CREATE UNIQUE INDEX sup.PK_wishlist
	ON sup.wishlist (
		wishlist_id ASC
	);

ALTER TABLE sup.wishlist
	ADD
		CONSTRAINT PK_wishlist
		PRIMARY KEY (
			wishlist_id
		);

/* 랭킹 */
CREATE TABLE sup.ranking (
	ranking_id NUMBER(38) NOT NULL, /* 랭킹 기본키 */
	product_id NUMBER(38) NOT NULL, /* 상품 아이디 */
	ranking_like_product_count NUMBER(38), /* 상품 좋아요 수 */
	ranking_like_post_count NUMBER(38), /* 글 좋아요 수 */
	ranking_wishlist_count NUMBER(38), /* 상품 위시리스트 수 */
	ranking_purchase_count NUMBER(38), /* 상품 판매 수 */
	ranking_date DATE NOT NULL /* 업데이트 날짜 */
);

COMMENT ON TABLE sup.ranking IS '랭킹';

COMMENT ON COLUMN sup.ranking.ranking_id IS '랭킹 기본키';

COMMENT ON COLUMN sup.ranking.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.ranking.ranking_like_product_count IS '상품 좋아요 수';

COMMENT ON COLUMN sup.ranking.ranking_like_post_count IS '글 좋아요 수';

COMMENT ON COLUMN sup.ranking.ranking_wishlist_count IS '상품 위시리스트 수';

COMMENT ON COLUMN sup.ranking.ranking_purchase_count IS '상품 판매 수';

COMMENT ON COLUMN sup.ranking.ranking_date IS '업데이트 날짜';

CREATE UNIQUE INDEX sup.PK_ranking
	ON sup.ranking (
		ranking_id ASC
	);

ALTER TABLE sup.ranking
	ADD
		CONSTRAINT PK_ranking
		PRIMARY KEY (
			ranking_id
		);

/* QnA */
CREATE TABLE sup.qna (
	qna_id NUMBER(38) NOT NULL, /* QnA ID */
	sender_id VARCHAR2(20) NOT NULL, /* 보내는사람 */
	recepient_id VARCHAR2(20) NOT NULL, /* 받는사람 */
	product_id NUMBER(38) NOT NULL, /* 상품 아이디 */
	qna_content VARCHAR2(4000) NOT NULL, /* QnA 내용 */
	prev_qna_id NUMBER(38), /* 이전 QnA ID */
	qna_checked CHAR(1) NOT NULL, /* 글확인여부 */
	qna_date DATE NOT NULL /* 갱신 날짜 */
);

COMMENT ON TABLE sup.qna IS 'QnA';

COMMENT ON COLUMN sup.qna.qna_id IS 'QnA ID';

COMMENT ON COLUMN sup.qna.sender_id IS '보내는사람';

COMMENT ON COLUMN sup.qna.recepient_id IS '받는사람';

COMMENT ON COLUMN sup.qna.product_id IS '상품 아이디';

COMMENT ON COLUMN sup.qna.qna_content IS 'QnA 내용';

COMMENT ON COLUMN sup.qna.prev_qna_id IS '이전 QnA ID';

COMMENT ON COLUMN sup.qna.qna_checked IS '글확인여부';

COMMENT ON COLUMN sup.qna.qna_date IS '갱신 날짜';

CREATE UNIQUE INDEX sup.PK_qna
	ON sup.qna (
		qna_id ASC
	);

ALTER TABLE sup.qna
	ADD
		CONSTRAINT PK_qna
		PRIMARY KEY (
			qna_id
		);

ALTER TABLE sup.product
	ADD
		CONSTRAINT FK_member_TO_product
		FOREIGN KEY (
			member_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.purchase
	ADD
		CONSTRAINT FK_product_TO_purchase
		FOREIGN KEY (
			product_id
		)
		REFERENCES sup.product (
			product_id
		);

ALTER TABLE sup.purchase
	ADD
		CONSTRAINT FK_member_TO_purchase
		FOREIGN KEY (
			recepient_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.purchase
	ADD
		CONSTRAINT FK_member_TO_purchase2
		FOREIGN KEY (
			sender_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.friend
	ADD
		CONSTRAINT FK_member_TO_friend
		FOREIGN KEY (
			member_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.report
	ADD
		CONSTRAINT FK_member_TO_report
		FOREIGN KEY (
			sender_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.report
	ADD
		CONSTRAINT FK_product_TO_report
		FOREIGN KEY (
			product_id
		)
		REFERENCES sup.product (
			product_id
		);

ALTER TABLE sup.report
	ADD
		CONSTRAINT FK_post_TO_report
		FOREIGN KEY (
			post_id
		)
		REFERENCES sup.post (
			post_id
		);

ALTER TABLE sup.report
	ADD
		CONSTRAINT FK_member_TO_report2
		FOREIGN KEY (
			recepient_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.post
	ADD
		CONSTRAINT FK_member_TO_post
		FOREIGN KEY (
			member_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.post
	ADD
		CONSTRAINT FK_product_TO_post
		FOREIGN KEY (
			product_id
		)
		REFERENCES sup.product (
			product_id
		);

ALTER TABLE sup.like_post
	ADD
		CONSTRAINT FK_post_TO_like_post
		FOREIGN KEY (
			post_id
		)
		REFERENCES sup.post (
			post_id
		);

ALTER TABLE sup.like_post
	ADD
		CONSTRAINT FK_member_TO_like_post
		FOREIGN KEY (
			member_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.like_product
	ADD
		CONSTRAINT FK_product_TO_like_product
		FOREIGN KEY (
			product_id
		)
		REFERENCES sup.product (
			product_id
		);

ALTER TABLE sup.like_product
	ADD
		CONSTRAINT FK_member_TO_like_product
		FOREIGN KEY (
			member_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.wishlist
	ADD
		CONSTRAINT FK_member_TO_wishlist
		FOREIGN KEY (
			member_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.wishlist
	ADD
		CONSTRAINT FK_product_TO_wishlist
		FOREIGN KEY (
			product_id
		)
		REFERENCES sup.product (
			product_id
		);

ALTER TABLE sup.ranking
	ADD
		CONSTRAINT FK_product_TO_ranking
		FOREIGN KEY (
			product_id
		)
		REFERENCES sup.product (
			product_id
		);

ALTER TABLE sup.qna
	ADD
		CONSTRAINT FK_member_TO_qna
		FOREIGN KEY (
			sender_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.qna
	ADD
		CONSTRAINT FK_member_TO_qna2
		FOREIGN KEY (
			recepient_id
		)
		REFERENCES sup.member (
			member_id
		);

ALTER TABLE sup.qna
	ADD
		CONSTRAINT FK_product_TO_qna
		FOREIGN KEY (
			product_id
		)
		REFERENCES sup.product (
			product_id
		);