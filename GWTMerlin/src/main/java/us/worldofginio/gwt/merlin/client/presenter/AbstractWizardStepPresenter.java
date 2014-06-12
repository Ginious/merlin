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

import us.worldofginio.gwt.merlin.client.view.WizardStepView;

/**
 * Base implementation of a presenter capable of managing a wizard step UI.
 * 
 * @author WoG 2014
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractWizardStepPresenter implements WizardStepPresenter {

	/**
	 * The view representing the wizard step.
	 */
	private WizardStepView view;

	/**
	 * Default constructor for a wizard step view.
	 * 
	 * @param inView
	 *            The step view to present.
	 */
	protected AbstractWizardStepPresenter(WizardStepView inView) {
		super();

		view = inView;
	}

	@Override
	public final WizardStepView getView() {
		return view;
	}

	@Override
	public void onLeaveStepView() {

	}
}