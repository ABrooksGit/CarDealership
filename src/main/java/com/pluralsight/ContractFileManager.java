package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ContractFileManager {

    private final static String fileName = "contracts.csv";




    public static ArrayList<Contract> getContracts() {
        Vehicle vehicle;
        ArrayList<Contract> contracts = new ArrayList<>();
        try {
            FileReader contractList = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(contractList);

            String contractCVS;


            while ((contractCVS = bufferedReader.readLine()) != null) {
                if (contractCVS.trim().isEmpty()) {
                    continue;
                }


                String[] contractParts = contractCVS.split(Pattern.quote("|"));
                if (contractParts[0].startsWith("SALE")) {
                    String date = contractParts[1];
                    String name = contractParts[2];
                    String email = contractParts[3];
                    int vin = Integer.parseInt(contractParts[4]);
                    int year = Integer.parseInt(contractParts[5]);
                    String make = contractParts[6];
                    String model = contractParts[7];
                    String vehicleType = contractParts[8];
                    String color = contractParts[9];
                    int odometer = Integer.parseInt(contractParts[10]);
                    double price = Double.parseDouble(contractParts[11]);
                    double processingFee = Double.parseDouble(contractParts[12]);
                    boolean finance = Boolean.parseBoolean(contractParts[13]);

                    vehicle = new Vehicle(vin, year,make,model,vehicleType,color,odometer,price);
                    contracts.add(new SalesContract(date, name, email, vehicle, processingFee, finance));


                } else if (contractParts[0].startsWith("LEASE")) {
                    String date = contractParts[1];
                    String name = contractParts[2];
                    String email = contractParts[3];
                    int vin = Integer.parseInt(contractParts[4]);
                    int year = Integer.parseInt(contractParts[5]);
                    String make = contractParts[6];
                    String model = contractParts[7];
                    String vehicleType = contractParts[8];
                    String color = contractParts[9];
                    int odometer = Integer.parseInt(contractParts[10]);
                    double price = Double.parseDouble(contractParts[11]);
                    double totalVehiclePrice = Double.parseDouble(contractParts[12]);
                    double originalPrice = Double.parseDouble(contractParts[13]);

                    vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                    contracts.add(new LeaseContract(date, name, email, vehicle, totalVehiclePrice, originalPrice));

                }

            }
            return contracts;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void saveContracts(Contract contract){

        try{
            FileWriter contractWriter = new FileWriter(fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(contractWriter);

            if(contract instanceof SalesContract){
                bufferedWriter.write("\n" + ((SalesContract) contract).toStringLog());
            } else if(contract instanceof  LeaseContract){
                bufferedWriter.write("\n" + ((LeaseContract) contract).toStringLog());
            }




            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }










}
