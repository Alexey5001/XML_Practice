


package ua.nure.matyash.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Plane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Plane">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Originl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Chars" type="{}Chars"/>
 *         &lt;element name="Parametrs" type="{}Parametrs"/>
 *         &lt;element name="Prise" type="{}Prise"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Plane", propOrder = {
    "model",
    "originl",
    "chars",
    "parametrs",
    "prise"
})
public class Plane {

    @XmlElement(name = "Model", required = true)
    protected String model;
    @XmlElement(name = "Originl", required = true)
    protected String originl;
    @XmlElement(name = "Chars", required = true)
    protected Chars chars;
    @XmlElement(name = "Parametrs", required = true)
    protected Parametrs parametrs;
    @XmlElement(name = "Prise", required = true)
    protected Prise prise;

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the originl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginl() {
        return originl;
    }

    /**
     * Sets the value of the originl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginl(String value) {
        this.originl = value;
    }

    /**
     * Gets the value of the chars property.
     * 
     * @return
     *     possible object is
     *     {@link Chars }
     *     
     */
    public Chars getChars() {
        return chars;
    }

    /**
     * Sets the value of the chars property.
     * 
     * @param value
     *     allowed object is
     *     {@link Chars }
     *     
     */
    public void setChars(Chars value) {
        this.chars = value;
    }

    /**
     * Gets the value of the parametrs property.
     * 
     * @return
     *     possible object is
     *     {@link Parametrs }
     *     
     */
    public Parametrs getParametrs() {
        return parametrs;
    }

    /**
     * Sets the value of the parametrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Parametrs }
     *     
     */
    public void setParametrs(Parametrs value) {
        this.parametrs = value;
    }

    /**
     * Gets the value of the prise property.
     * 
     * @return
     *     possible object is
     *     {@link Prise }
     *     
     */
    public Prise getPrise() {
        return prise;
    }

    /**
     * Sets the value of the prise property.
     * 
     * @param value
     *     allowed object is
     *     {@link Prise }
     *     
     */
    public void setPrise(Prise value) {
        this.prise = value;
    }
    
    public String toString() {
        return new StringBuilder()
        	.append("[")
                	.append(getModel()).append(";")
                	.append(getOriginl()).append(";")
                	.append(getChars().getType()).append(";")
                	.append(getChars().getSits()).append(";")
                	.append(getChars().getAmmunition().getRokets()).append(";")
                	.append(getChars().isRadar()).append(";")
                	.append(getParametrs().getLenght()).append(";")
                	.append(getParametrs().getWidth()).append(";")
                	.append(getParametrs().getHeight()).append(";")
                	.append(getPrise().getValue()).append(getPrise().getConvert())
        	.append("]").toString();
    }

}
