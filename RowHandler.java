import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.util.ArrayList;
import java.util.Iterator;

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

    public void determineJobs(XSSFRow row){

        Iterator<Cell> cellIterator = row.cellIterator();
        String jobs = "";
        while (cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();
            switch (cell.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:

                    break;
                case Cell.CELL_TYPE_STRING:
                    String job = parser.getJob(cell.getStringCellValue());
                    if(!jobs.contains(job)){
                        jobs += job + " ";
                    }
                    break;
            }
        }
        addToLists(row, jobs);
    }

    public void addToLists(XSSFRow row, String jobsString){
        String[] jobs = jobsString.split("\\s+");

        for(String job: jobs){
            if(job.equals("MOD")){
                MODs.add(row);
            }
            if(job.equals("Server")){
                Servers.add(row);
            }
            if(job.equals("Bartender")){
                Bartenders.add(row);
            }
            if(job.equals("Barback")){
                Barbacks.add(row);
            }
            if(job.equals("Busser")){
                Bussers.add(row);
            }
            if(job.equals("Host")){
                Hosts.add(row);
            }
            if(job.equals("Food Runner")){
                Foodrunners.add(row);
            }
            if(job.equals("Parking")){
                Parking.add(row);
            }
            if(job.equals("Security")){
                Security.add(row);
            }
            if(job.equals("Maintenance")){
                Maintenance.add(row);
            }
            if(job.equals("Sushi")){
                Sushi.add(row);
            }
            if(job.equals("Kitchen")){
                Kitchen.add(row);
            }
            if(job.equals("Dishwasher")){
                Dishwashers.add(row);
            }
            if(job.equals("Banquet Bartender")){
                BanquetBartenders.add(row);
            }
            if(job.equals("Banquet Cook")){
                BanquetCooks.add(row);
            }
            if(job.equals("Banquet Server")){
                BanquetServers.add(row);
            }
            if(job.equals("Banquet Dishwasher")){
                BanquetDishwashers.add(row);
            }
            if(job.equals("Basecamp")){
                Basecamp.add(row);
            }
            if(job.equals("Event Sales")){
                EventSales.add(row);
            }
            if(job.equals("Inventory")){
                Inventory.add(row);
            }
        }

    }

    public XSSFRow filterRow(XSSFRow row, String job){

        Iterator<Cell> cellIterator = row.cellIterator();
        boolean first = true;
        while (cellIterator.hasNext())
        {
            Cell cell = cellIterator.next();
            switch (cell.getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:

                    break;
                case Cell.CELL_TYPE_STRING:
                    String celljob = parser.getJob(cell.getStringCellValue());
                    //System.out.println(job + " " + celljob);
                    if(celljob.equals("n")){
                        break;
                    }
                    if(!celljob.equals(job)) {
                        System.out.println(job + " " + celljob);
                        System.out.println("NOMATCH");
                        if(first){
                            first = false;
                        } else {
                            cell.setCellValue("AY");
                        }
                    }

                    break;
            }
        }
        return row;
    }

    public ArrayList<ArrayList> getAll(){
        ArrayList<ArrayList> all = new ArrayList<ArrayList>();

        all.add(MODs);
        all.add(Servers);
        all.add(Bartenders);
        all.add(Barbacks);
        all.add(Bussers);
        all.add(Hosts);
        all.add(Foodrunners);
        all.add(Parking);
        all.add(Security);
        all.add(Maintenance);
        all.add(Sushi);
        all.add(Kitchen);
        all.add(Dishwashers);
        all.add(BanquetBartenders);
        all.add(BanquetCooks);
        all.add(BanquetServers);
        all.add(BanquetDishwashers);
        all.add(Basecamp);
        all.add(EventSales);
        all.add(Inventory);

        return all;

    }

    public String getJobFromList(ArrayList<XSSFRow> list){
            String job = "";

            if(list == MODs){
                return "MOD";
            }
            if(list == Servers){
                return "Server";
            }
            if(list == Bartenders){
                return "Bartender";
            }
            if(list == Barbacks){
                return "Barback";
            }
            if(list == Bussers){
                return "Busser";
            }
            if(list == Hosts){
                return "Host";
            }
            if(list == Foodrunners){
                return "FoodRunner";
            }
            if(list == Parking){
                return "Parking";
            }
            if(list == Security){
                return "Security";
            }
            if(list == Maintenance){
                return "Maintenance";
            }
            if(list == Sushi){
                return "Sushi";
            }
            if(list == Kitchen){
                return "Kitchen";
            }
            if(list == Dishwashers){
                return "Dishwasher";
            }
            if(list == BanquetBartenders){
                return "BanquetBartender";
            }
            if(list == BanquetCooks){
                return "BanquetCook";
            }
            if(list == BanquetServers){
                return "BanquetServer";
            }
            if(list == BanquetDishwashers){
                return "BanquetDishwasher";
            }
            if(list == Basecamp){
                return "Basecamp";
            }
            if(list == EventSales){
                return "EventSales";
            }
            if(list == Inventory){
                return "Inventory";
            }


            return "no match";
    }

    public ArrayList<ArrayList> getAllFiltered(){
        ArrayList<ArrayList> all = getAll();
        ArrayList<ArrayList> newAll = new ArrayList<ArrayList>();

        for(int i = 0; i < all.size(); i++){
            ArrayList<XSSFRow> job = all.get(i);
            for(int j = 0; j < job.size(); j++) {
                XSSFRow filteredRow = filterRow(job.get(j), getJobFromList(job));
                job.remove(j);
                job.add(j,filteredRow);
            }
            newAll.add(job);
        }

        return newAll;

    }


}
