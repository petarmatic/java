package Unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void test() {
		MathUtils mathUtils= new MathUtils();
		int expected=1;
		int actual=mathUtils.add(1,1);
		assertEquals(expected, actual);
		
	}

}
