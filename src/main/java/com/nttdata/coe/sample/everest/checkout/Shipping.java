package com.nttdata.coe.sample.everest.checkout;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.nttdata.coe.sample.everest.uzer.Uzer;
import com.nttdata.coe.sample.everest.uzer.UzerItem;

/**
 * @author arungupta
 */
@Named
@SessionScoped
public class Shipping implements Serializable {
    
    @PersistenceContext EntityManager em;
    
    @Inject UzerItem uzer2;
//    String login;
//    
//    String name;
//    String address1;
//    String address2;
//    String city;
//    String zip;
//    String country;
//    String creditcard;
    
    public Shipping() { }
    
    public void findShippingDetail() {
        System.out.println("LOGIN: " + uzer2.getLogin());
        Uzer uzer = em.createNamedQuery("Uzer.findByLogin", Uzer.class).setParameter("login", uzer2.getLogin()).getSingleResult();
        uzer.setUsername(uzer2.getUsername());
        uzer.setAddress1(uzer2.getAddress1());
        uzer.setAddress2(uzer2.getAddress2());
        uzer.setCity(uzer2.getCity());
        uzer.setZip(uzer2.getZip());
        uzer.setCountry(uzer2.getCountry());
        uzer.setCreditcard(uzer2.getCreditcard());
    }
}
