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

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base implementation for a wizard step view.
 * 
 * @author WoG 2014
 */
public abstract class AbstractWizardStepView<T> implements WizardStepView<T> {

	/**
	 * The content panel representing the UI of the underlying wizard step.
	 */
	@UiField
	public Panel pnlStepContent;

	/**
	 * The underlying wizard model.
	 */
	private T model;

	/**
	 * Default constructor.
	 */
	protected AbstractWizardStepView() {
		super();
	}

	public final Widget asWidget() {
		return pnlStepContent;
	}

	@Override
	public T getModel() {
		return model;
	}

	@Override
	public void setModel(T inModel) {
		model = inModel;
	}
}