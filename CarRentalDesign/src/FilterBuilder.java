import java.util.Date;

public class FilterBuilder {
    private String model = "";
    private CarType type = CarType.SIDAN;
    private String name = "";
    private double price = 0.0;
    private Date startdate = null;
    private Date enddate = null;

    public FilterBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public FilterBuilder setType(CarType type) {
        this.type = type;
        return this;
    }

    public FilterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public FilterBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public FilterBuilder setStartDate(Date startdate) {
        this.startdate = startdate;
        return this;
    }
    public FilterBuilder setEndDate(Date enddate) {
        this.enddate = enddate;
        return this;
    }
    public Filter build() {
        return new Filter(model, type, name, price, startdate, enddate);
    }
}