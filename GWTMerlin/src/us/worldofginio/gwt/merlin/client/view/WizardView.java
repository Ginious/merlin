package us.worldofginio.gwt.merlin.client.view;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * A wizard view encapsulates the UI of the wizard and delegates invocations to it.
 * 
 * @author WoG 2014
 */
public interface WizardView extends IsWidget {

	/**
	 * Adds a button for the given action identifier.
	 * 
	 * @param inAction
	 *            The identifier of the action.
	 */
	void addButtonForWizardAction(WizardActionIdentifier inAction);

	/**
	 * Gets the button that was created for the given action identifier.
	 * 
	 * @param inAction
	 *            The action identifier.
	 * @return The button that was created.
	 */
	Button getButtonForWizardAction(WizardActionIdentifier inAction);

	/**
	 * Shows the given wizard step.
	 * 
	 * @param inWizardStep
	 *            The step to show.
	 */
	@SuppressWarnings("rawtypes")
	void showWizardStepView(WizardStepView inWizardStep);
}