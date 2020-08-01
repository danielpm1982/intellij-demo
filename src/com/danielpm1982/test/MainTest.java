package com.danielpm1982.test;
import com.danielpm1982.Main;
import com.danielpm1982.domain.OrderItem;
import com.danielpm1982.helper.PopulateHelper;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

@DisplayName("Main class test")
class MainTest {
    private static TestReporter testReporter;
    @BeforeAll
    @DisplayName("Set up Main class test")
    static void setUp(TestInfo testInfo, TestReporter testReporter) {
        MainTest.testReporter = testReporter;
        testReporter.publishEntry("Initializing MainTest class test... "+testInfo+"\n");
        testReporter.publishEntry("Initialized successfully !\n");
    }
    @Nested
    @DisplayName("populateData() test - successful tests")
    class SuccessfulTests{
        @BeforeEach
        void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo){
            testReporter.publishEntry("Initializing "+testInfo.getTestMethod().get().getName()+"() :: repetition "+repetitionInfo.getCurrentRepetition()+" / "+repetitionInfo.getTotalRepetitions()+"...\n");
//            testReporter.publishEntry("Initializing "+testInfo.getTestMethod().get().getName()+"() :: "+testInfo.getDisplayName()+"...\n");
            Main.orderItemList=null;
            testReporter.publishEntry("Initialized successfully !\n");
        }
        @DisplayName("populateDataSuccessfulTest() - with repetitions")
        @RepeatedTest(value = 5, name = "repetition {currentRepetition} / {totalRepetitions}")
        void populateDataSuccessfulTest() {
            testReporter.publishEntry("Checking initial Main class OrderItemList is empty...\n");
            assertNull(Main.orderItemList, "Initial OrderItemList must have no List instance associated to it !");
            testReporter.publishEntry("Checked !\n");
            testReporter.publishEntry("Populating DB through Main class populateData() method...\n");
            Main.populateSampleData();
            testReporter.publishEntry("Populated !\n");
            testReporter.publishEntry("Checking Main class OrderItemList is NOT empty after population...\n");
            assertNotNull(Main.orderItemList, "After DB is populated, OrderItemList should have a List instance associated to it !");
            testReporter.publishEntry("Checked !\n");
            testReporter.publishEntry("Checking Main class static OrderItemList is at the same state as DB static OrderItemList...\n");
            List<OrderItem> orderItemListExpected = PopulateHelper.getOrderItemList();
            List<OrderItem> orderItemListActual = Main.orderItemList;
            assertIterableEquals(orderItemListExpected, orderItemListActual, "After DB is populated, the DB static OrderItemList should be exactly the same (same number, position and equality of List items) as the Main static OrderItemList ! No inconsistencies allowed !");
            testReporter.publishEntry("Checked !\n");
        }
        @AfterEach
        void afterEach(TestInfo testInfo, RepetitionInfo repetitionInfo){
//            testReporter.publishEntry("Tearing down "+testInfo.getTestMethod().get().getName()+"() :: repetition "+repetitionInfo.getCurrentRepetition()+" / "+repetitionInfo.getTotalRepetitions()+"...\n");
            testReporter.publishEntry("Tearing down "+testInfo.getTestMethod().get().getName()+"() :: "+testInfo.getDisplayName()+"...\n");
            testReporter.publishEntry("Teared down successfully !\n");
        }
    }
    @Nested
    @DisplayName("populateData() test - failed tests")
    class FailedTests{
        @BeforeEach
        void beforeEach(TestInfo testInfo){
            testReporter.publishEntry("Initializing "+testInfo.getTestMethod().get().getName()+"() ...\n");
            Main.orderItemList=null;
            testReporter.publishEntry("Initialized successfully !\n");
        }
        @DisplayName("populateDataFailedTest() - no repetitions")
        @Test
//        @Disabled
        void populateDataFailedTest() {
            testReporter.publishEntry("Checking initial Main class OrderItemList is empty...\n");
//            Main.orderItemList=new ArrayList<>(); //uncomment to fail the test
            assertEquals(null, Main.orderItemList, "Initial OrderItemList must have no List instance associated to it !");
            testReporter.publishEntry("Checked !\n");
            testReporter.publishEntry("Populating DB through Main class populateData() method...\n");
            Main.populateSampleData();
            testReporter.publishEntry("Populated !\n");
            testReporter.publishEntry("Checking Main class OrderItemList is NOT empty after population...\n");
//            Main.orderItemList=null; //uncomment to fail the test
            assertNotEquals(null, Main.orderItemList, "After DB is populated, OrderItemList should have a List instance associated to it !");
            testReporter.publishEntry("Checked !\n");
            testReporter.publishEntry("Populating DB through Main class populateData() method...\n");
            Main.populateSampleData();
            testReporter.publishEntry("Populated !\n");
            testReporter.publishEntry("Checking Main class static OrderItemList is at the same state as DB static OrderItemList...\n");
            List<OrderItem> orderItemListExpected = PopulateHelper.getOrderItemList();
            List<OrderItem> orderItemListActual = Main.orderItemList;
//            orderItemListActual = new ArrayList<>(Main.orderItemList); //uncomment to fail the test
//            orderItemListActual.remove(0); //uncomment to fail the test
            assertIterableEquals(orderItemListExpected, orderItemListActual, "After DB is populated, the DB static OrderItemList should be exactly the same (same number, position and equality of List items) as the Main static OrderItemList ! No inconsistencies allowed !");
            testReporter.publishEntry("Checked !\n");
        }
        @AfterEach
        void afterEach(TestInfo testInfo){
            testReporter.publishEntry("Tearing down "+testInfo.getTestMethod().get().getName()+"() ...\n");
            testReporter.publishEntry("Teared down successfully !\n");
        }
    }
    @AfterAll
    @DisplayName("Tear down Main class test")
    static void tearDown() {
        testReporter.publishEntry("Tearing down MainTest class test...\n");
        testReporter.publishEntry("Teared down successfully !\n");
    }
}
