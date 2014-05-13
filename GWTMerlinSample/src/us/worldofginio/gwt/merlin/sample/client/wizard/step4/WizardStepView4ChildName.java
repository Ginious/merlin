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
package us.worldofginio.gwt.merlin.sample.client.wizard.step4;

import us.worldofginio.gwt.merlin.client.presenter.WizardStepPresenter;
import us.worldofginio.gwt.merlin.client.view.AbstractWizardStepView;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;
import us.worldofginio.gwt.merlin.sample.client.wizard.BasicWizardStepViewIdentifier;
import us.worldofginio.gwt.merlin.sample.client.wizard.shared.model.SampleModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class WizardStepView4ChildName extends AbstractWizardStepView<SampleModel> {

	@UiField
	@Path("childName")
	TextBox txtChildName;

	interface Binder extends UiBinder<Widget, WizardStepView4ChildName> {
		// GWT UI binder
	}

	private static final Binder UIBINDER = GWT.create(Binder.class);

	interface AliasSectionContentEditorDriver extends SimpleBeanEditorDriver<SampleModel, WizardStepView4ChildName> {
		// GWT data binding driver
	}

	// don't make this variable static as this leads to strange JS NPEs
	private final AliasSectionContentEditorDriver driver = GWT.create(AliasSectionContentEditorDriver.class);

	interface Presenter extends WizardStepPresenter {
	}

	public WizardStepView4ChildName() {
		super();

		UIBINDER.createAndBindUi(this);
	}

	@Override
	public void initBinding() {

		driver.initialize(this);
		driver.edit(getModel());
	}

	@Override
	public void flushModel() {
		driver.flush();
	}

	@Override
	public WizardStepViewIdentifier getStepViewIdentifier() {

		return BasicWizardStepViewIdentifier.D_CHILDNAME;
	}
}