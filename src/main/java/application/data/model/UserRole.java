package application.data.model;

import javax.persistence.*;

@Entity(name = "db_user_role")
public class UserRole {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column(name = "user_role_id")
    private int id;

    @Column(name = "user_id",nullable = false)
    private int userId;

    @Column(name = "role_id",nullable = false)
    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
