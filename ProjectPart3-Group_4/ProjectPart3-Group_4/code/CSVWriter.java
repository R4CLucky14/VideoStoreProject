import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
* Writes a Datum into a CSV file.
*
* @author James Francis Haug
* @version 2013.03.30
*/
public class CSVWriter //implements DataCollector
{
	FileWriter output;
	
	/**
	* Constructor for Class CSVWriter.
	*
	* @param file File to be written to.
	*/
	public CSVWriter(File file) throws IOException
	{
		output = new FileWriter(file);
	}
	
	/**
	* Writes a Datum's key and value into a CSV file.
	*
	* @param datum Datum to be written to the CSV file.
	*/	
	public void addDatum(String stream) throws IOException
	{
		output.write(stream);
	}
	
	/**
	* 
	*Closes the file.
	*
	*/
	public void finish() throws IOException
	{
		output.close();
	}
}