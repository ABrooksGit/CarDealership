package com.pluralsight;

import java.io.*;
import java.util.regex.Pattern;

public class DealershipFileManager {

   private static Dealership dealership;
   private static String fileName = "dealership.csv";


    public static Dealership getDealership() {
        return dealership;
    }


    public static void setDealership(Dealership dealership) {
        DealershipFileManager.dealership = dealership;
    }




    public static void readLog(){

        try{
            FileReader dealerShipLog = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(dealerShipLog);

            for (Vehicle v : getDealership().getAllVehicles()){

                String inputString;


                while ((inputString = bufferedReader.readLine()) != null){
                    if(inputString.trim().isEmpty()){
                        continue;
                    }
                   String[] parts =  inputString.split(Pattern.quote("|"));

                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType,color,odometer,price);
                    Dealership.addVehicle(vehicle);




                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }






    public static void writeToLog(){

        try{
            FileWriter dealerShipLog = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(dealerShipLog);

            for(Vehicle vehicle : dealership.getAllVehicles()) {


            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




}
