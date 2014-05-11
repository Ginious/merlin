package us.worldofginio.gwt.merlin.sample.client.wizard.step1;

import us.worldofginio.gwt.merlin.client.presenter.WizardStepPresenter;
import us.worldofginio.gwt.merlin.client.view.AbstractWizardStepView;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;
import us.worldofginio.gwt.merlin.sample.client.wizard.BasicWizardStepViewIdentifier;
import us.worldofginio.gwt.merlin.sample.client.wizard.shared.model.SampleModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class WizardStepView1DateOfBirth extends AbstractWizardStepView<SampleModel> {

	@UiField
	// Case Sensitiv!
	@Path(value = "dateOfBirth")
	DateBox dpDateOfBirth;

	interface Binder extends UiBinder<Widget, WizardStepView1DateOfBirth> {
		// GWT UI binder
	}

	private static final Binder UIBINDER = GWT.create(Binder.class);

	interface ContentEditorDriver extends SimpleBeanEditorDriver<SampleModel, WizardStepView1DateOfBirth> {
		// GWT data binding driver
	}

	// don't make this variable static as this leads to strange JS NPEs
	private final ContentEditorDriver driver = GWT.create(ContentEditorDriver.class);

	public interface Presenter extends WizardStepPresenter {
	}

	public WizardStepView1DateOfBirth() {
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

		return BasicWizardStepViewIdentifier.A_DATEOFBIRTH;
	}
}