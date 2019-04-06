# Simple examples of implementation of Spring Cloud
Proof-of-Concept implementation of cloud scalable simple e-commerce.

## Final architecture
![Spring Cloud - architecture of the solution](images/architecture.png)

### [1. basic business decomposition](https://github.com/petrfilip/simpleshop-spring-cloud-example/tree/1-decomposition)
- split into two module (product, inventory)

### [2. external configuration](https://github.com/petrfilip/simpleshop-spring-cloud-example/tree/2-external-config)
- file-system support (native)
![Spring Cloud - architecture of the solution](images/config.png)

### [3. service discovery](https://github.com/petrfilip/simpleshop-spring-cloud-example/tree/3-service-discovery)
![Spring Cloud - architecture of the solution](images/eureka.png)

### [4. service discovery & random port](https://github.com/petrfilip/simpleshop-spring-cloud-example/tree/4-server-port-zero-and-discovery-service-problem)
![Spring Cloud - architecture of the solution](images/eureka.png)

### [5. client-side load balancing](https://github.com/petrfilip/simpleshop-spring-cloud-example/tree/5-client-side-balancing-ribbon-with-eureka)
![Spring Cloud - architecture of the solution](images/ribbon.png)

### [6. circuit breaker](https://github.com/petrfilip/simpleshop-spring-cloud-example/tree/6-circuit-breaker-hystrix)
![Spring Cloud - architecture of the solution](images/feign.png)

### [7. API gateway](https://github.com/petrfilip/simpleshop-spring-cloud-example/tree/7-edge-service-api-gateway)
![Spring Cloud - architecture of the solution](images/zuul.png)

