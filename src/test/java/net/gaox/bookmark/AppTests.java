package net.gaox.bookmark;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import net.gaox.bookmark.entity.BaseEntity;

/**
 * <p> App Test </p>
 *
 * @author gaox·Eric
 * @date 2023-04-01 00:00
 */
@SpringBootTest
class AppTests {

    /**
     * 只执行一次，执行时机是在所有测试和 @BeforeEach 注解方法之前
     */
    @BeforeAll
    public static void beforeAll() {
        System.out.println("begin All");
    }

    /**
     * 在每个测试执行之前执行
     */
    @BeforeEach
    public void beforeEach() {
        System.out.println("begin Each");
    }

    /**
     * 在每个测试执行之后执行
     */
    @AfterEach
    public void afterEach() {
        System.out.println("end Each");
    }

    /**
     * 只执行一次，执行时机是在所有测试和 @AfterEach 注解方法之后
     */
    @AfterAll
    public static void afterAll() {
        System.out.println("end All");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void assertTest(){
        /**
         * assert(断言)。一般的断言，无非是检查一个实例的属性（比如，判空与判非空等），或者对两个实例进行比较（比如，检查两个实例对象是否相等）等
         *
         * assertEquals(A,B,"message")，判断A对象和B对象是否相等，这个判断在比较两个对象时调用了equals()方法。
         *
         * assertSame(A,B,"message")，判断A对象与B对象是否相同，使用的是==操作符。
         *
         * assertTrue(A,"message")，判断A条件是否为真。
         *
         * assertFalse(A,"message")，判断A条件是否不为真。
         *
         * assertNotNull(A,"message")，判断A对象是否不为null。
         *
         * assertArrayEquals(A,B,"message")，判断A数组与B数组是否相等
         */

        BaseEntity base = new BaseEntity();
        BaseEntity base2 = new BaseEntity();


    }
}
