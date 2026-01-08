import javax.xml.crypto.Data;
import java.util.Date;

public class Filter {
    private String model;
    private CarType type;
    private String name;
    private double price;
    private Date startdate;
    private Date enddate;

    Filter(String model, CarType type, String name, double price, Date startdate, Date enddate) {
        this.model = model;
        this.type = type;
        this.name = name;
        this.price = price;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public String getModel() { return model; }
    public CarType getType() { return type; }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public Date getStartDate() { return startdate; }
    public Date getEndDate() { return enddate; }

}