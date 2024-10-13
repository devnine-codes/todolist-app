# Todo List App 📝

**Todo List App**은 **Spring Boot**와 **React**를 사용하여 구현한 할 일 관리 애플리케이션입니다.  
사용자별로 할 일을 생성하고, 마감일과 우선순위를 설정하며, REST API와 UI를 통해 간편하게 관리할 수 있습니다.

---

## 🛠️ 기술 스택
### **Backend:**
- Java 17+
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- H2 Database (In-Memory)
- Maven

---

## 🎯 주요 기능
- **사용자(User) 관리:** 새로운 사용자 등록, 조회, 삭제
- **할 일(Todo) 관리:** 할 일 생성, 수정, 삭제
- **할 일과 사용자 연결:** 각 할 일을 사용자와 연동
- **우선순위 및 마감일 설정:** 할 일에 우선순위와 마감일 지정
- **REST API 제공:** 외부 애플리케이션과 연동 가능