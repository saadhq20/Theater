package com.company;

import java.util.*;

public class Theater {
    private final String theaterName;
    private Collection<Seat> Seats = new ArrayList<>();

    public Theater(String name, int numRows, int seatsPerRow){
        theaterName = name;
        int lastRow = 'A' + (numRows-1); //A is in ASCII 65 so A + 1 = 65 + 1 = 66 which in ASCII is B.

        for(char row = 'A'; row<=lastRow; row++ ){
            for(int seatNum =1 ; seatNum<= seatsPerRow; seatNum++){
                Seat seat  = new Seat(row+ String.format("%02d", seatNum));
                Seats.add(seat);
            }
        }
    }

    public String getTheaterName(){
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = null;
        for(Seat seat: Seats){
        if (seat.getSeatNumber().equals(seatNumber)){
            requestedSeat = seat;
            break;
            }
        }
        if(requestedSeat ==null){
            System.out.println("There is no seat: " +seatNumber);
            return false;
        }
        return requestedSeat.reserve();
    }

    public void getSeats(){
        for(Seat seats : Seats){
            System.out.println(seats.getSeatNumber());
        }
    }

    private class Seat{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber){
            this.seatNumber = seatNumber;
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat "+ seatNumber+ " reserved.");
                return true;
            }else {
                return false;
            }
        }

        public boolean cancel(){
            if(!this.reserved){
                this.reserved = false;
                System.out.println("Seat "+ seatNumber+ " cancelled.");
                return true;
            }else {
                return false;
            }
        }

        public String getSeatNumber(){
            return seatNumber;
        }
    }




}
