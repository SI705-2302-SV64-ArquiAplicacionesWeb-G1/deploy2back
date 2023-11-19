package pe.edu.upc.aww.werecycle.dtos;

public class NumberOfEventsPerLocationDTO {
    public int QuantityOfEvents;

    public String City;

    public int getQuantityOfEvents() {
        return QuantityOfEvents;
    }

    public void setQuantityOfEvents(int quantityOfEvents) {
        QuantityOfEvents = quantityOfEvents;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
