package OnetoMany;

import javax.persistence.*;

@Entity
@Table(name = "customerDetalis")

public class customerClass {
    public customerClass(String customerNumber, String cAddress, int id) {
        this.customerNumber = customerNumber;
        this.cAddress = cAddress;
        this.id = id;
    }

    @Column(name = "Cmonumber")
    private String customerNumber;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "cwaddress")

    private  String cAddress;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private int id;
}
