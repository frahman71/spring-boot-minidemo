package se.webstep.springbootdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLE")
public class UserRole {

    @Id
    @Column(name="ROLE_NAME")
    String roleName;

    @Column(name="ROLE_DESCRIPTION")
    String roleDescription;

    public UserRole(){

    }

    public UserRole(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
