## Spring Filters

- Servlet filters provide a mechanism for intercepting and modifying requests and responses in a web application. They allow common pre-processing and post-processing tasks to be applied uniformly across multiple servlets
- Filters can perform a wide range of tasks, including logging, authentication, authorization, input validation, response compression, encryption/decryption, and more. They are versatile components that enable cross-cutting concerns to be implemented in a modular and reusable manner
- Filters are implemented by creating classes that implement the javax.servlet.Filter interface or extend classes that provide filter functionality. The Filter interface defines three methods: init(), doFilter(), and destroy(), which respectively initialize the filter, process the request and response, and clean up resources
- Filters can be ordered using the @Order annotation or the <filter-mapping> element in the web deployment descriptor (web.xml). Ordering determines the sequence in which filters are applied to requests and responses. Filters with lower order values are executed before filters with higher order values
- Filters have a lifecycle managed by the servlet container. They are initialized when the application starts up (init() method), invoked to process requests and responses (doFilter() method), and destroyed when the application shuts down (destroy() method)
- Filters can be configured in the web deployment descriptor (web.xml) or using annotations (@WebFilter). Configuration includes specifying URL patterns to which the filter should be applied
- Filters operate at the servlet container level, applying to all requests and responses within the scope of the web application. They are not tied to specific servlets or JSP pages, making them suitable for implementing global functionality  

![Screenshot 2024-02-09 003554](https://github.com/Ansu-s/test-projects/assets/130679461/33ce0987-fa88-4ac6-b8e9-8f99cc251fd8)  
![ss-01](https://github.com/Ansu-s/test-projects/assets/130679461/3a1dea8a-ecda-4f25-9a90-560ae6474bc6)

