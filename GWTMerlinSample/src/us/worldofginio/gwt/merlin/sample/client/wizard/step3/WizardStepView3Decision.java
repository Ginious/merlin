package us.worldofginio.gwt.merlin.sample.client.wizard.step3;

import us.worldofginio.gwt.merlin.client.presenter.WizardStepPresenter;
import us.worldofginio.gwt.merlin.client.view.AbstractWizardStepView;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;
import us.worldofginio.gwt.merlin.sample.client.wizard.BasicWizardStepViewIdentifier;
import us.worldofginio.gwt.merlin.sample.client.wizard.shared.model.SampleModel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.Widget;

public class WizardStepView3Decision extends AbstractWizardStepView<SampleModel> {

	@UiField
	@Path("hasChildrenYes")
	RadioButton rbHaveChildrenYes;

	@UiField
	@Path("hasChildrenNo")
	RadioButton rbHaveChildrenNo;

	interface Binder extends UiBinder<Widget, WizardStepView3Decision> {
		// GWT UI binder
	}

	private static final Binder UIBINDER = GWT.create(Binder.class);

	interface AliasSectionContentEditorDriver extends SimpleBeanEditorDriver<SampleModel, WizardStepView3Decision> {
		// GWT data binding driver
	}

	// don't make this variable static as this leads to strange JS NPEs
	private final AliasSectionContentEditorDriver driver = GWT.create(AliasSectionContentEditorDriver.class);

	interface Presenter extends WizardStepPresenter {
	}

	public WizardStepView3Decision() {
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

		return BasicWizardStepViewIdentifier.C_DECISION;
	}
}