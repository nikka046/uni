import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

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

	String correctInputs[] = {
			new String("Y"),
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

	String oneWrongInputs[] = {
			new String("Y"),
			new String("Frankie"),
			new String("32"),
			new String("New York"),
			new String("1929"),
			new String("Eleanor"),
			new String("6"),
			new String("Harvard"),
			new String("Theodore"),
			new String("Polio"),
			new String("63"),
	};

	@BeforeEach
	public void setup() {
		this.outputHarness = new OutputCapturer();
		this.outputHarness.start();
	}
	
	@AfterEach
	public void tearDown() {
		this.outputHarness.stop();
	}
	
	private String readFile(String filename) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(filename));
		return new String(encoded, "UTF-8");
	}
	
	private boolean validateSaveFormat() {
		try {
			String contents = readFile("save.txt");
			String lines[] = contents.split("\\r?\\n");
			int i = 1;
			for (String line: lines) {
				
				if (i == lines.length) {
					if (!line.matches("\\s*\\d*\\s*,\\s*\\d*\\s*,\\s*\\d+(\\..*)?")) {
						return false;
					}
				} else {
					if (!line.matches("[^,]*,[^,]*,[^,]*")) {
						return false;
					}
				}
				i++;
			}
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	private Integer getScore() {
		try {
			String contents = readFile("save.txt");
			String lines[] = contents.split("\\r?\\n");
			String lastLine = lines[lines.length-1];
			
			String fields[] = lastLine.split("\\s*,\\s*");
			
			int score = new Double(Double.parseDouble(fields[0])).intValue();
			int total = new Double(Double.parseDouble(fields[1])).intValue();
			Double percent = new Double(Double.parseDouble(fields[2]));
			double delta = (percent - (100.0*score/total));
			if (Math.abs(delta)>0.01) {
				return null;
			}
			return Integer.valueOf(score);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Nested
	@DisplayName("All correct")
	class TestAllRight {
		String out;
		Quiz quiz;
		
		@BeforeEach
		public void setup() {
			Integer[] randoms = {};
		
			Toolbox.setTestingData(randoms, correctInputs);
			try {
				quiz = new Quiz("Questions.txt");
			} catch (Exception e) {
				fail("unexpected exception");
			}
			out = outputHarness.getOutput();
		}
		
		@Test
		void askedQuestions() {
			assertTrue(out.contains("By what initials was Franklin Roosevelt better known"), "should ask questions");
			assertTrue(out.contains("At what age did Franklin Roosevelt die"), "should ask questions");
		}
		
		@Test
		void nothingWrong() {
			assertFalse(out.contains("rong") || out.contains("ncorrect"), "should not have got anything wrong");		
		}
		
		@Test
		void wroteFile() {
			assertTrue(validateSaveFormat(), "save.txt should have the right format");
			assertEquals(getScore(), Integer.valueOf(10), "should have marked correctly");
		}
	}
	
	@Nested
	@DisplayName("One wrong")
	class TestOneWrong {
		String out;
		Quiz quiz;
		
		@BeforeEach
		public void setup() {
			Integer[] randoms = {};
		
			Toolbox.setTestingData(randoms, oneWrongInputs);
			try {
				quiz = new Quiz("Questions.txt");
			} catch (Exception e) {
				fail("unexpected exception");
			}
			out = outputHarness.getOutput();
		}
		
		@Test
		void gaveCorrectAnswer() {
			assertTrue(out.contains("FDR"), "should give the correct answer");
		}
		
		@Test
		void wroteFile() {
			assertTrue(validateSaveFormat(), "save.txt should have the right format");
			assertEquals(Integer.valueOf(9), getScore(), "should have marked correctly");
		}
	}

}
