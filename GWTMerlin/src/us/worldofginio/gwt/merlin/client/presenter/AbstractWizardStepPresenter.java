package us.worldofginio.gwt.merlin.client.presenter;

import us.worldofginio.gwt.merlin.client.view.WizardStepView;

/**
 * Base implementation of a presenter capable of managing a wizard step UI.
 * 
 * @author WoG 2014
 */
@SuppressWarnings("rawtypes")
public abstract class AbstractWizardStepPresenter implements WizardStepPresenter {

	/**
	 * The view representing the wizard step.
	 */
	private WizardStepView view;

	/**
	 * Default constructor for a wizard step view.
	 * 
	 * @param inView
	 *            The step view to present.
	 */
	protected AbstractWizardStepPresenter(WizardStepView inView) {
		super();

		view = inView;
	}

	@Override
	public final WizardStepView getView() {
		return view;
	}

	@Override
	public void onLeaveStepView() {

	}
}