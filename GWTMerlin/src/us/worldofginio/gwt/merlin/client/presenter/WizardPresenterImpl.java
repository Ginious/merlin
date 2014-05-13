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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.worldofginio.gwt.merlin.client.controller.WizardController;
import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.view.WizardStepView;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;
import us.worldofginio.gwt.merlin.client.view.WizardView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Panel;
import com.google.inject.Inject;

/**
 * The presenter is responsible for showing the wizard and providing the wizard steps. It serves as
 * well as listener for the wizard action buttons.
 * 
 * @author WoG 2014
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class WizardPresenterImpl implements WizardPresenter, ClickHandler {

	/**
	 * The view of the wizard providing the different wizard steps.
	 */
	private WizardView wizardView;

	/**
	 * Presenters of wizard steps that will be available.
	 */
	private Map<WizardStepViewIdentifier, WizardStepPresenter> presenters = new HashMap<>();

	/**
	 * Actions that will be available.
	 */
	private List<WizardActionIdentifier> actions = new ArrayList<>();

	/**
	 * The wizard controller.
	 */
	private WizardController<Object> controller;

	@Inject
	public WizardPresenterImpl(WizardController inController, WizardView inView) {
		super();

		controller = inController;
		wizardView = inView;
	}

	/**
	 * Enable/ disable actions based on the state of the underlying model which is tracked by the
	 * underlying wizard controller implementation.
	 */
	private void enableDisableActions() {

		for (WizardActionIdentifier aCurrAction : actions) {
			wizardView.getButtonForWizardAction(aCurrAction).setEnabled(controller.isActionEnabled(aCurrAction));
		} // for
	}

	/**
	 * Each button click will be delegated to the underlying wizard controller for determination of
	 * the next step to display and for enabling/ disabling the action buttons.
	 * 
	 * @param inEvent
	 *            The event that occurred.
	 */
	@Override
	public void onClick(ClickEvent inEvent) {

		for (WizardActionIdentifier aCurrAction : actions) {
			if (inEvent.getSource() == wizardView.getButtonForWizardAction(aCurrAction)) {

				// flush model of current page
				WizardStepViewIdentifier aCurrentPageId = controller.getCurrentStepViewIdentifier();
				WizardStepPresenter aViewPresenter = presenters.get(aCurrentPageId);
				aViewPresenter.getView().flushModel();
				aViewPresenter.onLeaveStepView();

				// perform page action
				controller.perform(aCurrAction);

				// show page that was determined by the controller
				showCurrentWizardStep();

				// finally enable/ disable available buttons
				enableDisableActions();
			} // if
		} // for
	}

	@Override
	public void registerWizardActions(WizardActionIdentifier... inActions) {
		actions.addAll(Arrays.asList(inActions));

		for (WizardActionIdentifier aCurrAction : inActions) {
			wizardView.addButtonForWizardAction(aCurrAction);
		} // for
	}

	@Override
	public void registerWizardStepPresenters(WizardStepPresenter... inPresentersToRegister) {

		for (WizardStepPresenter aCurrPresenter : inPresentersToRegister) {
			presenters.put(aCurrPresenter.getView().getStepViewIdentifier(), aCurrPresenter);
		} // for
	}

	/**
	 * Shows the current wizard step by getting the corresponding instance via the registry of
	 * wizard step presenters, setting the model and initializing the binding.
	 */
	private void showCurrentWizardStep() {

		WizardStepView aCurrentPage = presenters.get(controller.getCurrentStepViewIdentifier()).getView();
		presenters.get(controller.getCurrentStepViewIdentifier()).initStepView();
		aCurrentPage.setModel(controller.getModel());
		aCurrentPage.initBinding();
		wizardView.showWizardStepView(aCurrentPage);
	}

	@Override
	public void startWizard(Panel inParentContainer, Object inModel) {

		// ensure that presenters and actions were registered
		assert !presenters.isEmpty() : "No wizard pages have been registered!";
		assert !actions.isEmpty() : "No wizard actions have been registered!";

		controller.setModel(inModel);
		inParentContainer.add(wizardView.asWidget());
		showCurrentWizardStep();
		enableDisableActions();

		// initialize action handling
		for (WizardActionIdentifier aCurrAction : actions) {
			wizardView.getButtonForWizardAction(aCurrAction).addClickHandler(this);
		} // for
	}
}