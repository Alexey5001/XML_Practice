

package ua.nure.matyash.practice7.entity;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Plane" type="{}Plane" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "plane"
})
@XmlRootElement(name = "Planes")
public class Planes {

    @XmlElement(name = "Plane", required = true)
    protected List<Plane> plane;

    /**
     * Gets the value of the plane property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the plane property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlane().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Plane }
     * 
     * 
     */
    public List<Plane> getPlane() {
        if (plane == null) {
            plane = new ArrayList<>();
        }
        return this.plane;
    }
    
    @Override
	public String toString() {
		if (plane == null || plane.isEmpty()) {
			return "Test contains no planes";
		}
		StringBuilder result = new StringBuilder();
		for (Plane question : plane) {
			result.append(question).append('\n');
		}
		return result.toString();
	}

}
