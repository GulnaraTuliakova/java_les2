import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class task1 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getAnonymousLogger();

       
            FileHandler fileHandler = new FileHandler("log.txt");
            logger.addHandler(fileHandler);
      
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите число от -128 До 127: ");
            byte numByte = scanner.nextByte();
            logger.log(Level.INFO, "Byte is correct");
            
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(numByte);

            try (FileWriter fileWriter = new FileWriter("result.txt", false)) {
                fileWriter.write(stringBuilder.toString());
            }

            catch (Exception ex) {
                logger.log(Level.WARNING, ex.getMessage());
                ex.printStackTrace();

            }
        }

}}


