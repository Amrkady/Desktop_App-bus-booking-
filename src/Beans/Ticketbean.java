
package Beans;

public class Ticketbean {
    private String date, ticketcode;
    private int busid,id,TRANSACTIONID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTicketcode() {
        return ticketcode;
    }

    public void setTicketcode(String ticketcode) {
        this.ticketcode = ticketcode;
    }

    public int getBusid() {
        return busid;
    }

    public void setBusid(int busid) {
        this.busid = busid;
    }

    public int getTRANSACTIONID() {
        return TRANSACTIONID;
    }

    public void setTRANSACTIONID(int TRANSACTIONID) {
        this.TRANSACTIONID = TRANSACTIONID;
    }
}
