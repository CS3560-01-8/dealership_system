package dealership.util;

public class VehicleFilter {

    private int sold;
    private String make;
    private String model;
    private String color;

    public VehicleFilter() {
        this.sold = 0;
        this.make = "Any";
        this.model = "Any";
        this.color = "Any";
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toWhereClause() {
        String clause = "WHERE sold = '" + sold + "'";
        clause += !make.equals("Any") ? (" AND make = '" + make + "'") : "";
        clause += !model.equals("Any") ? (" AND model = '" + model + "'") : "";
        clause += !color.equals("Any") ? (" AND color = '" + color + "'") : "";
        return clause;
    }

}
