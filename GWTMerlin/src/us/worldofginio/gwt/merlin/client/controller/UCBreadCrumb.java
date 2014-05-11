package us.worldofginio.gwt.merlin.client.controller;

import us.worldofginio.gwt.merlin.client.util.WizardI18N;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

/**
 * Default implementation of a {@link BreadCrumb}.
 * 
 * @author WoG 2014
 */
final class UCBreadCrumb implements BreadCrumb {

	/**
	 * The I18N resource.
	 */
	private WizardI18N i18n;

	/**
	 * The identifier of the view represented by this bread crumb.
	 */
	private WizardStepViewIdentifier stepViewId;

	/**
	 * Switch indicating whether or not this bread crumbs represents the wizard step that is
	 * currently visible.
	 */
	private boolean current;

	/**
	 * Constructor.
	 * 
	 * @param inI18N
	 *            The I18N resource.
	 * @param inStepViewId
	 *            The identifier of the view represented by this bread crumb.
	 * @param inIsCurrent
	 *            The switch indicating whether or not this bread crumbs represents the wizard step
	 *            that is currently visible.
	 */
	UCBreadCrumb(WizardI18N inI18N, WizardStepViewIdentifier inStepViewId, boolean inIsCurrent) {
		super();

		assert inI18N != null : "The I18N resource is required!";
		assert inStepViewId != null : "The step view identifier is required!";

		i18n = inI18N;
		stepViewId = inStepViewId;
		current = inIsCurrent;
	}

	@Override
	public String getTitle() {
		return i18n.getStepTitle(stepViewId);
	}

	WizardStepViewIdentifier getStepViewId() {
		return stepViewId;
	}

	@Override
	public boolean isCurrent() {
		return current;
	}

	/**
	 * Setter for the switch indicating whether or not this bread crumbs represents the wizard step
	 * that is currently visible.
	 * 
	 * @param inIsCurrent
	 *            The switch.
	 */
	void setIsCurrent(boolean inIsCurrent) {
		current = inIsCurrent;
	}

	/**
	 * Gets the title as the string representation.
	 * 
	 * @return The title.
	 */
	@Override
	public String toString() {
		return getTitle();
	}
}