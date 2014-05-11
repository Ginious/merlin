package us.worldofginio.gwt.merlin.client.controller;

import us.worldofginio.gwt.merlin.client.controller.AbstractWizardController;
import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

/**
 * Default implementation of a wizard controller doing nothing special than providing an empty
 * implementation of required methods.
 * 
 * @author WoG 2014
 */
@SuppressWarnings("rawtypes")
final class UCTestController extends AbstractWizardController {

	enum StepViewId implements WizardStepViewIdentifier {
		PAGE_A, PAGE_B, PAGE_C, PAGE_D, PAGE_E;
	}

	public UCTestController() {
		super(null, null);
	}

	@Override
	public Object getModel() {
		return null;
	}

	@Override
	public boolean isActionEnabled(WizardActionIdentifier inActionToCheck) {
		return false;
	}

	@Override
	public void setModel(Object inModel) {
	}

	@Override
	protected void performCustom(WizardActionIdentifier inActionToPerform) {
	}
}