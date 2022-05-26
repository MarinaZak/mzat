package day6.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Address {

//    @id
    private Integer id_address;
    private String country;
    private String city;

    @ManyToMany
    @JoinTable(
        name="address_student",
        joinColumns=@JoinColumn(name="id_student"),
        inverseJoinColumns=@JoinColumn(name="id_address")
    )

    private Set<Student> studentSet;

    public Integer getId_address() {
        return id_address;
    }

    public void setId_address(Integer id_address) {
        this.id_address = id_address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id_address=" + id_address +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
