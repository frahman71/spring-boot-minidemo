package se.webstep.springbootdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import se.webstep.springbootdemo.entities.UserAccount;


@Repository
public class UserAccountDAOImpl implements UserAccountDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void addUserAccount(UserAccount userAccount){
        if(!userAccountForUserIdExists(userAccount.getUserName())) {
            em.persist(userAccount);
        }
    }

    @Override
    @Transactional
    public void updateUserAccount(UserAccount userAccount){
        em.merge(userAccount);
    }

    @Override
    public boolean userAccountForUserIdExists(String userName){
        Query query=em.createQuery("Select u from UserAccount u where userName=:userName");
        query.setParameter("userName",userName);
        return !query.getResultList().isEmpty();
    }

    @Override
    public List<UserAccount> getAllUserAccountsForCustomer(String customerId){
        Query query=em.createQuery("Select u from UserAccount u where customerId=:customerId", UserAccount.class);
        query.setParameter("customerId",customerId);

        return (List<UserAccount>) query.getResultList();
    }

    @Override
    @Transactional
    public void deleteUserAccountForCustomer(String userName) {
        UserAccount userAccount=new UserAccount(null,userName,null,null);
        em.remove(em.contains(userAccount) ? userAccount : em.merge(userAccount));
    }

}
