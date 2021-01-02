# Mockito Notes
* What is Mockito
	* Mockito is Mocking framework to use in Junit
* Mockito limitations
	* 	we cannot mock final methods. You can stub the call and the runtime will not complain, but we will receive an assertion failure if you expect the mocked result to be returned
	* We cannot mock private methods.
	* we cannot mock static methods
* Steps to implement mockito
	* Declare this annotation at test class level`@RunWith(org.mockito.runners.MockitoJunitRunner.class)`
	* To create injected object annotate them with this `@Mock private ProductDo productDo;`
	* To inject created mock object into target object `@InjectMocks private ProductBo productBo;`
	* Annotate init method with annotation `@Before`
	* In the init method `MockitoAnnotations.initMocks(this);`
	* Annotate test method with @Test annotation
* Create stub for method
```
List<Product> products = java.util.Arrays.asList(product1, product2);
org.mockito.Mockito.stub(productDo.getProducts(org.mockito.Matchers.anyInt())).toReturn(products);
(or)
org.mockito.Mockito.when(productDo.getProducts(org.mockito.Matchers.anyInt())).toReturn(products);
(or)
org.mockito.Mockito.when(mockOrderDao.findOrder(orderId)).thenReturn(orderFixture);
```
* create mock without annotation of dependency class
```
OrderDao mockOrderDao = org.mockito.Mockito.mock(OrderDao.class);
```
* Verification. To assert that particular methods were called with matched set of inputs. 
```
org.mockito.Mockito.verify(mockOrderDao).findOrder(orderId);
```
* If we have to mock class which is implementing multiple interfaces then in that case we need to use MockSettings class to create mock
```
org.mockito.MockSettings (I)
org.mockito.internal.creation.MockSettingsImpl (c )
MockSettings mockSettings = Mockito.withSettings();
OrderDao mockOrderDao = Mockito.mock(OrderDao.class, mockSettings);
```
* This method will accept variable number of interfaces, which the resulting mock will implement
```
MockSettings.extraInterfaces(.. )

public class OrderUtil implements OrderFilter, OrderTransformer{ --- }
class OrderServiceImpl{
OrderTransformer orderTransformer = …;
  public List<String> getOrderSummary(){
    if(orderTransformer instanceof OrderFilter) { … }
  }
}

OrderTransformer mockOrderTransformer = Mockito.mock(OrderTransformer.class, mockSettings.extraInterfaces(OrderFilter.class) );
```
* Making mock to implement Serializable interface
```
MockSettings.serializable(…);
```
* allows you to provide a descriptive name to be logged when any verification against mock fails
```
MockSettings.name(...)
```
* Mockito.when(..)
	* return OnGoingStub<T>, specifies how the invocation behaves. This is generic type
	* the type of the instance is derived from the return type of the operation being called on the mock. We then use instance of OnGoingStub to specify what to return upon invocation of the operation
* OnGoingStub contains the following operations
	* thenReturn(..)
	* thenThrow(..)
	* thenCallRealMethod(..)
	* thenAnswer(..)
	* doThrow(..)
* thenReturn(..)
	* return an object or value based on the return type of the method being stubbed
* thenThrow(..)
	* provides means for testing exception being thrown by method under test
	* This method expects an instance of an exception as the parameter and stores it to later being thrown during execution of method
```
Mockito.when(mockService.getEmployeeList()).thenThrow(new NoRecordsException("no records found"));
```
* void methods
	* Mocking void methods do not work with OnGoingStub<T>
	* We don’t need to mock methods returning void because there is nothing we need to return as method execution that we can stub. But we have situation like method with void can throw an exception. To test this situation we need to use doThrow(..) method
* doThrow(..)
	* returns an instance of org.mockito.Stubber rather than org.mockito.OnGoingStub
```
org.mockito.Stubber stubber = Mockito.doThrow(new EmployeeInsertException("can not insert new employee"));
stubber.when(employeeServiceMock.insertEmployee(employeeFixture) );

org.mockito.stubbing.Stubber stubber = Mockito.doThrow(new EmployeeInsertException("can not insert new employee"));
stubber.when(employeeServiceMock).insertEmployee(employeeFixture);
```
* thenCallRealMethod(..)
	* To call real method on stubbing
```
Mockito.when(mockService.getEmployeeList()).thenCallRealMethod();
```
* Answering allows you to provide a means to conditionally respond based on mock operation parameters
	* thenAnswer(..)
		* this is used for argument matching means return different values based on arguments to method being mocked
```
Mockito.when( mockService.insertEmployee(Mockito.any(Employee.class)) ).thenAnswer(new Answer(){
   Object answer(InvocationOnMock invocation) { ----- }
});
```
* Mockito.verify()
	* Used to verify whether mock method is being called or not
	* Allows to verify how many time mock method is being called in method under test
```
Mockito.when(employeeServiceMock.getEmployee(empId)).thenReturn(employeeFixture);
//verification
Mockito.verify(employeeServiceMock).getEmployee(empId);

Mockito.verify(employeeServiceMock, Mockito.times(2)).getEmployee(empId);
```