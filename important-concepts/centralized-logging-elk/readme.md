- I have implemented the elk stack (Elastisearch, Logstack, Kibana) to implement centralized logging in bookstore-app
- Realtime logging is achived in this approach   
![Screenshot (129)](https://github.com/learning-project-01/bookstore-app/assets/130679461/86152f05-2015-4e2f-b7cc-2c474650e885)  
![Screenshot (132)](https://github.com/learning-project-01/bookstore-app/assets/130679461/12fae4d2-0414-4a17-a96d-1177d58c04cc)  
![Screenshot (133)](https://github.com/learning-project-01/bookstore-app/assets/130679461/76157ab7-f679-41c7-90ec-2976c1dc1dcd)  
## Logstash  
![Screenshot (136)](https://github.com/learning-project-01/bookstore-app/assets/130679461/b5fcc5c7-e24b-4d91-a8d0-fd9be8ca9359)
## Elastisearch  
![Screenshot (135)](https://github.com/learning-project-01/bookstore-app/assets/130679461/56fb8436-2303-4114-8963-53a9e4f23c37)
##  Kibana
![Screenshot (134)](https://github.com/learning-project-01/bookstore-app/assets/130679461/29190d3c-3f06-449c-8035-0309862fc429)

- Most of the programs are executed with their default configurations
- For logstack configuration the below custom conf file is used  
```
input {
  file {
    path => "C:/Users/user/Downloads/bookstore-app/bookstore-app.log"
    start_position => "beginning"
  }
}

output {
  elasticsearch {
    hosts => ["localhost:9200"]
  }
}
```
