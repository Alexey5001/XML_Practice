

package ua.nure.matyash.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ammunition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ammunition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Rokets" type="{}Rokets"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ammunition", propOrder = {
    "rokets"
})
public class Ammunition {

    @XmlElement(name = "Rokets")
    @XmlSchemaType(name = "integer")
    protected int rokets;

    /**
     * Gets the value of the rokets property.
     * 
     */
    public int getRokets() {
        return rokets;
    }

    /**
     * Sets the value of the rokets property.
     * 
     */
    public void setRokets(int value) {
        this.rokets = value;
    }

}
