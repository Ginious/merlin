package us.worldofginio.gwt.merlin.sample.client.wizard.step5;

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

public class WizardStepView5Summary extends AbstractWizardStepView<SampleModel> {

	@UiField
	@Path("name")
	TextBox txtName;

	@UiField
	@Path("firstName")
	TextBox txtVorname;

	interface Binder extends UiBinder<Widget, WizardStepView5Summary> {
		// GWT UI binder
	}

	private static final Binder UIBINDER = GWT.create(Binder.class);

	interface Driver extends SimpleBeanEditorDriver<SampleModel, WizardStepView5Summary> {
		// GWT data binding driver
	}

	// don't make this variable static as this leads to strange JS NPEs
	private final Driver driver = GWT.create(Driver.class);

	interface Presenter extends WizardStepPresenter {
	}

	public WizardStepView5Summary() {
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
		return BasicWizardStepViewIdentifier.E_SUMMARY;
	}
}