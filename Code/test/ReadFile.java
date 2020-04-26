/**
 * This class reads Question information from three files that separately contain Easy, Medium, Difficult questions to program.
 */

package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**className: ReadFile
 * packageName:test
* @author Zhouyang Wang 
 * @version 1.0
 * @since 1.8.201
 */
/**
 * This class create three ArrayList for three types of questions, store the
 * strings from files. Create as protected static in order to be used by Class
 * MultipleChoiceGui and always remain the update value.
 */
public class ReadFile {

	protected static ArrayList<String> strArray = new ArrayList<String>();

	public ReadFile() throws Exception {
	}

	/**
	 * This method read question information from files
	 * 
	 * @param choose
	 * @throws Exception
	 */
	public void toReadFile(int choose) throws Exception {
		String strPath = new String();//store the fileName in a string

		if (choose == 1)
			strPath = "..\\File\\Easy.txt";//path of easy questions
		else if (choose == 2)
			strPath = "..\\File\\Medium.txt";//path of medium questions
		else
			strPath = "..\\File\\Difficult.txt";//path of difficult questions
		// read the file
		FileReader fr = new FileReader(strPath);
		BufferedReader br = new BufferedReader(fr);
		String s = "";
		strArray.clear(); // update current strArray
		while ((s = br.readLine()) != null) // read by lines
		{
			strArray.add(s);
		}
		br.close(); // close the bufferFile
		fr.close(); // close the file
	}
}
