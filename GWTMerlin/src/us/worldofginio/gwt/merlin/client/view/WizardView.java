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
package us.worldofginio.gwt.merlin.client.view;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * A wizard view encapsulates the UI of the wizard and delegates invocations to it.
 * 
 * @author WoG 2014
 */
public interface WizardView extends IsWidget {

	/**
	 * Adds a button for the given action identifier.
	 * 
	 * @param inAction
	 *            The identifier of the action.
	 */
	void addButtonForWizardAction(WizardActionIdentifier inAction);

	/**
	 * Gets the button that was created for the given action identifier.
	 * 
	 * @param inAction
	 *            The action identifier.
	 * @return The button that was created.
	 */
	Button getButtonForWizardAction(WizardActionIdentifier inAction);

	/**
	 * Shows the given wizard step.
	 * 
	 * @param inWizardStep
	 *            The step to show.
	 */
	@SuppressWarnings("rawtypes")
	void showWizardStepView(WizardStepView inWizardStep);
}