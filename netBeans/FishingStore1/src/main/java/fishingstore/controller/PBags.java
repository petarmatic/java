/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fishingstore.controller;

import fishingstore.model.Bags;
import java.util.List;

/**
 *
 * @author petar
 */
public class PBags extends Processing<Bags>{

    @Override
    public List<Bags> read() {
        return session.createQuery("from Bags b order by b.id desc",Bags.class)
                .setMaxResults(10)
                .list();
                
                }

    
    
}
