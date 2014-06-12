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
 * Presenter for a single wizard step.
 * 
 * @author WoG 2014
 */
@SuppressWarnings("rawtypes")
public interface WizardStepPresenter {

	/**
	 * Gets the underlying wizard step view.
	 * 
	 * @return The step view.
	 */
	WizardStepView getView();

	/**
	 * Performs initialization tasks before the step view is being shown.
	 */
	void initStepView();

	/**
	 * Performs e.g. destruction tasks for the current step before the next or the previous view is
	 * being shown. Can optionally be overridden.
	 */
	void onLeaveStepView();
}