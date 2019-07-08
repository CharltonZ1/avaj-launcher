package avaj;


import java.io.*;

public class Logger {
	private static Logger logger = null;
	private static BufferedWriter bufferedWriter = null;
	private static File file;
	private static FileWriter fileWriter;

	private Logger() {
	}

	public static Logger getLogger() {
		if (logger == null) {
			try {
				logger = new Logger();
				file = new File("simulation.txt");
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);
			} catch (IOException e) {
			}
		}
		return logger;
	}

	public void logToFile(String str) {
		try {
			bufferedWriter.write(str);
			bufferedWriter.newLine();
		} catch (IOException e) {
		}
	}

	public void close() {
		try {
			if (bufferedWriter != null)
				bufferedWriter.close();
		} catch (Exception e) {
			System.out.println("Failed to close BufferedWriter" + e);
		}
	}
}