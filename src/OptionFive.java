import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class OptionFive {
    public static void createFile() throws IOException {
        Workbook workbook = new XSSFWorkbook(); //create new workbook using APACHE
        Sheet sheet = workbook.createSheet("List Of Exercises"); //New sheet in the workbook/file

        Font headerFont = workbook.createFont(); //create a new font style for header
        headerFont.setBold(true); //set bold
        headerFont.setFontHeightInPoints((short)14); //set font size to 14
        headerFont.setColor(IndexedColors.RED.getIndex()); //set colour to red

        CellStyle headerCellStyle = workbook.createCellStyle(); //create a new cell style for the headers
        headerCellStyle.setFont(headerFont); //change header cell style to parameters from lines 12-15
        Row headerRow = sheet.createRow(0); //create cells for the headers which would be filled later
        String[] columnHeaders = {"Name" , "Muscle Target" , "Weight"
        , "Personal Best" , "Personal Best Date"}; //list of the headings which would be used



        for(int i = 0; i< columnHeaders.length;i++){ //for loop to fill the top row which the headers and font styles
            Cell cell = headerRow.createCell(i); //create the cell
            cell.setCellValue(columnHeaders[i]); //set values to headers
            cell.setCellStyle(headerCellStyle); //set font style
        }

        int rowNum = 1; //starting row for the real exercise values
        for(excercise lift: IAFINAL.AOExcercises){ //interate for each exercise in main program ArrayList
            Row row = sheet.createRow(rowNum++); //Create a new row
            row.createCell(0).setCellValue(lift.Name); //Create new cell and fill it with the variables using getters
            row.createCell(1).setCellValue(lift.MuscleTarget);
            row.createCell(2).setCellValue(lift.Weight);
            row.createCell(3).setCellValue(lift.PersonalBest);
            row.createCell(4).setCellValue(lift.Date);
        }

        for(int i = 0; i < columnHeaders.length; i++){ //Iterate through every column again to autoresize for user
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\osaid\\Desktop\\IAFINAL\\ForUser.xlsx");
        workbook.write(fileOut);
        workbook.close();//Write to file path above and close the output stream

        IAFINAL.MainMenu(); //return to main menu
    }
}
