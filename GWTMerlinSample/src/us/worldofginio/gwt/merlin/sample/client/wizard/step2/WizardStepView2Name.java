package us.worldofginio.gwt.merlin.sample.client.wizard.step2;

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

public class WizardStepView2Name extends AbstractWizardStepView<SampleModel> {

	@UiField
	@Path("name")
	TextBox txtName;

	@UiField
	@Path("firstName")
	TextBox txtFirstName;

	interface Binder extends UiBinder<Widget, WizardStepView2Name> {
		// GWT UI binder
	}

	private static final Binder UIBINDER = GWT.create(Binder.class);

	interface AliasSectionContentEditorDriver extends SimpleBeanEditorDriver<SampleModel, WizardStepView2Name> {
		// GWT data binding driver
	}

	// don't make this variable static as this leads to strange JS NPEs
	private final ContentEditorDriver driver = GWT.create(ContentEditorDriver.class);

	interface ContentEditorDriver extends SimpleBeanEditorDriver<SampleModel, WizardStepView2Name> {
		// GWT data binding driver
	}

	interface Presenter extends WizardStepPresenter {
	}

	public WizardStepView2Name() {
		super();

		// muss (!) vor driver init kommen
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

		return BasicWizardStepViewIdentifier.B_NAME;
	}
}