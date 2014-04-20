/* 
 * This class reads a file, and writes the content to another file,
 * essentially simulating a copy function
 * Read is done using BufferReader
 *
 * @author anupkhadka
 *
 */

package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class CopyFileBufferReader
{

	public static void printUsage()
	{
		System.out.println("Usage: java CopyFileBufferReader <source> <destination>");
	}


	public static void copy(String source, String dest) throws FileNotFoundException, IOException, Exception
	{
		BufferedReader reader = new BufferedReader(new FileReader(source));
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest)));
		String line;
 
		while((line = reader.readLine()) != null) {
			writer.write(line);
			writer.write("\n");
		}
		reader.close(); 
		writer.close();
	}

	public static void main(String [] args)
	{
		if(args.length < 2) {
			printUsage();
		} else {
			try {
				copy(args[0], args[1]);
			} catch (FileNotFoundException fe) {
				fe.printStackTrace();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
