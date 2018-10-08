# Springboot

 //And findByHeightAndSex(int height,char sex)£»  
 public List<User> findByHeightAndSex(int height,char sex);  
  
// Or findByHeightOrSex(int height,char sex)£»  
 public List<User> findByHeightOrSex(int height,char sex);  
  
 //Between findByHeightBetween(int min, int max)£»  
 public List<User> findByHeightBetween(int min,int max);  
  
 //LessThan findByHeightLessThan(int max)£»  
 public List<User> findByHeightLessThan(int max);  
  
 //GreaterThan findByHeightGreaterThan(int min)£»  
 public List<User> findByHeightGreaterThan(int min);  
  
 //IsNull findByNameIsNull()£»  
 public List<User> findByNameIsNull();  
  
 //IsNotNull findByNameIsNotNull()£»  
 public List<User> findByNameIsNotNull();  
  
 //NotNull 
 public List<User> findByNameNotNull();  
  
 //Like findByNameLike(String name);  
 public List<User> findByNameLike(String name);  
  
 //NotLike findByNameNotLike(String name)£»  
 public List<User> findByNameNotLike(String name); 
 
 List<Registration> findByPlaceIgnoreCaseContaining(String place);
  
 //OrderBy findByNameNotNullOrderByHeightAsc()£»  
 public List<User>findByNameNotNullOrderByHeightAsc();  
  
 //Not findByNameNot(String name)£»  
 public List<User> findByNameNot(String name);  
  
 //In findByNameIN(String name);  
 public List<User> findByNameIn(String name);  
  
 //NotIn findByNameNotIN(String name);  
 public List<User> findByNameNotIn(String name); 

@Query(value = "select o.* from orders o ,user u where o.uid=u.id and u.name=?1", nativeQuery = true)  
@Modifying  
public List<Order> findOrderByName(String name);  

@Query(value = "delete from orders where id=?1 ", nativeQuery = true)  
@Modifying  
public void deleteOrderById(int id);  
 
@Query(value = "delete from orders where uid=?1 ", nativeQuery = true)  
@Modifying  
public void deleteOrderByUId(int uid);  

@Query(value = "update orders set name=?1 where id=?2 ", nativeQuery = true)  
@Modifying  
public void updateOrderName(String name,int id);  

@Query(value = "insert into orders(name,uid) value(?1,?2)", nativeQuery = true)  
@Modifying  
public void insertOrder(String name,int uid);  


Redis
redis dir run: redis-server redis.windows.conf
