/*
 * Copyright 2014 World of Ginious (http://www.worldofginio.us)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package us.worldofginio.gwt.merlin.client.view;

import java.util.HashMap;
import java.util.Map;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.util.WizardI18N;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Represents the UI of the wizard and is responsible of creating, initializing and adding a button
 * for each registered wizard action identifier.
 * 
 * @author WoG 2014
 */
public final class WizardUI implements IsWidget {

	/**
	 * Binder for aggregation of the UI XML.
	 */
	interface Binder extends UiBinder<Widget, WizardUI> {
		// GWT UI binder
	}

	/**
	 * The map providing all buttons that were created by the respective action identifier.
	 */
	private Map<WizardActionIdentifier, Button> buttons = new HashMap<>();

	/**
	 * The panel for the buttons.
	 */
	@UiField
	Panel pnlButtons;

	/**
	 * The grid representing the wizard.
	 */
	@UiField
	Grid wizardGrid;

	/**
	 * The content panel that will finally provide the wizard steps.
	 */
	@UiField
	Panel pnlContent;

	/**
	 * I18N resources used for labeling the action buttons.
	 */
	private WizardI18N i18n;

	private static final Binder UIBINDER = GWT.create(Binder.class);

	/**
	 * Default constructor.
	 * 
	 * @param inI18N
	 *            The I18N resource.
	 */
	@Inject
	public WizardUI(WizardI18N inI18N) {
		super();

		i18n = inI18N;

		UIBINDER.createAndBindUi(this);
	}

	/**
	 * Creates, initializes and adds an action button for the given action identifier to the button
	 * panel.
	 * 
	 * @param inAction
	 *            The identifier of the action for which to add an action button.
	 */
	void addButtonForWizardAction(WizardActionIdentifier inAction) {

		Button aNewButton = new Button();
		aNewButton.setText(i18n.getLabelForWizardAction(inAction));
		aNewButton.setTitle(i18n.getTooltipForWizardAction(inAction));
		aNewButton.setStyleName("wog-wizardButton");

		pnlButtons.add(aNewButton);

		buttons.put(inAction, aNewButton);
	}

	/**
	 * Gets the wizard as widget.
	 * 
	 * @return The wizard as widget.
	 */
	@Override
	public Widget asWidget() {

		return wizardGrid;
	}

	/**
	 * Gets the button that was created for the given action identifier.
	 * 
	 * @param inActionId
	 *            The action identifier.
	 * @return The button.
	 */
	Button getButtonForWizardAction(WizardActionIdentifier inActionId) {

		return buttons.get(inActionId);
	}

	/**
	 * Shows the given widget as wizard content. Prior adding new content the old one will be
	 * removed.
	 * 
	 * @param inWidgetToShow
	 *            The widget to be shown.
	 */
	void showWizardStep(Widget inWidgetToShow) {

		pnlContent.clear();
		pnlContent.add(inWidgetToShow);
	}
}