# 📦 재고관리시스템 (Inventory Management System)

## 프로젝트 소개

상품 등록부터 입출고 관리, 재고 현황 파악까지 재고 관리의 전 과정을 지원하는 웹 기반 시스템입니다. <br>
직관적인 대시보드와 통계 분석 기능을 통해 데이터 기반 의사결정을 돕고, 관리자 기능으로 사용자 권한을 효율적으로 관리할 수 있습니다.

<br>

## 프로젝트 개요

- 프로젝트 이름 : StockFlow
- 프로젝트 기간 : 2025.11.03 ~ 2025.11.17 (2주)
- 프로젝트 인원 : 1인 (개인 프로젝트)

<br>

## 프로젝트 목표

- Spring Boot를 활용한 웹 애플리케이션 개발 경험
- Spring Security Session 기반 인증 및 권한 관리 구현
- MyBatis를 활용한 데이터베이스 연동 및 CRUD 기능 구현
- Chart.js를 활용한 통계 데이터 시각화
- Thymeleaf 템플릿 엔진을 통한 동적 화면 구성

<br>

## 기술 스택

### FrontEnd
<img src="https://img.shields.io/badge/THYMELEAF-005F0F?style=for-the-badge&logo=THYMELEAF&logoColor=white" alt="THYMELEAF"> <img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=HTML5&logoColor=white" alt="HTML5">
<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=CSS3&logoColor=white" alt="CSS3">
<img src="https://img.shields.io/badge/JAVASCRIPT-F7DF1E?style=for-the-badge&logo=JAVASCRIPT&logoColor=white" alt="JAVASCRIPT">
<img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white" alt="jQuery">

### BackEnd
<img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=Spring%20Boot&logoColor=white" alt="Spring Boot"> <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=Spring%20Security&logoColor=white" alt="Spring Security"> <img src="https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=MyBatis&logoColor=white" alt="MyBatis">

### Database
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MYSQL">

### Tools
<img src="https://img.shields.io/badge/GITHUB-181717?style=for-the-badge&logo=GITHUB&logoColor=white" alt="GITHUB"> <img src="https://img.shields.io/badge/FIGMA-F24E1E?style=for-the-badge&logo=FIGMA&logoColor=white" alt="FIGMA">
<img src="https://img.shields.io/badge/dbdiagram.io-F08705?style=for-the-badge&logo=dbdiagram.io&logoColor=white" alt="dbdiagram.io">

<br>

## 주요 기능

<details>
<summary><b>👤 회원 관리</b></summary>

- Spring Security 기반 로그인/로그아웃
- BCrypt 비밀번호 암호화
- 세션 기반 인증
</details>

<details>
<summary><b>👥 사용자 관리 (관리자 전용)</b></summary>

- 사용자 등록, 수정, 삭제
- 역할별 권한 관리 (일반/관리자)
- 사용자 목록 조회 및 검색
</details>

<details>
<summary><b>📦 상품 관리</b></summary>

- 상품 등록, 수정, 삭제 (CRUD)
- 상품코드 자동 생성 (PRD-YYYYMMDD-XXX)
- 카테고리별 분류 (전자/의류/식품/기타)
- 안전재고 설정 및 재고 상태 표시 (정상/부족/없음)
- 상품명/카테고리 검색 및 페이징
- 입출고 내역이 있는 상품 삭제 제한
</details>

<details>
<summary><b>📥 입고 관리</b></summary>

- 입고 등록 및 내역 조회
- 입고번호 자동 생성 (IN-YYYYMMDD-XXX)
- 입고 시 재고 자동 증가
- 공급업체 정보 관리
- 날짜 범위 검색 및 최신순 정렬
</details>

<details>
<summary><b>📤 출고 관리</b></summary>

- 출고 등록 및 내역 조회
- 출고번호 자동 생성 (OUT-YYYYMMDD-XXX)
- 출고 시 재고 자동 감소
- 재고 부족 시 출고 제한
- 출고사유 분류 (판매/폐기/반품/기타)
- 날짜 범위 검색 및 최신순 정렬
</details>

