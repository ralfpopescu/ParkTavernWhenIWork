/**
 * Created by ralfpopescu on 4/27/17.
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Parser {

    public Parser(){

    }

    //MOD, Server, Bartender, Barback, Busser, Host, Food Runner, Parking, Security, Maintenance, Sushi, Kitchen
    //Dishwasher, Banquet Bartender, Banquet Cook, Banquet Server, Banquet Dishwasher, Basecamp, Event Sales, Inventory

    public String getJob(String cell){
        String job = "";

        if(cell.contains("MOD")){
            return "MOD";
        }
        if(cell.contains("Server")){
            return "Server";
        }
        if(cell.contains("Bartender")){
            return "Bartender";
        }
        if(cell.contains("Barback")){
            return "Barback";
        }
        if(cell.contains("Busser")){
            return "Busser";
        }
        if(cell.contains("Host")){
            return "Host";
        }
        if(cell.contains("Food Runner")){
            return "FoodRunner";
        }
        if(cell.contains("Parking")){
            return "Parking";
        }
        if(cell.contains("Security")){
            return "Security";
        }
        if(cell.contains("Maintenance")){
            return "Maintenance";
        }
        if(cell.contains("Sushi")){
            return "Sushi";
        }
        if(cell.contains("Kitchen")){
            return "Kitchen";
        }
        if(cell.contains("Dishwasher")){
            return "Dishwasher";
        }
        if(cell.contains("Banquet Bartender")){
            return "BanquetBartender";
        }
        if(cell.contains("Banquet Cook")){
            return "BanquetCook";
        }
        if(cell.contains("Banquet Server")){
            return "BanquetServer";
        }
        if(cell.contains("Banquet Dishwasher")){
            return "BanquetDishwasher";
        }
        if(cell.contains("Basecamp")){
            return "Basecamp";
        }
        if(cell.contains("Event Sales")){
            return "EventSales";
        }
        if(cell.contains("Inventory")){
            return "Inventory";
        }


        return "no match";
    }


}
