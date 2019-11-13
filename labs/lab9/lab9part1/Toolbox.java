/* To use Toolbox.java, copy and paste this code into a file called Toolbox.java
 * and save it in the directory with the rest of your code.
 */

import java.io.*;
import java.lang.Integer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Random;

public class Toolbox
{
	private static Boolean testing = false;
	private static Integer[] fakeRandomNumbers;
	private static String[] fakeInputValues;
	
	private ArrayDeque<Integer> randomValues;
	private ArrayDeque<String> inputValues;
	
	Toolbox() {
		if (testing) {
			this.randomValues = new ArrayDeque<Integer>(Arrays.asList(fakeRandomNumbers));
			this.inputValues = new ArrayDeque<String>(Arrays.asList(fakeInputValues));
		}
		this.testing = testing;
	}
	
	public static void setTestingData(Integer[] randomValues, String[] inputValues) {
		testing =  true;
		fakeRandomNumbers = randomValues;
		fakeInputValues = inputValues;
	}
	
	public Integer getRandomInteger(Integer max)
	{
		if (this.testing) {
			return this.randomValues.poll();
		}
		
		Random rand = new Random();
		int number;
		number = rand.nextInt(max) + 1;
		return new Integer(number);
	}

	public Integer readIntegerFromCmd()
	{
		String number = null;
		if (this.testing) {
			System.out.println("Enter your number");
			number = this.inputValues.poll();
		} else { 
			System.out.println("Enter your number");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			try
			{
				number = br.readLine();
			}
			catch (IOException ioe)
			{
				System.err.println("There was an input error");
			}
		}
		
		try
		{
			return new Integer(number);
		}
		catch (NumberFormatException e)
		{
			System.err
					.println("There is something wrong with the number you entered");
		}
		return 0;
	}

	public String readStringFromCmd()
	{
		if (this.testing) {
			System.out.println("Enter your String");
			return this.inputValues.poll();
		}
		
		System.out.println("Enter your String");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string;
		string = null;

		try
		{
			string = br.readLine();
		}
		catch (IOException ioe)
		{
			System.err.println("There was an input error");
		}
		return string;
	}
}
