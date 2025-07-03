

curl -X POST \
  http://localhost:8080/authenticate \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -d '{
    "username": "joe",
    "password": "password"
  }' -i


curl -X POST \
  http://localhost:8080/api/v1/transfer \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json' \
  -H 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJucGNpIiwic3ViIjoiam9lIiwiYXVkIjpbImF1ZGllbmNlLWV4YW1wbGUiXSwiaWF0IjoxNzUxMzcxMTA2LCJleHAiOjE3NTEzNzQ3MDYsImp0aSI6IjFiYTU2ZjcxLWQxZWItNGE0Ni1iZWM1LTljMThiYjczMTlmZCJ9.P75BT0XWC4S0ZSCgZZ42RDnW9AdDRaNpNq1oC03ofX4' \
  -d '{
    "fromAccount": "123456789012",
    "toAccount": "123456789013",
    "amount": 100.00
  }' -i 