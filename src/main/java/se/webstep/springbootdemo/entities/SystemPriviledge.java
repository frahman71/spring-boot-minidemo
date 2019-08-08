package se.webstep.springbootdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYSTEM_PRIVILEDGES")
public class SystemPriviledge {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PRIVILEDGE_ID")
    private Integer priviledgeId;
    @Column(name="SYSTEM_FUNCTION_NAME")
    private String systemFunctionName;
    @Column(name="PRIVILEDGE_DESCRIPTION")
    private String priviledgeDescription;
    @Column(name="ROLE_NAME")
    private String roleName;

    public SystemPriviledge(){

    }

    public SystemPriviledge(String systemFunctionName, String priviledgeDescription, String roleName) {
        this.systemFunctionName = systemFunctionName;
        this.priviledgeDescription = priviledgeDescription;
        this.roleName = roleName;
    }

    public Integer getPriviledgeId() {
        return this.priviledgeId;
    }

    public void setPriviledgeId(Integer priviledgeId) {
        this.priviledgeId = priviledgeId;
    }

    public String getSystemFunctionName() {
        return systemFunctionName;
    }

    public void setSystemFunctionName(String systemFunctionName) {
        this.systemFunctionName = systemFunctionName;
    }

    public String getPriviledgeDescription() {
        return priviledgeDescription;
    }

    public void setPriviledgeDescription(String priviledgeDescription) {
        this.priviledgeDescription = priviledgeDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
