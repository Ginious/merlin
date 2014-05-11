package us.worldofginio.gwt.merlin.client.view;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Base implementation for a wizard step view.
 * 
 * @author WoG 2014
 */
public abstract class AbstractWizardStepView<T> implements WizardStepView<T> {

	/**
	 * The content panel representing the UI of the underlying wizard step.
	 */
	@UiField
	public Panel pnlStepContent;

	/**
	 * The underlying wizard model.
	 */
	private T model;

	/**
	 * Default constructor.
	 */
	protected AbstractWizardStepView() {
		super();
	}

	public final Widget asWidget() {
		return pnlStepContent;
	}

	@Override
	public T getModel() {
		return model;
	}

	@Override
	public void setModel(T inModel) {
		model = inModel;
	}
}