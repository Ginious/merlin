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
package us.worldofginio.gwt.merlin.client.presenter;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;

import com.google.gwt.user.client.ui.Panel;

/**
 * A presenter for the wizard is responsible for the registration of wizard step view presenters and
 * the actions to be supported/ shown by the final wizard.
 * 
 * @author WoG 2014
 */
public interface WizardPresenter {

	/**
	 * Registers the given actions. Each action will be rendered as button in the appearing wizard.
	 * The order of button corresponds to the order of the actions left to right.
	 * 
	 * @param inActions
	 *            The actions to register.
	 */
	void registerWizardActions(WizardActionIdentifier... inActions);

	/**
	 * Registers all presenters of wizard steps that must finally be available in the wizard.
	 * 
	 * @param inPresentersToRegister
	 *            The presenters to be registered.
	 */
	void registerWizardStepPresenters(WizardStepPresenter... inPresentersToRegister);

	/**
	 * Starts the wizard by adding it as UI widget to the given parent container.
	 * 
	 * @param inParentContainer
	 *            The parent container for adding the wizard UI.
	 * @param inModel
	 *            The wizard model.
	 */
	void startWizard(Panel inParentContainer, Object inModel);
}