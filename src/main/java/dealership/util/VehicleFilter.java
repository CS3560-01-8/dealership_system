package dealership.util;

public class VehicleFilter {

    private final int sold;
    private String style;
    private String make;
    private String model;
    private String color;

    private String sortBy;
    private boolean ascendingOrder;

    public VehicleFilter() {
        this.sold = 0;
        this.style = "Any";
        this.make = "Any";
        this.model = "Any";
        this.color = "Any";
        this.sortBy = "make, model";
        this.ascendingOrder = true;
    }

    public void setStyle(String style) {
        this.style = style;
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

    public void setSortBy(String sortBy) {
        if (sortBy.equals(this.sortBy)) {
            ascendingOrder = !ascendingOrder;
        } else {
            this.sortBy = sortBy;
        }
    }

    public String toWhereClause() {
        String clause = "WHERE sold = '" + sold + "'";
        clause += !style.equals("Any") ? (" AND style = '" + style + "'") : "";
        clause += !make.equals("Any") ? (" AND make = '" + make + "'") : "";
        clause += !model.equals("Any") ? (" AND model = '" + model + "'") : "";
        clause += !color.equals("Any") ? (" AND color = '" + color + "'") : "";
        clause += " ORDER BY " + sortBy;
        clause += ascendingOrder ? " ASC" : " DESC";
        return clause;
    }

}
