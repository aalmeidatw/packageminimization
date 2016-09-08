package app;

import algorithm.MinimizationAlgorithm;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MinimizationAlgorithmTest {
    private MinimizationAlgorithm minimizationAlgorithm;

    @Before
    public void setUp() throws Exception {
        this.minimizationAlgorithm = new MinimizationAlgorithm();
    }

    @Test
    public void shouldSubtractValueOfRequestQuantityNeeded() throws Exception {
        assertThat(minimizationAlgorithm.quantityCalculate(20, 3), is(17));
    }

    @Test
    public void shouldReturnZeroThenInventoryQuantityMoreThanRequestQuantity() throws Exception {
        assertThat(minimizationAlgorithm.quantityCalculate(3, 20), is(0));
    }
}








