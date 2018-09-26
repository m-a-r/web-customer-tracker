package com.mariusz.springdemo.dao;

import com.mariusz.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query =
                session.createQuery("from Customer order by lastName",
                                    Customer.class);

        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int customerId) {

        Session currentSession = sessionFactory.getCurrentSession();

        Customer tempCustomer = currentSession.get(Customer.class, customerId);

        return tempCustomer;
    }

    @Override
    public void deleteCustomer(int deleteUserId) {
        Session currentSession = sessionFactory.getCurrentSession();

        Customer tempCustomer = currentSession.get(Customer.class, deleteUserId);

        currentSession.delete(tempCustomer);

        // alternatively
//        Query theQuery = currentSession.createQuery("delete from Customer where id=:theCustomerId");
//        theQuery.setParameter("theCustomerId", deleteUserId);
//
//        theQuery.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String theSearchName) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = null;

        if((theSearchName != null) && (theSearchName.trim().length() > 0)) {

            query = currentSession
                    .createQuery("from Customer " +
                                    "where lower(lastName) like :theName " +
                                    "or lower(firstName) like :theName",
                            Customer.class);
            query.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        } else {

            query = currentSession
                    .createQuery("from Customer", Customer.class);

        }

        List<Customer> customers = query.getResultList();

        return customers;
    }
}
