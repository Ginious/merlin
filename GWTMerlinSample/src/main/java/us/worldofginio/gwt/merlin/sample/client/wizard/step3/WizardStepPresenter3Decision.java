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
package us.worldofginio.gwt.merlin.sample.client.wizard.step3;

import us.worldofginio.gwt.merlin.client.presenter.AbstractWizardStepPresenter;

public class WizardStepPresenter3Decision extends AbstractWizardStepPresenter implements WizardStepView3Decision.Presenter {

	public WizardStepPresenter3Decision() {
		super(new WizardStepView3Decision());
	}

	@Override
	public void initStepView() {

	}
}