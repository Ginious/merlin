package us.worldofginio.gwt.merlin.sample.client.wizard.step1;

import us.worldofginio.gwt.merlin.client.presenter.AbstractWizardStepPresenter;

public final class WizardStepPresenter1DateOfBirth extends AbstractWizardStepPresenter implements WizardStepView1DateOfBirth.Presenter {

	public WizardStepPresenter1DateOfBirth() {
		super(new WizardStepView1DateOfBirth());
	}

	@Override
	public void initStepView() {
	}
}