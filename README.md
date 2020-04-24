# Spring Rest Api demo
Sample rest application that demonstrates
1. Spring boot REST API
2. Handling exceptions for REST Controllers globally using @ControllerAdvice
3. Spring Web Security with Basic Auth (username: user, password: password)
4. Spring Test with MockMvc
5. Spring Service implementation

### POST /api/add
Request Body
```json
{
 "x": "10",
 "y": "1" 
}
```
Response

Status: 200
```json
{
  "result": "11"
}
```

### POST /api/diff

Request Body
```json
{
 "x": "10",
 "y": "1" 
}
```
Response

Status: 200
```json
{
  "result": "9"
}
```