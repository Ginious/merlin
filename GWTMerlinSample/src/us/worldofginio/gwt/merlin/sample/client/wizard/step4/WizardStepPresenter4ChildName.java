package us.worldofginio.gwt.merlin.sample.client.wizard.step4;

import us.worldofginio.gwt.merlin.client.presenter.AbstractWizardStepPresenter;


public class WizardStepPresenter4ChildName extends AbstractWizardStepPresenter implements WizardStepView4ChildName.Presenter {

	public WizardStepPresenter4ChildName() {
		super(new WizardStepView4ChildName());
	}

	@Override
	public void initStepView() {
	}
}