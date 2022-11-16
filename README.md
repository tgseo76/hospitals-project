# hospitals-project

레이어드 아키텍쳐를 이해하고 기능 구현 흐름에 익숙해지기 위한 연습 repository 입니다.

## ID로 병원 조회

url에 병원 id를 담아 요청하고 해당 병원 정보를 읽어옵니다.

### Endpoint
`/api/v1/hospitals/{id}`

1. (Domain) Hospital Entity는 제공.
2. (Repository) DB에 id로 검색 작성.
3. (Service) 영업중, 폐업 여부 판단 로직 및 ResponseDTO로 변환 작성.
4. (Controller) 클라이언트의 요청을 Service와 연결 작성.
