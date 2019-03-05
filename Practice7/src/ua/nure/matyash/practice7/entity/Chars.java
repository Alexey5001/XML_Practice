


package ua.nure.matyash.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Chars complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Chars">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{}Type"/>
 *         &lt;element name="Sits" type="{}Sits"/>
 *         &lt;element name="Ammunition" type="{}Ammunition" minOccurs="0"/>
 *         &lt;element name="Radar" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Chars", propOrder = {
    "type",
    "sits",
    "ammunition",
    "radar"
})
public class Chars {

    @XmlElement(name = "Type", required = true)
    @XmlSchemaType(name = "string")
    protected Type type;
    @XmlElement(name = "Sits")
    @XmlSchemaType(name = "integer")
    protected int sits;
    @XmlElement(name = "Ammunition")
    protected Ammunition ammunition;
    @XmlElement(name = "Radar")
    protected boolean radar;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setType(Type value) {
        this.type = value;
    }

    /**
     * Gets the value of the sits property.
     * 
     */
    public int getSits() {
        return sits;
    }

    /**
     * Sets the value of the sits property.
     * 
     */
    public void setSits(int value) {
        this.sits = value;
    }

    /**
     * Gets the value of the ammunition property.
     * 
     * @return
     *     possible object is
     *     {@link Ammunition }
     *     
     */
    public Ammunition getAmmunition() {
        return ammunition;
    }

    /**
     * Sets the value of the ammunition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ammunition }
     *     
     */
    public void setAmmunition(Ammunition value) {
        this.ammunition = value;
    }

    /**
     * Gets the value of the radar property.
     * 
     */
    public boolean isRadar() {
        return radar;
    }

    /**
     * Sets the value of the radar property.
     * 
     */
    public void setRadar(boolean value) {
        this.radar = value;
    }

}
