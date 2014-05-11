package us.worldofginio.gwt.merlin.client.view;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * A step view provides and initializes the UI of a single wizard step.
 * 
 * @author WoG
 * 
 * @param <M>
 *            The type of the underlying model.
 */
public interface WizardStepView<M> extends IsWidget, Editor<M> {

	/**
	 * 
	 */
	void flushModel();

	/**
	 * Gets the underlying model.
	 * 
	 * @return The underlying model.
	 */
	M getModel();

	/**
	 * Gets the identifier of the underlying step view.
	 * 
	 * @return The identifier of the underlying step view.
	 */
	WizardStepViewIdentifier getStepViewIdentifier();

	/**
	 * Called prior the step UI will be displayed and can be used to initialize bindings and to
	 * perform other step specific activities.
	 */
	void initBinding();

	/**
	 * Sets the underlying model.
	 * 
	 * @param inModel
	 *            The underlying model.
	 */
	void setModel(M inModel);
}