<details>
<summary><b>📊 재고 현황</b></summary>
  
- 전체 상품 재고 조회
- 재고 상태별 필터링 (정상/부족/없음)
- 카테고리별 필터 및 검색
- 재고 부족 상품 강조 표시
</details>

<details>
<summary><b>📈 통계 및 대시보드</b></summary>

- Chart.js 기반 데이터 시각화
- 기간별 입출고 현황 (바 그래프)
- 카테고리별 재고 현황 (파이 차트)
- 입출고 TOP 5 상품 분석
- 실시간 주요 지표 (총 재고, 오늘 입출고, 재고 부족 상품)
- 최근 입출고 내역 조회
</details>

<details>
<summary><b>📢 공지사항</b></summary>

- 공지사항 등록, 수정, 삭제 (관리자)
- 공지 구분 (일반/중요)
- 상단 고정 기능
- 파일 첨부 및 다운로드
- 댓글 작성 및 관리
- 조회수 자동 증가
</details>

<br>

## ERD

<br>
<img src="src/main/resources/static/images/erd.png" width="1100" height="700" alt="데이터베이스 ERD">

<br>

## 프로젝트 구조

```
src/
├── main/
│   ├── java/
│   │   ├── controller/       # 컨트롤러 계층
│   │   ├── domain/           # 엔티티 클래스
│   │   ├── dto/              # 데이터 전송 객체
│   │   ├── exception/        # 예외 처리
│   │   ├── mapper/           # Mybatis 인터페이스
│   │   ├── response/         # API 응답 객체
│   │   ├── security/         # Spring Security 설정
│   │   ├── service/          # 비즈니스 로직 계층
│   │   └── util/             # 유틸리티 클래스
│   └── resources/
│       ├── mapper/           # Mybatis XML 매퍼
│       ├── static/           # CSS, JS, 이미지
│       ├── templates/        # Thymeleaf 템플릿
│       └── application.yml   # 설정 파일
└── test/

```

<br>

## 화면 구성

|                                            로그인                                            |                                              대시보드                                              |
|:-----------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------:|
| <img src="src/main/resources/static/images/login.gif" width="475" height="350" alt="로그인"> | <img src="src/main/resources/static/images/dashboard.gif" width="475" height="350" alt="대시보드"> |

|                                              상품 목록                                               |                                              상품 등록                                              |
|:------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------:|
| <img src="src/main/resources/static/images/productList.gif" width="475" height="350" alt="상품목록"> | <img src="src/main/resources/static/images/addProduct.gif" width="475" height="350" alt="상품등록"> |

|                                              입고 내역                                               |                                              입고 등록                                              |
|:------------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------------:|
| <img src="src/main/resources/static/images/inboundList.gif" width="475" height="350" alt="입고내역"> | <img src="src/main/resources/static/images/addInbound.gif" width="475" height="350" alt="입고등록"> |

|                                               출고 내역                                               |                                              출고 등록                                               |
|:-------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------:|
| <img src="src/main/resources/static/images/outboundList.gif" width="475" height="350" alt="출고내역"> | <img src="src/main/resources/static/images/addOutbound.gif" width="475" height="350" alt="출고등록"> |

|                                               재고 현황                                                |                                              통계                                               |
|:--------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------:|
| <img src="src/main/resources/static/images/inventoryList.gif" width="475" height="350" alt="재고현황"> | <img src="src/main/resources/static/images/statistics.gif" width="475" height="350" alt="통계"> |

|                                          사용자 관리 (관리자)                                           |                                          사용자 추가 (관리자)                                          |
|:-----------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------:|
| <img src="src/main/resources/static/images/adminList.gif" width="475" height="350" alt="사용자목록"> | <img src="src/main/resources/static/images/addAdmin.gif" width="475" height="350" alt="사용자추가"> |

|                                              공지사항 목록                                              |                                             공지사항 등록                                              |
|:-------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------------:|
| <img src="src/main/resources/static/images/noticeList.gif" width="475" height="350" alt="공지사항목록"> | <img src="src/main/resources/static/images/addNotice.gif" width="475" height="350" alt="공지사항등록"> |
