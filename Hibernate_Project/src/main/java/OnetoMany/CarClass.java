package OnetoMany;

import javax.persistence.*;

@Entity
@Table(name = "CarData")

public class CarClass {

    public CarClass(int id, String name, String colour, int modelnumber) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.modelnumber = modelnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Carowoner")
    private String name;
    @Column(name="Carcolour")
    private String colour;
    @Column(name = "Carmodelnumber")
    private int modelnumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getModelnumber() {
        return modelnumber;
    }

    public void setModelnumber(int modelnumber) {
        this.modelnumber = modelnumber;
    }
}
