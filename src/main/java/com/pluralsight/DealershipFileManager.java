package com.pluralsight;

import java.io.*;

import java.util.regex.Pattern;

public class DealershipFileManager {


    private static String fileName = "inventory.csv";


    public static Dealership getDealership() {

        try {
            Dealership dealership = null;
            FileReader dealerShipLog = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(dealerShipLog);


            String dealerShipCsv;
            dealerShipCsv = bufferedReader.readLine();

            if (dealerShipCsv != null) {
                String[] dealershipCsvParts = dealerShipCsv.split(Pattern.quote("|"));
                String dealerID = dealershipCsvParts[0];
                String dealerName = dealershipCsvParts[1];
                String dealerAddress = dealershipCsvParts[2];
                dealership = new Dealership(dealerID, dealerName, dealerAddress);
            }

                String inputString;

                while ((inputString = bufferedReader.readLine()) != null) {
                    if (inputString.trim().isEmpty()) {
                        continue;
                    }

                    String[] parts = inputString.split(Pattern.quote("|"));

                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);

                if(dealership != null){
                    dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
                }

            }
                return dealership;
            } catch(IOException e){
                throw new RuntimeException(e);
            }
        }



    public static void saveDealership(Dealership dealership) {

            try {
                FileWriter dealerShipLog = new FileWriter(fileName, true);
                BufferedWriter bufferedWriter = new BufferedWriter(dealerShipLog);


                Vehicle v = dealership.getAllVehicles().getLast();
                bufferedWriter.write("\n" + v.toStringLog());



                bufferedWriter.close();

            } catch (IOException e) {

                throw new RuntimeException(e);
            }


    }


}

