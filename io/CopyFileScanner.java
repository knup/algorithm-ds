/* 
 * This class reads a file, and writes the content to another file,
 * essentially simulating a copy function
 * Read is done using Scanner
 *
 * @author anupkhadka
 *
 */

package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class CopyFileScanner
{

	public static void printUsage()
	{
		System.out.println("Usage: java CopyFileScanner <source> <destination>");
	}


	public static void copy(String source, String dest) throws FileNotFoundException, IOException, Exception
	{
		Scanner scanner = new Scanner(new File(source));
		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest)));
 
		while(scanner.hasNextLine()) {
			writer.write(scanner.nextLine());
			writer.write("\n");
		}
		scanner.close(); 
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
