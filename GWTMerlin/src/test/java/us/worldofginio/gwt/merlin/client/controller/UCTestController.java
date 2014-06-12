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
package us.worldofginio.gwt.merlin.client.controller;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

/**
 * Default implementation of a wizard controller doing nothing special than providing an empty
 * implementation of required methods.
 * 
 * @author WoG 2014
 */
@SuppressWarnings("rawtypes")
final class UCTestController extends AbstractWizardController {

	enum StepViewId implements WizardStepViewIdentifier {
		PAGE_A, PAGE_B, PAGE_C, PAGE_D, PAGE_E;
	}

	public UCTestController() {
		super(null, null);
	}

	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public boolean isActionEnabled(WizardActionIdentifier inActionToCheck) {
		return false;
	}

	@Override
	public void setModel(Object inModel) {
	}

	@Override
	protected void performCustom(WizardActionIdentifier inActionToPerform) {
	}
}