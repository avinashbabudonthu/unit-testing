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
	