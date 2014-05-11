package us.worldofginio.gwt.merlin.client.presenter;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;

import com.google.gwt.user.client.ui.Panel;

/**
 * A presenter for the wizard is responsible for the registration of wizard step view presenters and
 * the actions to be supported/ shown by the final wizard.
 * 
 * @author WoG 2014
 */
public interface WizardPresenter {

	/**
	 * Registers the given actions. Each action will be rendered as button in the appearing wizard.
	 * The order of button corresponds to the order of the actions left to right.
	 * 
	 * @param inActions
	 *            The actions to register.
	 */
	void registerWizardActions(WizardActionIdentifier... inActions);

	/**
	 * Registers all presenters of wizard steps that must finally be available in the wizard.
	 * 
	 * @param inPresentersToRegister
	 *            The presenters to be registered.
	 */
	void registerWizardStepPresenters(WizardStepPresenter... inPresentersToRegister);

	/**
	 * Starts the wizard by adding it as UI widget to the given parent container.
	 * 
	 * @param inParentContainer
	 *            The parent container for adding the wizard UI.
	 * @param inModel
	 *            The wizard model.
	 */
	void startWizard(Panel inParentContainer, Object inModel);
}