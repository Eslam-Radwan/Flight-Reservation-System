package edu.asu.flightreservationsystem;

public class BookingData {
    private static final BookingData instane = new BookingData();

    private Booking bookingData;

    public static BookingData getInstane() {
        return instane;
    }

    public Booking getBookingData() {
        return bookingData;
    }

    public void setBookingData(Booking bookingData) {
        this.bookingData = bookingData;
    }
}
