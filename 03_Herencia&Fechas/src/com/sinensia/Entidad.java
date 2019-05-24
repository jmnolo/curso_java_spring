/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sinensia;

/**
 *
 * @author Admin
 */
public class Entidad {
        protected long id; //Para que puedan acceder las clases hijas.
        public Entidad(long id) {
            this.id = id;
        }
        public long getId() {return id;}
        public void setId(long id) {this.id = id;}
    
}
