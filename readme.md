# Hyminton 서버
하이민턴의 원활한 운영을 위한 api 서버
## Client
1. Mobile Application
    - Flutter - iOS / Android
    - Web (예정)
## Specs
1. Spring Boot
    - 서버 개발 프레임워크
2. Language
    - Java
    - Kotlin
## Checklists
https://hyun-i.jetbrains.space/p/hyminton/checklists

위 링크 접속 후 `Server` 태그 선택
## Flows
1. 회원 가입 플로우
    1. 운영진이 코드 발급 후 대상자에게 전달
    2. 대상자가 해당 코드를 이용해 가입
    
2. 운동 개최-종료 플로우
    1. 운영진이 날짜, 장소, 최대 인원, 유형(정기/번개), 마감 시간 선택해서 운동 개최
    2. 회원들 참여 신청
    3. 최대 인원 마감 시 대기 명단으로 들어감
    4. 마감 시 대기 명단 자르고 참여자 확정
    5. 필요한 경우 운영진이 참여자 명단을 이용해 대진표 작성 후 공유 
    
3. 셔틀콕/쿠폰 신청 플로우
    1. 회원이 셔틀콕/쿠폰 신청
    2. 회원이 입금 확인 요청 발송
    3. 운영진이 입금 확인 후 전달 중 으로 상태 변경
    4. 전달 완료 후 완료로 상태 변경
## 개발 시 신경 쓸 것
하이민턴 개발팀이 이 프로젝트를 이어나가기 위해 다음 사항들을 신경쓰며 개발합시다.
1. 가독성
    1. 코드 포맷팅
    2. 클래스, 변수, 함수 이름
    3. 적절한 주석
2. 문서화
    1. 클래스 주석
    2. 작성자, 이메일, 작성일 기입
        - 개발 초기 세팅-4 참조
3. git flow
    1. `master` branch 는 실제로 가동되고 있는 서버 버전
    2. `develop` branch 는 다음 버전 (production-ready)
    3. `feature` branch 는 개발 중인 기능
        - `feature/authorization`
        - `feature/notice`
    4. `hotfix` branch 는 `master`, `develop` 에서 예상치 못한 버그가 발생한 경우 생성
    5. merge 순서
        - 완료된 `feature` > `develop` > 다른 `feature`들 
        - `hotfix` > `master` > `develop` > `feature`
        - `hotfix` > `develop` > `feature`
## 개발 초기 세팅
1. `git clone https://git.jetbrains.space/hyun-i/Server.git` 
2. `cd Server`
3.  maven import (`pom.xml`)
    - IntelliJ 사용 시 `pom.xml` 우클릭 > maven > Reimport
    - Goorm IDE 사용 시 터미널에서 `mvn dependency:resolve` 입력
4. 개발자 세팅
    - 코드의 작성자를 명시하기 위해 자신이 생성한 파일에 개발자 명시
    - 이후 수정 과정은 별도 명시 없이 git 을 통해 확인
    1. IntelliJ를 사용하지 않을 경우 
        - 자신의 IDE 에 맞는 방법으로 설정 
        - 또는 생성하는 파일에 직접 기입
    2. IntelliJ를 사용하는 경우
        1. `ctrl`+`alt`+`S` 로 Settings 창 띄우기
        2. Editor > File and Code Templates > Includes > File Header 선택
        3. 다음 기입
            ```
           /** ${PACKAGE_NAME}.${NAME}
            * Author: 이름
            * Date  : ${DATE}
            * Email : 이메일
            */
           ```
        4. OK 클릭
## 실행
1. HymintonApplication.kt 의 main() 함수 실행