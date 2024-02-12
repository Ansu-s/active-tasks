## Code flow for `addItem`

### Controller: 
Endpoint : `/cart/{catalogItemId}`  

Allowed methods : POST   

Requires : catalogItemId  (it will be extracted from the url by using the @PathVariable and set as the argument catalogItemId for the method addItemToCart)
```java 
public CartItem addItemToCart(@PathVariable("catalogItemId") Long catalogItemId)
```

First  it will find the catalogItem using the findById() using the catalogItemId as argument.
```java
  CatalogItem catalogItem = catalogItemService.findById(catalogItemId);
```

Then it searches CartItemEntity in the database for the Entity and then saves it in the savedCartItemEntity variable.
```java
CartItemEntity savedCartItemEntity = findCartItemEntity(catalogItemId);
``` 
Checking the stock quantity, if the item is in stock then it is added to the cart else a run time exception AppRuntimeException "Item is out of stock" is thrown.

```java
if(catalogItem.getStockQuantity() <= 0){throw new AppRuntimeException("Item is out of stock");}
```
If there is not any entity in the variable savedCartItemEntity then a new one is created in the database and all its properties are set from the data that is sent and after that the newly created entity is saved in CartItemEntity using cartItemEntityRepository repository.

```java
 if (savedCartItemEntity == null) { // create new entity
        CartItemEntity newCartItemEntity = new CartItemEntity();
        newCartItemEntity.setId(IdGenerator.getLongId());
        newCartItemEntity.setCartId(userSessionService.getUserId());
        newCartItemEntity.setQuantity(1);
        newCartItemEntity.setCatalogItemId(catalogItemId);
        newCartItemEntity.setState(CartItemState.BUY_NOW.getWeight());

        newCartItemEntity = cartItemEntityRepository.save(newCartItemEntity);

        return new CartItem().fromEntity(newCartItemEntity, catalogItem);
        }
``` 
The quantity is increased by one and it is saved to the repository.
```java
savedCartItemEntity.setQuantity(savedCartItemEntity.getQuantity() + 1);
    savedCartItemEntity = cartItemEntityRepository.save(savedCartItemEntity);
```
It returns an object which has data corresponding to savedCartItemEntity and catalogItem using the fromEntity method.
```java
 return new CartItem().fromEntity(savedCartItemEntity, catalogItem);
```