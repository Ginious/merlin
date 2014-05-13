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
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * The default implementation of a {@link WizardView} providing delegation methods to the underlying
 * encapsulated UI.
 * 
 * @author WoG 2014
 */
public final class WizardViewImpl implements WizardView {

	/**
	 * The UI of the wizard.
	 */
	private WizardUI ui;

	/**
	 * Default constructor.
	 * 
	 * @param inUi
	 *            The injected wizard UI.
	 */
	@Inject
	public WizardViewImpl(WizardUI inUi) {
		super();

		assert inUi != null : "A WizardUI instance is required and must be defined using ginject!";

		ui = inUi;
	}

	@Override
	public void addButtonForWizardAction(WizardActionIdentifier inAction) {
		ui.addButtonForWizardAction(inAction);
	}

	@Override
	public Widget asWidget() {
		return ui.asWidget();
	}

	@Override
	public Button getButtonForWizardAction(WizardActionIdentifier inAction) {
		return ui.getButtonForWizardAction(inAction);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void showWizardStepView(WizardStepView inPage) {
		ui.showWizardStep(inPage.asWidget());
	}
}