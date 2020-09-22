package application.data.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "db_order")
public class Order {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    @Id
    private int id;

    @Column(name = "username")
    private String userName;

    @Column(name = "guid")
    private String guid;

    @Column(name = "customer_name",nullable = false)
    private String customerName;

    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "email")
    private String email;

    @Column (name = "created_date",nullable = false)
    private Date createdDate;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "status",nullable = false)
    private String status;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private Set<OrderProduct> orderProducts = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
