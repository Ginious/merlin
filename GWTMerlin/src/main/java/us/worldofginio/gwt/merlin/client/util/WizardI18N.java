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
package us.worldofginio.gwt.merlin.client.util;

import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

/**
 * I18N resource providing the title of the wizard, labels for wizard action buttons including
 * tooltips and the titles of wizard steps.
 * 
 * @author WoG 2014
 */
public interface WizardI18N {

	/**
	 * Gets the label text for the wizard action denoted by the given identifier.
	 * 
	 * @param inActionId
	 *            The identifier of the wizard action.
	 * @return The label text.
	 */
	String getLabelForWizardAction(WizardActionIdentifier inActionId);

	/**
	 * Gets the title of the wizard step denoted by the given identifier.
	 * 
	 * @param inStepViewId
	 *            The step view identifier.
	 * @return The title.
	 */
	String getStepTitle(WizardStepViewIdentifier inStepViewId);

	/**
	 * Gets the title of the wizard.
	 * 
	 * @return The title.
	 */
	String getTitle();

	/**
	 * Gets the tooltip text for the wizard action denoted by the given identifier.
	 * 
	 * @param inActionId
	 *            The identifier of the wizard action.
	 * @return The tooltip text.
	 */
	String getTooltipForWizardAction(WizardActionIdentifier inActionId);
}