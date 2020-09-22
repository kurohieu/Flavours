package application.data.model;


import javax.persistence.*;

@Entity(name = "db_contact")
public class Contact {


    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "contact_id")
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


    @Column(name = "phone")
    private String phone;


    @Column(name = "comment")
    private String coment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComent() {
        return coment;
    }

    public void setComent(String coment) {
        this.coment = coment;
    }
}
