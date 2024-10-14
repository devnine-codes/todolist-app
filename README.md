# Todo List App 📝

**Todo List App**은 **Spring Boot**를 사용하여 구현한 할 일 관리 애플리케이션입니다.  
사용자별로 할 일을 생성하고, **마감일과 우선순위 설정**, **JWT 인증 기반 로그인/로그아웃**을 지원합니다.

---

## 🛠️ 기술 스택

### **Backend:**
- Java 17+
- Spring Boot 3.3.4
- Spring Data JPA (Hibernate)
- H2 Database (In-Memory)
- JWT (JSON Web Token) for Authentication
- Maven

---

## 🎯 주요 기능

### **✅ 사용자(User) 관리:**
- 사용자 등록, 조회, 삭제
- 이메일과 비밀번호를 통한 로그인/회원가입
- 사용자 프로필(이메일, 비밀번호) 수정 기능

### **📝 할 일(Todo) 관리:**
- 할 일 생성, 수정, 삭제
- 할 일 완료 상태를 단일 API로 토글
- 사용자와 할 일 연동 (각 사용자의 할 일 관리)

### **🔍 검색 및 정렬:**
- 제목과 설명에서 키워드로 할 일 검색
- 우선순위(priority)에 따른 정렬
- 마감일(dueDate)이 임박한 할 일 조회

### **🔐 인증 및 보안:**
- JWT 기반 로그인/로그아웃 기능
- 로그인 후 인증된 요청만 처리
- 로그아웃 시 JWT 토큰 무효화

---

## 🔗 API 명세

### **사용자(User) API**
- **POST /api/auth/register**: 새 사용자 등록
- **POST /api/auth/login**: 사용자 로그인 (JWT 발급)
- **POST /api/auth/logout**: 로그아웃 (토큰 무효화)
- **GET /api/users/{id}**: 사용자 조회
- **PUT /api/users/{id}**: 사용자 정보 수정
- **DELETE /api/users/{id}**: 사용자 삭제

### **할 일(Todo) API**
- **POST /api/todos**: 새 할 일 생성
- **GET /api/todos**: 모든 할 일 조회
- **GET /api/todos/search?keyword={keyword}**: 키워드로 할 일 검색
- **GET /api/todos/user/{userId}**: 특정 사용자의 할 일 조회
- **PUT /api/todos/{id}**: 할 일 수정
- **PUT /api/todos/{id}/toggle**: 할 일 완료 상태 토글
- **DELETE /api/todos/{id}**: 할 일 삭제
