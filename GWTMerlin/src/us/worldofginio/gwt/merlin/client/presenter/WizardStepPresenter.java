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