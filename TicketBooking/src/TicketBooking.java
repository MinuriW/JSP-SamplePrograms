
public class TicketBooking {
    int id;
    String seatingType;
    Double ticketCost;
    int numberOfSeats;

    public TicketBooking() {
    }

    public TicketBooking(int id, String seatingType, Double ticketCost, int numberOfSeats) {
        this.id = id;
        this.seatingType = seatingType;
        this.ticketCost = ticketCost;
        this.numberOfSeats = numberOfSeats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatingType() {
        return seatingType;
    }

    public void setSeatingType(String seatingType) {
        this.seatingType = seatingType;
    }

    public Double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    
}
