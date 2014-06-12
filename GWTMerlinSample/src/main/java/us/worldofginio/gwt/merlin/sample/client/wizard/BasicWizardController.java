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

import java.util.logging.Logger;

import us.worldofginio.gwt.merlin.client.controller.AbstractWizardController;
import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.util.WizardI18N;
import us.worldofginio.gwt.merlin.sample.client.wizard.shared.model.SampleModel;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

public class BasicWizardController extends AbstractWizardController<SampleModel> {

	private final Logger LOGGER = Logger.getLogger(getClass().getName());

	private SampleModel model;

	/**
	 * 
	 * @param inBus
	 * @param inI18N
	 */
	@Inject
	public BasicWizardController(EventBus inBus, WizardI18N inI18N) {
		super(inBus, inI18N);

		setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.A_DATEOFBIRTH);
	}

	@Override
	public SampleModel getModel() {

		return model;
	}

	private void handleBack() {

		LOGGER.info("Perform Back");

		if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.B_NAME) {
			setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.A_DATEOFBIRTH);
		} else if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.C_DECISION) {
			setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.B_NAME);
		} else if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.D_CHILDNAME) {
			setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.C_DECISION);
		} else if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.E_SUMMARY) {
			if (model.getHasCertification()) {
				setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.D_CHILDNAME);
			} else {
				setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.C_DECISION);
			}
		} // else if
	}

	private void handleCancel() {
		LOGGER.info("Perform Cancel");
	}

	private void handleFinish() {

		LOGGER.info("Perform FINISH");
	}

	private void handleForward() {

		LOGGER.info("Perform Forward");

		if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.A_DATEOFBIRTH) {
			setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.B_NAME);
		} else if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.B_NAME) {
			setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.C_DECISION);
		} else if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.C_DECISION) {
			if (model.getHasCertification()) {
				setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.D_CHILDNAME);
			} else {
				setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.E_SUMMARY);
			}
		} else if (getCurrentStepViewIdentifier() == BasicWizardStepViewIdentifier.D_CHILDNAME) {
			setCurrentStepViewIdentifier(BasicWizardStepViewIdentifier.E_SUMMARY);
		} // else if
	}

	@Override
	public boolean isActionEnabled(WizardActionIdentifier inActionToCheck) {

		if (inActionToCheck == BasicWizardAction.BACK) {
			return (BasicWizardStepViewIdentifier.A_DATEOFBIRTH.equals(getCurrentStepViewIdentifier())) ? false : true;
		}
		if (inActionToCheck == BasicWizardAction.CANCEL) {
			return true;
		}
		if (inActionToCheck == BasicWizardAction.FINISH) {
			return true;
		}
		if (inActionToCheck == BasicWizardAction.FORWARD) {
			return (BasicWizardStepViewIdentifier.E_SUMMARY.equals(getCurrentStepViewIdentifier())) ? false : true;
		}
		throw new RuntimeException("Nicht unterstuetzte Page Action: " + inActionToCheck.toString());
	}

	@Override
	public void performCustom(WizardActionIdentifier inActionToPerform) {

		if (inActionToPerform == BasicWizardAction.BACK) {
			handleBack();
		} else if (inActionToPerform == BasicWizardAction.CANCEL) {
			handleCancel();
		} else if (inActionToPerform == BasicWizardAction.FINISH) {
			handleFinish();
		} else if (inActionToPerform == BasicWizardAction.FORWARD) {
			handleForward();
		} else {
			throw new RuntimeException("Nicht unterstuetzte Page Action: " + inActionToPerform.toString());
		} // else
	}

	@Override
	public void setModel(SampleModel inModel) {

		model = inModel;
	}
}