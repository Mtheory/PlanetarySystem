
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.incedofortis.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Marcin Chojnowski
 */
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames =
{
    "name"
}))
public class Moon implements Serializable
{

    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    String name;
    @ManyToOne(cascade = CascadeType.ALL)
    //@Column(nullable = false)
    Planet planet;

    public Moon(String name, Planet planet)
    {
        this.name = name;
        this.planet = planet;
    }

    public Moon()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Planet getPlanet()
    {
        return planet;
    }

    public void setPlanet(Planet planet)
    {
        this.planet = planet;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Moon other = (Moon) obj;
        if ((this.name == null) ? (other.name != null) :
                !this.name.equals(other.name))
        {
            return false;
        }
        return true;
    }
}
