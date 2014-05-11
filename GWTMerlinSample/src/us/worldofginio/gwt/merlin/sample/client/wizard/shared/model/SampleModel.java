package us.worldofginio.gwt.merlin.sample.client.wizard.shared.model;

import java.io.Serializable;
import java.util.Date;

public class SampleModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1781187274109678262L;

	private Date dateOfBirth;

	private String firstName;

	private String name;

	private String childName;

	private boolean hasChildren;

	public SampleModel() {
		super();
	}

	/**
	 * @return the childName
	 */
	public String getChildName() {
		return childName;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the hasChildren
	 */
	public boolean getHasChildrenNo() {
		return hasChildren;
	}

	/**
	 * @return the hasChildren
	 */
	public boolean getHasChildrenYes() {
		return hasChildren;
	}

	/**
	 * @return the hasChildren
	 */
	public boolean getHasChildren() {
		return hasChildren;
	}

	/**
	 * @param childName
	 *            the childName to set
	 */
	public void setChildName(String childName) {
		this.childName = childName;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param hasChildren
	 *            the hasChildren to set
	 */
	public void setHasChildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	/**
	 * @param hasChildren
	 *            the hasChildren to set
	 */
	public void setHasChildrenYes(boolean hasChildren) {
		this.hasChildren = true;
	}

	/**
	 * @param hasChildren
	 *            the hasChildren to set
	 */
	public void setHasChildrenNo(boolean hasChildren) {
		this.hasChildren = false;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
