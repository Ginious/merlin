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
package us.worldofginio.gwt.merlin.sample.client.wizard;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.util.WizardI18N;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

public class BasicWizardI18N implements WizardI18N {

	@Override
	public String getTitle() {

		return "WoG Sample Wizard";
	}

	@Override
	public String getLabelForWizardAction(WizardActionIdentifier inAction) {

		if (inAction == BasicWizardAction.BACK) {
			return "Zurück";
		} else if (inAction == BasicWizardAction.CANCEL) {
			return "Abbrechen";
		} else if (inAction == BasicWizardAction.FINISH) {
			return "Abschliessen";
		} else if (inAction == BasicWizardAction.FORWARD) {
			return "Weiter";
		}

		throw new RuntimeException("Nicht unterstuetzte Page Action: " + inAction.toString());
	}

	@Override
	public String getTooltipForWizardAction(WizardActionIdentifier inAction) {

		if (inAction == BasicWizardAction.BACK) {
			return "Eine Seite zurück";
		} else if (inAction == BasicWizardAction.CANCEL) {
			return "Wizard abbrechen und Änderungen verwerfen";
		} else if (inAction == BasicWizardAction.FINISH) {
			return "Abschliessen und Meldung einreichen";
		} else if (inAction == BasicWizardAction.FORWARD) {
			return "Weiter zur nächsten Seite";
		}

		throw new RuntimeException("Nicht unterstuetzte Page Action: " + inAction.toString());
	}

	@Override
	public String getStepTitle(WizardStepViewIdentifier inStepViewId) {

		String outTitle = null;

		if (inStepViewId == BasicWizardStepViewIdentifier.A_DATEOFBIRTH) {
			outTitle = "Date of Birth";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.B_NAME) {
			outTitle = "Name";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.C_DECISION) {
			outTitle = "Children";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.D_CHILDNAME) {
			outTitle = "Child Name";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.E_SUMMARY) {
			outTitle = "Summary";
		} // else if

		return outTitle;
	}
}