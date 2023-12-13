package edu.asu.mainPackage;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface PaymentProcess {
    default Booking paymentProcess(Booking booking) {
        Payment unvalidPayment = new Payment(booking.getNumberOfPassengers(), booking.getFlight().getSeatPrice(booking.getFlightClass()));
        Scanner scanner = new Scanner(System.in);
        int paymentMethodChoice = 0;
        String[] methodChoice = new String[3];
        methodChoice[0] = "visa";
        methodChoice[1] = "mastercard";
        methodChoice[2] = "paypal";

        String paymentMethod;
        String cardNumber;
        String cvv;
        String expiryDate;


        System.out.printf("Confirm Payment: \n Total Amount: %f \n", unvalidPayment.getPaymentAmount());

        //take payment method
        System.out.print(" [1] visa \n [2] mastercard \n [3] paypal\n");
        System.out.println(" Enter your Payment Method: ");
        boolean valid = true;

        while (valid) {
            try {
                paymentMethodChoice = scanner.nextInt();
                if (paymentMethodChoice > 0 && paymentMethodChoice < 4) {
                    valid = false;
                } else {
                    System.out.println("Invalid range.  Please enter a number: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number: ");
            }
            //clean puffer of scanner input
            scanner.nextLine();

        }
        paymentMethod = methodChoice[paymentMethodChoice - 1];

        //take cardNumber
        System.out.println("Enter your card number: ");
        cardNumber = scanner.nextLine();

        //take expiryDate
        System.out.println("Enter ExpiryDate: ");
        expiryDate = scanner.nextLine();
        //take cardNumber
        System.out.println("Enter cvv: ");
        cvv = scanner.nextLine();

        //valid payment
        unvalidPayment.ValidPayment(paymentMethod, cardNumber, expiryDate, cvv);
        booking.setBookingStatus("VAlid");
        return booking;
    }
}
