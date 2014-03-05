package formulaire;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "produit")
public class XMLBean {

	private String name;

	private int quantity;

	public XMLBean(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public XMLBean() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	@XmlElement
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
