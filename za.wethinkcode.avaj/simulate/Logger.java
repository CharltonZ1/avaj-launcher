package za.wethinkcode.avaj.simulate;

import  java.io.*;

public class    Logger {
    private static Logger           createdLogFile = null;
    private static BufferedWriter   bufferedWriter = null;
    private static File             file = null;
    private static FileWriter       fileWriter = null;

    private     Logger() {}

    public static Logger    getLogFile() {
        if (createdLogFile == null) {
            try {
                createdLogFile = new Logger();
                file = new File("simulation.txt");
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (IOException e) {}
        }
        return createdLogFile;
    }

    public void logToFile(String str) {
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
        } catch (Exception e) {
            System.out.println("Error in closing the BufferedWriter" + e);
        }
    }
}