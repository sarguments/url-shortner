# url  shortner

> URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service
> 
> 예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro

## 요구사항
- URL 입력폼 제공 및 결과 출력
- URL Shortening Key는 8 Character 이내로 생성 되어야 한다.
- 동일한 URL에 대한 요청은 동일한 Shortening Key로 응답해야 한다.
- 동일한 URL에 대한 요청 수 정보를 가져야 한다.
- Shortening된 URL을 요청받으면 원래 URL로 리다이렉트 한다.

## DONE
- [x] url shortning 핵심 로직 구현
- [x] DB, 기본 api 환경 설정
- [x] api 생성 요청에 대한 응답 구현
- [x] 중복된 api 생성 요청에 대한 증가된 카운트 응답 구현
- [x] 단축 URL 요청에 대한 목표 URL 로의 라디이렉트 구현
- [x] 기본 페이지 생성
- [x] 존재하지 않는 단축 URL 페이지 생성

---

## url 변환 로직
- 처음에 생각했던것은 해쉬였지만 중복이 발생할 수 있어서 추가적인 체크가 필요하다. 따라서 url을 db에 저장해서 중복되지 않는 키를 얻은 후 41진법으로 변환해서 해당값을 내려주는 방법을 선택
- 단축된 URL로 접속 시 해당값을 다시 숫자키로 변환한다. 이미 데이터가 존재하는 경우 그에 맞는 url로 리다이렉트

---

## 빌드/실행 방법

1. gradlew 가 있는 프로젝트 루트 폴더에서 다음 명령어를 입력한다.
    ```
    ./gradlew build
    ```
2. 빌드가 진행 된 후 `build/lib` 디렉토리에 jar파일이 생성된다.
3. build/lib 디렉토리에서 다음 명령어를 입력해서 jar파일을 실행한다.
    ```
    java -jar url-shortner-0.0.1-SNAPSHOT.jar
    ```
4. http://localhost:8080에 접속

## 구현 환경
- java 1.8
- intellij
- springboot 2.4.4
- spring data jpa
- h2