package lesson4;

import com.geekbrains.Lesson_4.hw_4;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class TriangleAreaCalcTest {
    @Test
    @DisplayName("Позитивный тест")
    public void positiveTest() throws Exception {
        Assertions.assertEquals(hw_4.calcTriangArea(5, 5, 5), 10.825317547305483);
    }

    @Test
    @DisplayName("Позитивный тест c запятой")
    public void positiveTestFloat() throws Exception {
        Assertions.assertEquals(hw_4.calcTriangArea(1, 5.5, 6), 2.4803918541230536);
    }

    @Test
    @DisplayName("Негативный тест с отрицательным числом")
    public void negativeTest() {
        Assertions.assertThrows(Exception.class, () -> hw_4.calcTriangArea(-1, 5, 2));
    }

    @Test
    @DisplayName("Негативный тест с 0")
    public void negativeTestZero() {
        Assertions.assertThrows(Exception.class, () -> hw_4.calcTriangArea(0, 5, 2));
    }
}
