import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.log4j.BasicConfigurator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReport {
    public static void main(String[] args) {
        try {
            OrderReport();
        } catch (IOException ex) {
            Logger.getLogger(ExcelReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
@SuppressWarnings("unchecked")    
public static void UserReport() throws FileNotFoundException, IOException{
       BasicConfigurator.configure();

      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet( " User Report ");
      
      //Create row object
      XSSFRow row;
      List<List<String>> data=StaticFunction.getFileData("User.txt"); 
      Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
      empinfo.put( "1", new Object[] {
         "Username", "Full Name", "Address","Phone Number","Role" });

      for (int i = 0,index=2; i <data.size(); i++,index++) {
        empinfo.put( String.valueOf(index), new Object[] {
           data.get(i).get(0), data.get(i).get(2), data.get(i).get(3),data.get(i).get(4),data.get(i).get(5) });        
      }

      //Iterate over data and write to sheet
      Set < String > keyid = empinfo.keySet();
      int rowid = 0;
      
      for (String key : keyid) {
         row = spreadsheet.createRow(rowid++);
         Object [] objectArr = empinfo.get(key);
         int cellid = 0;
         
         for (Object obj : objectArr){
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(
         new File("UserReport.xlsx"));
      
      workbook.write(out);
      out.close();
      System.out.println("UserReport.xlsx written successfully");    
}

@SuppressWarnings("unchecked")    
public static void ParcelReport() throws FileNotFoundException, IOException{
       BasicConfigurator.configure();

      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet( " Parcel Report ");
      
      //Create row object
      XSSFRow row;
      List<List<String>> data=StaticFunction.getFileData("Parcel.txt"); 
      Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
      empinfo.put( "1", new Object[] {
         "Parcel ID", "Address", "Weight(kg)","Size","Price(RM)","Status","Delivery Type","Order ID","Assigned To","Date" });

      for (int i = 0,index=2; i <data.size(); i++,index++) {
        empinfo.put( String.valueOf(index), new Object[] {
           data.get(i).get(0), data.get(i).get(1), data.get(i).get(2),data.get(i).get(3),data.get(i).get(4),
           data.get(i).get(5), data.get(i).get(6), data.get(i).get(7),data.get(i).get(8),data.get(i).get(9),
        });        
      }

      //Iterate over data and write to sheet
      Set < String > keyid = empinfo.keySet();
      int rowid = 0;
      
      for (String key : keyid) {
         row = spreadsheet.createRow(rowid++);
         Object [] objectArr = empinfo.get(key);
         int cellid = 0;
         
         for (Object obj : objectArr){
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(
         new File("ParcelReport.xlsx"));
      
      workbook.write(out);
      out.close();
      System.out.println("ParcelReport.xlsx written successfully");    
}

@SuppressWarnings("unchecked")    
public static void FeedbackReport() throws FileNotFoundException, IOException{
       BasicConfigurator.configure();

      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet( " Feedback Report ");
      
      //Create row object
      XSSFRow row;
      List<List<String>> data=StaticFunction.getFileData("Feedback.txt"); 
      Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
      empinfo.put( "1", new Object[] {
         "Feedback ID", "Subject", "Content","Feedback Type","Reply","Delivery Staff","Managing Staff"});

      for (int i = 0,index=2; i <data.size(); i++,index++) {
        empinfo.put( String.valueOf(index), new Object[] {
           data.get(i).get(0), data.get(i).get(1), data.get(i).get(2),data.get(i).get(3),
           data.get(i).get(4),data.get(i).get(5), data.get(i).get(6)
        });        
      }

      //Iterate over data and write to sheet
      Set < String > keyid = empinfo.keySet();
      int rowid = 0;
      
      for (String key : keyid) {
         row = spreadsheet.createRow(rowid++);
         Object [] objectArr = empinfo.get(key);
         int cellid = 0;
         
         for (Object obj : objectArr){
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(
         new File("FeedbackReport.xlsx"));
      
      workbook.write(out);
      out.close();
      System.out.println("FeedbackReport.xlsx written successfully");    
}

@SuppressWarnings("unchecked")    
public static void OrderReport() throws FileNotFoundException, IOException{
       BasicConfigurator.configure();

      //Create blank workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      
      //Create a blank sheet
      XSSFSheet spreadsheet = workbook.createSheet( " Order Report ");
      
      //Create row object
      XSSFRow row;
      List<List<String>> data=StaticFunction.getFileData("Feedback.txt"); 
      Map < String, Object[] > empinfo = new TreeMap < String, Object[] >();
      empinfo.put( "1", new Object[] {
         "Order ID", "Status"});

      for (int i = 0,index=2; i <data.size(); i++,index++) {
        empinfo.put( String.valueOf(index), new Object[] {
           data.get(i).get(0), data.get(i).get(1)
        });        
      }

      //Iterate over data and write to sheet
      Set < String > keyid = empinfo.keySet();
      int rowid = 0;
      
      for (String key : keyid) {
         row = spreadsheet.createRow(rowid++);
         Object [] objectArr = empinfo.get(key);
         int cellid = 0;
         
         for (Object obj : objectArr){
            Cell cell = row.createCell(cellid++);
            cell.setCellValue((String)obj);
         }
      }
      //Write the workbook in file system
      FileOutputStream out = new FileOutputStream(
         new File("OrderReport.xlsx"));
      
      workbook.write(out);
      out.close();
      System.out.println("OrderReport.xlsx written successfully");    
}
}
