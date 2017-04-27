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
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import java.text.SimpleDateFormat;


public class SheetCreator {

    RowHandler rowHandler;
    Parser parser = new Parser();
    XSSFRow firstRow;

    public SheetCreator(RowHandler rh, XSSFRow fr){
        rowHandler = rh;
        this.firstRow = fr;
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

        XSSFRow first = spreadsheet.createRow(rowNum);
        copyRow(firstRow, first, true);
        rowNum++;

        for(ArrayList<XSSFRow> job: all){
            String jobString = rowHandler.getJobFromList(job);
            XSSFRow jobTitle = spreadsheet.createRow(rowNum);
            Cell titleCell = jobTitle.createCell(0);
            titleCell.setCellValue(jobString);

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
            style.setFillPattern(XSSFCellStyle.SPARSE_DOTS);
            titleCell.setCellStyle(style);

            rowNum++;

            for(XSSFRow r: job){
                XSSFRow row = spreadsheet.createRow(rowNum);
                copyRowWithJobFilter(r, row, jobString);
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


    public void copyRow(XSSFRow r1, XSSFRow r2, boolean flag){
        Iterator<Cell> cellIterator = r1.cellIterator();
        int cellid = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        while (cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();
            switch (cell.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    if(flag){
                        Cell r2cellnum = r2.createCell(cellid);
                        cellid++;
                        String cellValue = sdf.format(cell.getDateCellValue());
                        r2cellnum.setCellValue(cellValue);
                    }
                    break;
                case Cell.CELL_TYPE_STRING:
                    Cell r2cell = r2.createCell(cellid);
                    cellid++;
                    r2cell.setCellValue(cell.getStringCellValue());

                    break;
            }
        }
    }

    public void copyRowWithJobFilter(XSSFRow r1, XSSFRow r2, String job){
        Iterator<Cell> cellIterator = r1.cellIterator();
        int cellid = 0;
        boolean first = true;

        while (cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();

            switch (cell.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:
                    Cell r2cellnum = r2.createCell(cellid);
                    cellid++;
                    r2cellnum.setCellValue(cell.getNumericCellValue());
                    break;

                case Cell.CELL_TYPE_STRING:
                    Cell r2cell = r2.createCell(cellid);
                    cellid++;
                    r2cell.setCellValue(cell.getStringCellValue());

                    String celljob = parser.getJob(cell.getStringCellValue());
                    //System.out.println(job + " " + celljob);
                    if(celljob.equals("n")){
                        break;
                    }
                    if(!celljob.equals(job)) {
                        System.out.println(job + " " + celljob);
                        System.out.println("!!!!");

                            r2cell.setCellValue("AY");

                    }



                    break;
            }
        }
    }
}
