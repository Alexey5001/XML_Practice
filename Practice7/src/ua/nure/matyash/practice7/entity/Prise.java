


package ua.nure.matyash.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Prise complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Prise">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="convert" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prise")
public class Prise {

    @XmlAttribute(name = "convert")
    protected String convert;
    @XmlAttribute(name = "value")
    protected Integer value;

    /**
     * Gets the value of the convert property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConvert() {
        return convert;
    }

    /**
     * Sets the value of the convert property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConvert(String value) {
        this.convert = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setValue(Integer value) {
        this.value = value;
    }

}
