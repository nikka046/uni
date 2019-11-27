import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QuizTest {

	class OutputCapturer {
		private PrintStream origOut;

		private ByteArrayOutputStream outputStream;

		public void start()
		{
			this.origOut = System.out;
			this.outputStream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(this.outputStream);
			System.setOut(ps);
		}

		public String getOutput() {
			System.out.flush();
			return this.outputStream.toString().replaceAll("\\r\\n", "\n").replaceAll("\\r", "\n");
		}
		public void stop() {
			System.setOut(this.origOut);
		}
	}

	OutputCapturer outputHarness;

	@BeforeEach
	public void setup() {
		this.outputHarness = new OutputCapturer();
		this.outputHarness.start();
	}
	
	@AfterEach
	public void tearDown() {
		this.outputHarness.stop();
	}
	
	@Test
	void allRight() {
		Integer[] randoms = {};
		String inputs[] = {
				new String("FDR"),
				new String("32"),
				new String("New York"),
				new String("1929"),
				new String("Eleanor"),
				new String("6"),
				new String("Harvard"),
				new String("Theodore"),
				new String("Polio"),
				new String("63")
		};
		
		Toolbox.setTestingData(randoms, inputs);
		
		Quiz quiz = new Quiz("Questions.txt");
		String out = outputHarness.getOutput();
		outputHarness.stop();
		System.out.println(out);
		assertTrue(out.contains("By what initials was Franklin Roosevelt better known"), "should ask questions");
		assertTrue(out.contains("At what age did Franklin Roosevelt die"), "should ask questions");
		assertFalse(out.contains("rong"), "should not have got anything wrong");		
	}
	
	@Test
	void oneWrong() {
		Integer[] randoms = {};
		String inputs[] = {
				new String("Frankie"),
				new String("32"),
				new String("New York"),
				new String("1929"),
				new String("Eleanor"),
				new String("6"),
				new String("Harvard"),
				new String("Theodore"),
				new String("Polio"),
				new String("63")
		};
		
		Toolbox.setTestingData(randoms, inputs);
		
		Quiz quiz = new Quiz("Questions.txt");
		String out = outputHarness.getOutput();
		outputHarness.stop();
		System.out.println(out);
		assertTrue(out.contains("FDR"), "should give the correct answer");
		
	}

}
