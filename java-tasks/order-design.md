## Steps to add order functionality

### Model:
- New AddressType enum having values HOME/WORK 
```java
public enum AddressType {
    HOME,WORK ;
}
```
- Since the address entity is still there we just need this AddressType field added to it. 
```java
@Entity
@Table(name = "address")
@Data
public class AddressEntity {

  @Id
  private Long id;
  private Long userId;
  private String line1;
  private String line2;
  private String city;
  private String state;
  private String country;
  private String postalCode;

  private AddressType addressType;

}
``` 
We can make changes to toEntiy and fromEntity method in Address class
```java
toEntiy :  addressEntity.setAddressType(this.getAddressType());
fromEntity :  this.setAddressType(entity.getAddressType());
``` 
Create Order class so we can add toEntity and fromEntity methods for it as well
```java
@Data
public class Order {

        private Long orderId;
        private Long userId;
        private Date orderDate;
        private String orderStatus;
        private Integer shippingAddressId;
        private BigDecimal totalPrice;
        private String paymentStatus;
        private Date deliveryDate;
        private String trackingNumber;

        public OrderEntity toEntity() {
            OrderEntity orderEntity = new OrderEntity();
            orderEntity.setOrderId(this.getOrderId());
            orderEntity.setUserId(this.getUserId());
            orderEntity.setOrderDate(this.getOrderDate());
            orderEntity.setOrderStatus(this.getOrderStatus());
            orderEntity.setShippingAddressId(this.getShippingAddressId());
            orderEntity.setTotalPrice(this.getTotalPrice());
            orderEntity.setPaymentStatus(this.getPaymentStatus());
            orderEntity.setDeliveryDate(this.getDeliveryDate());
            orderEntity.setTrackingNumber(this.getTrackingNumber());
            return orderEntity;
        }

        public Order fromEntity(OrderEntity entity) {
            this.setOrderId(entity.getOrderId());
            this.setUserId(entity.getUserId());
            this.setOrderDate(entity.getOrderDate());
            this.setOrderStatus(entity.getOrderStatus());
            this.setShippingAddressId(entity.getShippingAddressId());
            this.setTotalPrice(entity.getTotalPrice());
            this.setPaymentStatus(entity.getPaymentStatus());
            this.setDeliveryDate(entity.getDeliveryDate());
            this.setTrackingNumber(entity.getTrackingNumber());
            return this;
        }

        
}
```
### Flyway script:

V7_CREATE_ORDER_TABLE.sql  

```mysql
CREATE TABLE orders (
    order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    tracking_number VARCHAR(255),
    order_date TIMESTAMP,
    order_status VARCHAR(255),
    shipping_address_id INT,
    total_price DECIMAL(10, 2),
    payment_status VARCHAR(255),
    delivery_date DATE,  
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (shipping_address_id) REFERENCES address(id)
);
``` 

### Order entity 
```java
@Entity
@Table(name = "orders")
@DATA
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "shipping_address_id")
    private Integer shippingAddressId;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "tracking_number")
    private String trackingNumber;
```
### Repository:
Add OrderRepository to perform operations on OrderEntity

```java
public interface OrderRepository extends CrudRepository<OrderEntity, Long> { }
```
### Services:

```java

public interface OrderService {

    public Order createOrder(Order order);

    public Order orderSummary(Long OrderId );

    public List<Order> allOrders (Long userId);

}
```
### Implementations: 
Below are all the methods that will hold the business login

```java
import com.example.bookstoreapp.exceptions.AppRuntimeException;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {

        return orderRepository.save(order.toEntity()).fromEntity();
    }

    @Override
    public Order orderSummary(Long orderId) {


        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppRuntimeException("Order not found"));


        return orderEntity.fromEntity();
    }

    @Override
    public List<Order> allOrders(Long userId) {
       
        
        List<OrderEntity> orderEntities = orderRepository.findByUserId(userId);

        return orderEntities.stream()
                .map(OrderEntity::fromEntity)
                .toList();
    }
}
```


