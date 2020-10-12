package vn.codegym.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Role {
    @Id
    private String  roleId;
    private String  roleName;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = { @JoinColumn(name = "role_id") },
            inverseJoinColumns = { @JoinColumn(name = "username") }
    )
    Set<UserEmployee> userEmployees = new HashSet<>();

    public Set<UserEmployee> getUserEmployees() {
        return userEmployees;
    }

    public void setUserEmployees(Set<UserEmployee> userEmployees) {
        this.userEmployees = userEmployees;
    }

    public Role() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
