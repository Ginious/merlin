package us.worldofginio.gwt.merlin.client.view;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * The default implementation of a {@link WizardView} providing delegation methods to the underlying
 * encapsulated UI.
 * 
 * @author WoG 2014
 */
public final class WizardViewImpl implements WizardView {

	/**
	 * The UI of the wizard.
	 */
	private WizardUI ui;

	/**
	 * Default constructor.
	 * 
	 * @param inUi
	 *            The injected wizard UI.
	 */
	@Inject
	public WizardViewImpl(WizardUI inUi) {
		super();

		assert inUi != null : "A WizardUI instance is required and must be defined using ginject!";

		ui = inUi;
	}

	@Override
	public void addButtonForWizardAction(WizardActionIdentifier inAction) {
		ui.addButtonForWizardAction(inAction);
	}

	@Override
	public Widget asWidget() {
		return ui.asWidget();
	}

	@Override
	public Button getButtonForWizardAction(WizardActionIdentifier inAction) {
		return ui.getButtonForWizardAction(inAction);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public void showWizardStepView(WizardStepView inPage) {
		ui.showWizardStep(inPage.asWidget());
	}
}