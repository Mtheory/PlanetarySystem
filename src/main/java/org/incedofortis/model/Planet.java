package org.incedofortis.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    "description"
}))
public class Planet implements Serializable{
    @Id @GeneratedValue
    Long id;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    Float planetMass;
    @Column(nullable = false)
    Float distanceFromTheSun;

    public Float getPlanetMass()
    {
        return planetMass;
    }

    public void setPlanetMass(Float planetMass)
    {
        this.planetMass = planetMass;
    }

    public Float getDistanceFromTheSun()
    {
        return distanceFromTheSun;
    }

    public void setDistanceFromTheSun(Float distanceFromTheSun)
    {
        this.distanceFromTheSun = distanceFromTheSun;
    }    
    public Planet(String description)
    {
        this.description = description;
    }
    public Planet()
    {
        
    }
     
    public String getDescription() {
	return description;
    }

    public void setDescription( String description ) {
	this.description = description;
    }

    public Long getId() {
	return id;
    }

    public void setId( Long id ) {
	this.id = id;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash =
                71 * hash +
                (this.description != null ? this.description.hashCode() : 0);
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
        final Planet other = (Planet) obj;
        if ((this.description == null) ? (other.description != null)
                : !this.description.equals(other.description))
        {
            return false;
        }
        return true;
    }
    
    
}
