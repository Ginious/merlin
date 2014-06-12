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

	private String certificateName;

	private boolean hasCertificationNo;

	private boolean hasCertificationYes;

	public SampleModel() {
		super();
	}

	/**
	 * @return the certificateName
	 */
	public String getCertificateName() {
		return certificateName;
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
	 * @return the hasCertification
	 */
	public boolean getHasCertificationNo() {
		return hasCertificationNo;
	}

	/**
	 * @return the hasCertification
	 */
	public boolean getHasCertificationYes() {
		return hasCertificationYes;
	}

	/**
	 * @return the inHasCertification
	 */
	public boolean getHasCertification() {
		return !hasCertificationNo && hasCertificationYes;
	}

	/**
	 * @param inCertificateName
	 *            the certificateName to set
	 */
	public void setCertificateName(String inCertificateName) {
		this.certificateName = inCertificateName;
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
	 * @param inHasCertification
	 *            the inHasCertification to set
	 */
	public void setHasCertificationYes(boolean inHasCertification) {
		this.hasCertificationYes = inHasCertification;
	}

	/**
	 * @param inHasCertification
	 *            the inHasCertification to set
	 */
	public void setHasCertificationNo(boolean inHasCertification) {
		this.hasCertificationNo = inHasCertification;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
