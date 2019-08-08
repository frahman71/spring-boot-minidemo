package se.webstep.springbootdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.webstep.springbootdemo.entities.SystemPriviledge;


@Repository
public class SystemPriviledgesDAOImpl implements SystemPriviledgesDAO {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void addSystemPriviledge(SystemPriviledge systemPriviledge){
        if(!systemPriviledgeExist(systemPriviledge.getPriviledgeId())){
            em.persist(systemPriviledge);
        }
    }

    @Override
    public List<SystemPriviledge> getAllSystemPriviledgesForRole(String roleName){
        Query query=em.createQuery("Select p from SystemPriviledge p where p.roleName=:roleName");
        query.setParameter("roleName",roleName);
        return query.getResultList();
    }

    @Override
    public boolean userRoleHasPriviledge(String roleName, Integer priviledgeId){
        Query query=em.createQuery("Select p from SystemPriviledge p where p.roleName=:roleName and p.priviledgeId=:priviledgeId");
        query.setParameter("roleName",roleName);
        query.setParameter("priviledgeId",priviledgeId);

        return !query.getResultList().isEmpty();
    }

    @Override
    public boolean systemPriviledgeExist(Integer priviledgeId){
        Query query=em.createQuery("Select p from SystemPriviledge p where p.priviledgeId=:priviledgeId");
        query.setParameter("priviledgeId",priviledgeId);
        return !query.getResultList().isEmpty();
    }

    @Override
    @Transactional
    public void removeSystemPriviledgeWithPriviledgeId(Integer systemPriviledgeId){
        SystemPriviledge systemPriviledge=new SystemPriviledge();
        systemPriviledge.setPriviledgeId(systemPriviledgeId);

        em.remove(em.contains(systemPriviledge) ? systemPriviledge : em.merge(systemPriviledge));
    }

}
