package com.pluralsight;

public class LeaseContract extends Contract {


    public LeaseContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
    }



    @Override
    public double getMonthlyPayment() {
        return 0;
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

}
