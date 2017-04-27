/**
 * Created by ralfpopescu on 4/26/17.
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.ArrayList;

public class ExcelOrganizer
{
    static XSSFRow row;
    public static void main(String[] args) throws Exception
    {
        //MOD, Server, Bartender, Barback, Busser, Host, Food Runner, Parking, Security, Maintenance, Sushi, Kitchen
        //Dishwasher, Banquet Bartender, Banquet Cook, Banquet Server, Banquet Dishwasher, Basecamp, Event Sales, Inventory

        ArrayList<XSSFRow> MOD = new ArrayList<XSSFRow>();



        FileInputStream fis = new FileInputStream(
                new File("/Users/ralfpopescu/ParkTavernWhenIWork/src/schedule.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = spreadsheet.iterator();

        while (rowIterator.hasNext())
        {
            row = (XSSFRow) rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
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
                        System.out.print(
                                cell.getStringCellValue() + " \t\t " );
                        break;
                }
            }
            System.out.println("YO");
        }
        fis.close();
    }
}
