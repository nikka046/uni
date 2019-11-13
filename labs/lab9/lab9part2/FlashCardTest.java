import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FlashCardTest {

	@Test
	void test() {
		String q = "Question";
		String a = "Answer";
		
		FlashCard fc = new FlashCard(q, a);
		
		assertEquals(q, fc.getQuestion(), "getQuestion returns the question on the flash card");
		assertEquals(a, fc.getAnswer(), "getAnswer returns the answer on the flash card");
	}

}
