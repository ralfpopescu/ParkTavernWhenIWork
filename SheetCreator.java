/**
 * Created by ralfpopescu on 4/27/17.
 */
import java.io.*;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.CellCopyPolicy;
import java.io.File;
import java.io.FileInputStream;

public class SheetCreator {

    RowHandler rowHandler;

    public SheetCreator(RowHandler rh){
        rowHandler = rh;
    }


    public void makeSheet(){
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank sheet
        XSSFSheet spreadsheet = workbook.createSheet(
                "Schedule");

        CellCopyPolicy ccp = new CellCopyPolicy();
        ccp.setCondenseRows(true);
        ccp.setCopyCellFormula(true);
        ccp.setCopyCellStyle(true);
        ccp.setCopyCellValue(true);
        ccp.setCopyHyperlink(true);
        ccp.setCopyMergedRegions(true);
        ccp.setCopyRowHeight(true);
        ccp.setMergeHyperlink(true);

        ArrayList<ArrayList> all = rowHandler.getAllFiltered();
        int rowNum = 0;
        for(ArrayList<XSSFRow> job: all){
            String jobString = rowHandler.getJobFromList(job);
            XSSFRow jobTitle = spreadsheet.createRow(rowNum);
            Cell titleCell = jobTitle.createCell(0);
            titleCell.setCellValue(jobString);
            rowNum++;

            for(XSSFRow r: job){
                XSSFRow row = spreadsheet.createRow(rowNum);
                copyRow(r, row);
                rowNum++;
            }
        }

        //Write the workbook in file system
        try {
            FileOutputStream out = new FileOutputStream(
                    new File("Writesheet.xlsx"));
            try {
                workbook.write(out);
                out.close();
                System.out.println(
                        "Writesheet.xlsx written successfully");
            } catch (IOException e){
                System.out.println("ay");
            }
        } catch (FileNotFoundException e){
            System.out.println(
                    "shit");

    }
    }

    public void copyRow(XSSFRow r1, XSSFRow r2){
        Iterator<Cell> cellIterator = r1.cellIterator();
        int cellid = 0;

        while (cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();
            switch (cell.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(
                            cell.getNumericCellValue() + " \t\t " );
                    break;
                case Cell.CELL_TYPE_STRING:
                    Cell r2cell = r2.createCell(cellid);
                    cellid++;
                    r2cell.setCellValue(cell.getStringCellValue());

                    break;
            }
        }
    }
}
