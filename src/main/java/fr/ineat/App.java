package fr.ineat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	
	private static Logger logger = LogManager.getLogger(App.class);
	
	/**
	 * reads a file and convert it to a list of Roman numbers
	 * @param fin
	 * @return list of Roman numbers
	 * @throws IOException
	 */
	public static List<String> readAndConvertFile(File fin) throws IOException {
		List<String> romanValues = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(fin));
	 
		String line = null;
		int lineNumber = 1;
		while ((line = br.readLine()) != null) {
			logger.debug("line value = " + line);
			try {
				String romanNumber = RomanConverterUtil.getRomanNumber(line);
				logger.debug("roman value = " + romanNumber);
				romanValues.add(romanNumber);
			} catch (NumberFormatException nfe) {
				logger.warn("The entry <" + line + "> in line " + lineNumber + " is not a number !!!");
			} catch (NumberOutOfRangeException noore) {
				logger.warn(noore.getMessage());
			}
			lineNumber++;
		}
	 
		br.close();
		return romanValues;
	}

	public static void main(String[] args) {
		
		if (args.length != 2) {
			return;
		}
		
		String inputPath = args[0];
		inputPath = inputPath.replace(File.separator, "/");
		logger.debug(inputPath);
		File inputFile = new File(inputPath);
		
		List<String> romanValues = null;
		
		try {
			romanValues = readAndConvertFile(inputFile);
		} catch (IOException e) {
			logger.error("Unable to open input file");
		}
		
		Path outputFile = Paths.get(args[1].replace(File.separator, "/"));
		try {
			Files.write(outputFile, romanValues, Charset.forName("UTF-8"));
		} catch (IOException e) {
			logger.error("Unable to write to output file");
		}
		
	}

}
