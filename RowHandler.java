import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.util.ArrayList;

/**
 * Created by ralfpopescu on 4/27/17.
 */
public class RowHandler {

    Parser parser;

    //MOD, Server, Bartender, Barback, Busser, Host, Food Runner, Parking, Security, Maintenance, Sushi, Kitchen
    //Dishwasher, Banquet Bartender, Banquet Cook, Banquet Server, Banquet Dishwasher, Basecamp, Event Sales, Inventory

    ArrayList<XSSFRow> MODs = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Servers = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Bartenders = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Barbacks = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Bussers = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Hosts = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Foodrunners = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Parking = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Security = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Maintenance = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Sushi = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Kitchen = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Dishwashers = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> BanquetBartenders = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> BanquetCooks = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> BanquetServers = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> BanquetDishwashers = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Basecamp = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> EventSales = new ArrayList<XSSFRow>();
    ArrayList<XSSFRow> Inventory = new ArrayList<XSSFRow>();

    public RowHandler(){
        parser = new Parser();
    }
}
