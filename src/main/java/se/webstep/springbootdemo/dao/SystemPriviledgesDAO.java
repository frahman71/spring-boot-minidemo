package se.webstep.springbootdemo.dao;

import java.util.List;

import se.webstep.springbootdemo.entities.SystemPriviledge;

public interface SystemPriviledgesDAO {
    public void addSystemPriviledge(SystemPriviledge systemPriviledge);
    public List<SystemPriviledge> getAllSystemPriviledgesForRole(String roleName);
    public boolean systemPriviledgeExist(Integer priviledgeId);
    public boolean userRoleHasPriviledge(String roleName, Integer priviledgeId);
    public void  removeSystemPriviledgeWithPriviledgeId(Integer systemPriviledgeId);
}
