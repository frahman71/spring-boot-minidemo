package se.webstep.springbootdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.webstep.springbootdemo.dao.SystemPriviledgesDAO;
import se.webstep.springbootdemo.entities.SystemPriviledge;


@Service
public class SystemPriviledgeService {

    @Autowired
    private SystemPriviledgesDAO systemPriviledgesDAO;

    public void addSystemPriviledge(SystemPriviledge systemPriviledge){
        systemPriviledgesDAO.addSystemPriviledge(systemPriviledge);
    }

    public List<SystemPriviledge> getAllSystemPriviledgesForRole(String roleName){
        return systemPriviledgesDAO.getAllSystemPriviledgesForRole(roleName);
    }

    public void removePriviledgeWithPriviledgeId(Integer priviledgeId){
        systemPriviledgesDAO.removeSystemPriviledgeWithPriviledgeId(priviledgeId);
    }


    public boolean systemPriviledgeExist(Integer priviledgeId){
        return systemPriviledgesDAO.systemPriviledgeExist(priviledgeId);
    }

    public boolean userRoleHasPriviledge(String roleName, Integer priviledgeId){
        return systemPriviledgesDAO.userRoleHasPriviledge(roleName, priviledgeId);
    }

}
