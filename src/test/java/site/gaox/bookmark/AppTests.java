package site.gaox.bookmark;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p> App Test </p>
 *
 * @author gaox·Eric
 * @date 2023-04-01 00:00
 */
@SpringBootTest
class AppTests {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("begin All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("begin Each");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("end Each");
    }

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
}
