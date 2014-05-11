package us.worldofginio.gwt.merlin.client.controller;

import java.util.Collection;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

/**
 * Controller for a wizard managing the common navigation and the enabling/ disabling of wizard
 * actions. Implementations might use BPM products like Activiti or simple custom implementations
 * depending on the complexity of the wizard to implement.
 * 
 * @author WoG 2014
 */
public interface WizardController<T> {

	/**
	 * Gets bread crumb items in sorted order from the first to the last .
	 * 
	 * @return The bread crumb items.
	 */
	Collection<BreadCrumb> getBreadCrumbs();

	/**
	 * Gets the identifier of the current step view.
	 * 
	 * @return The step view identifier.
	 */
	WizardStepViewIdentifier getCurrentStepViewIdentifier();

	/**
	 * Gets the underlying model.
	 * 
	 * @return
	 */
	T getModel();

	/**
	 * Indicates whether not the given action is enabled.
	 * 
	 * @param inActionToCheck
	 *            The action to check.
	 * @return The switch indicating whether not the given action is enabled.
	 */
	boolean isActionEnabled(WizardActionIdentifier inActionToCheck);

	/**
	 * Performs the corresponding action.
	 * 
	 * @param inActionToPerform
	 *            The action denoted by the given action identifier.
	 */
	void perform(WizardActionIdentifier inActionToPerform);

	/**
	 * Sets the underlying model.
	 * 
	 * @param inModel
	 *            The model.
	 */
	void setModel(T inModel);
}