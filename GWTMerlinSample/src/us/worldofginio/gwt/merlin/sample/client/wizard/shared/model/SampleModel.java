/*
 * Copyright 2014 World of Ginious (http://www.worldofginio.us)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
