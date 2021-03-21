# url  shortner

> URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service
> 
> 예) https://en.wikipedia.org/wiki/URL_shortening => http://localhost/JZfOQNro

## DOING
- [x] url shortning 핵심 로직 구현
- [x] DB, 기본 api 환경 설정
- [x] api 생성 요청에 대한 응답 구현
- [x] 중복된 api 생성 요청에 대한 증가된 카운트 응답 구현
- [x] 단축 URL 요청에 대한 목표 URL 로의 라디이렉트 구현
- [ ] 기본 페이지 생성
- [ ] 존재하지 않는 단축 URL 페이지 생성

---

### url 변환 로직
- 처음에 생각했던것은 해쉬였지만 중복이 발생할 수 있어서 추가적인 체크가 필요하다. 따라서 url을 db에 저장해서 중복되지 않는 키를 얻은 후 41진법으로 변환해서 해당값을 내려주는 방법을 선택
- 단축된 URL로 접속 시 해당값을 다시 숫자키로 변환한다. 이미 데이터가 존재하는 경우 그에 맞는 url로 리다이렉트