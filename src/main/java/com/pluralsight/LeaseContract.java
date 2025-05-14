package com.pluralsight;

public class LeaseContract extends Contract {

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, double totalVehiclePrice, double originalPrice ) {
        super("Lease", date, customerName, customerEmail, vehicle);
        this.expectedEndingValue = totalVehiclePrice * .5;
        this.leaseFee = originalPrice *.07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {

        double totalVehiclePrice = getVehicle().getPrice();

        double originalPrice = getVehicle().getPrice();

       this.expectedEndingValue = totalVehiclePrice * .5;


       this.leaseFee = originalPrice *.07;

       return totalVehiclePrice +  leaseFee - expectedEndingValue;






    }



    @Override
    public double getMonthlyPayment() {

        double totalVehiclePrice = getVehicle().getPrice();



        double financeAmount = totalVehiclePrice - expectedEndingValue;

        financeAmount += leaseFee;

        double interestRate = 0.04;
        int financedLease = 36;

        double monthlyInterestRate = interestRate / 12;


        double interest = financeAmount * monthlyInterestRate;

         return (financeAmount + interest) / financedLease;

    }

    @Override
    public String toString() {
        return String.format("LEASE|%s|%s|%s|%s|%s|%.2f",
                getDate(), getCustomerName(), getCustomerEmail(),
                getVehicle(), getTotalPrice(), getMonthlyPayment());
    }

}
