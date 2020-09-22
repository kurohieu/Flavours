package application.data.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "db_sale")
public class Sale {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sale_id")
    @Id
    private int sale;

    @Column(name = "sale_name")
    private String saleName;

    @Column(name = "sale_percent",nullable = false)
    private int salePercent;

    @Column(name = "sale_money",nullable = false)
    private double saleMoney;

    @Column(name = "start_date",nullable = false)
    private Date startDate;

    @Column(name = "end_date",nullable = false)
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sale")
    private Set<SaleProduct> saleProducts = new HashSet<>();

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    public double getSaleMoney() {
        return saleMoney;
    }

    public void setSaleMoney(double saleMoney) {
        this.saleMoney = saleMoney;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<SaleProduct> getSaleProducts() {
        return saleProducts;
    }

    public void setSaleProducts(Set<SaleProduct> saleProducts) {
        this.saleProducts = saleProducts;
    }
}
