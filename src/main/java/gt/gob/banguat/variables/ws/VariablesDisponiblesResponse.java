
package gt.gob.banguat.variables.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="VariablesDisponiblesResult" type="{http://www.banguat.gob.gt/variables/ws/}InfoVariable" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "variablesDisponiblesResult"
})
@XmlRootElement(name = "VariablesDisponiblesResponse")
public class VariablesDisponiblesResponse {

    @XmlElement(name = "VariablesDisponiblesResult")
    protected InfoVariable variablesDisponiblesResult;

    /**
     * Obtiene el valor de la propiedad variablesDisponiblesResult.
     * 
     * @return
     *     possible object is
     *     {@link InfoVariable }
     *     
     */
    public InfoVariable getVariablesDisponiblesResult() {
        return variablesDisponiblesResult;
    }

    /**
     * Define el valor de la propiedad variablesDisponiblesResult.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoVariable }
     *     
     */
    public void setVariablesDisponiblesResult(InfoVariable value) {
        this.variablesDisponiblesResult = value;
    }

}
