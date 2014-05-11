package us.worldofginio.gwt.merlin.client.util;

import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

/**
 * I18N resource providing the title of the wizard, labels for wizard action buttons including
 * tooltips and the titles of wizard steps.
 * 
 * @author WoG 2014
 */
public interface WizardI18N {

	/**
	 * Gets the label text for the wizard action denoted by the given identifier.
	 * 
	 * @param inActionId
	 *            The identifier of the wizard action.
	 * @return The label text.
	 */
	String getLabelForWizardAction(WizardActionIdentifier inActionId);

	/**
	 * Gets the title of the wizard step denoted by the given identifier.
	 * 
	 * @param inStepViewId
	 *            The step view identifier.
	 * @return The title.
	 */
	String getStepTitle(WizardStepViewIdentifier inStepViewId);

	/**
	 * Gets the title of the wizard.
	 * 
	 * @return The title.
	 */
	String getTitle();

	/**
	 * Gets the tooltip text for the wizard action denoted by the given identifier.
	 * 
	 * @param inActionId
	 *            The identifier of the wizard action.
	 * @return The tooltip text.
	 */
	String getTooltipForWizardAction(WizardActionIdentifier inActionId);
}