# KakaopayStock

** 개발 프레임워크
Spring Boot
[ JAVA 1.8 / IDE : STS / Build : Gradle / Test : Junit 4 / DB : H2]

** 문제해결
1. Data initialization : application.properties 내 schema를 이용하여 테이블 생성 및 @PostConstruct 어노테이션 사용하여 csv 데이터로 초기 데이터 구축하도록 개발하였습니다.
2. 하나의 Controller, Service, 3개의 Repository로 구성하였습니다. 각 Repository 내에 작성한 함수들의 기준은 실행 쿼리의 기준 테이블입니다.
3. 요구사항 3번의 경우는 SQL에서 모든 것을 해결하지 않고, 쿼리의 결과로 Service단에서 조립하여 최종 리턴 객체를 만들도록 구현 하였습니다.
4. 요구사항 4번의 경우 Controller에서 이관된 관리점을 요청받았을 시 바로 리턴하도록 하드코딩하였는데, DB에 대한 명확한 요구사항(이관여부 컬럼 생성 등)이 있었다면 해당 스펙에 맞추어 개발했을 것입니다.
5. sumAmt 필드 값은 요구사항 1번을 제외하고 수수료를 합산하지 않은 금액입니다. 


** 빌드 및 실행 방법
1. 기동 후 아래 URL로 리턴 데이터 호출 가능합니다.
 1) 요구사항 1, 2, 3
 -  http://localhost:8080/test/require1 
 -  http://localhost:8080/test/require2
 -  http://localhost:8080/test/require3

 2) 요구사항 4
  * JSON 형식으로 인풋값을 넣어야 하기 때문에 저는 Postman을 사용하여 테스트 했습니다. POST URL 및 Key와 Value는 아래와 같습니다.
 - URL : http://localhost:8080/test/require4
 - Key : brName, Value : 잠실점
 - 호출 Body :
      {
      "brName":"잠실점"
      }
