

package ua.nure.matyash.practice7.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Parametrs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Parametrs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lenght" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Parametrs", propOrder = {
    "lenght",
    "width",
    "height"
})
public class Parametrs {

    protected int lenght;
    protected int width;
    protected int height;

    /**
     * Gets the value of the lenght property.
     * 
     */
    public int getLenght() {
        return lenght;
    }

    /**
     * Sets the value of the lenght property.
     * 
     */
    public void setLenght(int value) {
        this.lenght = value;
    }

    /**
     * Gets the value of the width property.
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     */
    public void setHeight(int value) {
        this.height = value;
    }

}
