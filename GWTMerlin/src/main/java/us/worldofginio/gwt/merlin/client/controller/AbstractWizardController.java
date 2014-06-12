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
package us.worldofginio.gwt.merlin.client.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.util.WizardBreadCrumbEvent;
import us.worldofginio.gwt.merlin.client.util.WizardI18N;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

import com.google.gwt.event.shared.EventBus;

/**
 * Base implementation of a controller with support for bread crumbs and basic action handling.
 * 
 * @author WoG 2014
 */
public abstract class AbstractWizardController<T extends Object> implements WizardController<T> {

	private class DefaultWizardI18N implements WizardI18N {

		@Override
		public String getLabelForWizardAction(WizardActionIdentifier inActionId) {
			return inActionId.toString();
		}

		@Override
		public String getStepTitle(WizardStepViewIdentifier inStepViewId) {
			return inStepViewId.toString();
		}

		@Override
		public String getTitle() {
			return "[WIZARD_TITLE]";
		}

		@Override
		public String getTooltipForWizardAction(WizardActionIdentifier inActionId) {
			return inActionId.toString();
		}
	}

	/**
	 * Bread crumbs in sorted order from first to last wizard step.
	 */
	private List<UCBreadCrumb> breadCrumbs = new ArrayList<UCBreadCrumb>();

	/**
	 * All bread crumbs that were added so far registered by the respective step view identifier.
	 */
	private Map<WizardStepViewIdentifier, BreadCrumb> breadCrumbsByStepViewId = new HashMap<WizardStepViewIdentifier, BreadCrumb>();

	/**
	 * The identifier of the current view.
	 */
	private WizardStepViewIdentifier currentViewIdentifier;

	/**
	 * Event bus for publishing bread crumbs.
	 */
	private EventBus eventBus;

	/**
	 * I18N resources.
	 */
	private WizardI18N i18n;

	/**
	 * Indicates whether test mode is activated (<code>false</code>.
	 */
	private boolean testMode = false;

	/**
	 * Default constructor with action identifiers.
	 */
	protected AbstractWizardController(EventBus inBus, WizardI18N inI18N) {
		super();

		i18n = inI18N;
		eventBus = inBus;
	}

	@Override
	public List<BreadCrumb> getBreadCrumbs() {
		List<BreadCrumb> outList = new ArrayList<BreadCrumb>();
		outList.addAll(breadCrumbs);
		return outList;
	}

	@Override
	public WizardStepViewIdentifier getCurrentStepViewIdentifier() {
		return currentViewIdentifier;
	}

	/**
	 * Currently just delegates to the performCustom method without doing anything else. This method
	 * enables at a later version of Merlin to implement life cycle behavior.
	 * 
	 * @param inActionToPerform
	 *            The identifier of the action to perform.
	 */
	@Override
	public final void perform(WizardActionIdentifier inActionToPerform) {
		performCustom(inActionToPerform);
	}

	/**
	 * Sub classes have to implement this method in order to handle an action.
	 * 
	 * @param inActionToPerform
	 *            The identifier of the action to handle.
	 */
	protected abstract void performCustom(WizardActionIdentifier inActionToPerform);

	/**
	 * Allows the concrete controller to set the current step view identifier. Bread crumbs are
	 * automatically initialized. For each new step a new bread crumb will be added. When moving
	 * back all bread crumbs remain untouched. In case of skipping steps due to the underlying logic
	 * the bread crumbs of all these steps will be removed.
	 * 
	 * @param inId
	 *            The step view identifier to set.
	 */
	protected final void setCurrentStepViewIdentifier(WizardStepViewIdentifier inId) {

		// mark all crumbs (if any) to be not current
		for (UCBreadCrumb aCurrentCrumb : breadCrumbs) {
			aCurrentCrumb.setIsCurrent(false);
		} // for

		// determine bread crumb indices of added and current step
		int anIndexOfCurrentCrumb = calculateBreadCrumbIndex(currentViewIdentifier);
		int anIndexOfNewCrumb = calculateBreadCrumbIndex(inId);

		if (anIndexOfNewCrumb == -1) {

			// very first bread crumb to add
			UCBreadCrumb aBreadCrumbToAdd = new UCBreadCrumb(i18n, inId, true);
			breadCrumbs.add(aBreadCrumbToAdd);
			breadCrumbsByStepViewId.put(inId, aBreadCrumbToAdd);
			aBreadCrumbToAdd.setIsCurrent(true);
		} else {

			// mark current step as current
			((UCBreadCrumb) breadCrumbsByStepViewId.get(inId)).setIsCurrent(true);
		} // else

		// remove bread crumbs between steps when steps were skipped
		int anIndexOfAddedCrumb = calculateBreadCrumbIndex(inId);
		List<UCBreadCrumb> aCrumbsToRemove = new ArrayList<UCBreadCrumb>();
		for (int aPos = anIndexOfCurrentCrumb + 1; anIndexOfAddedCrumb - anIndexOfCurrentCrumb > 1
				&& aPos < anIndexOfAddedCrumb; aPos++) {
			aCrumbsToRemove.add(breadCrumbs.get(aPos));
		} // for
		breadCrumbs.removeAll(aCrumbsToRemove);

		// remember current step
		currentViewIdentifier = inId;

		// fire that bread crumbs have changed
		if (!testMode) {
			
			eventBus.fireEvent(new WizardBreadCrumbEvent(getBreadCrumbs()));
		} // if
	}

	/**
	 * Calculates the index of the bread crumb that was created for the given step view identifier.
	 * 
	 * @param inId
	 *            The step view identifier.
	 * @return The index or -1 when no such bread crumb exists.
	 */
	private int calculateBreadCrumbIndex(WizardStepViewIdentifier inId) {

		int outIndex = -1;
		if (inId != null) {

			BreadCrumb aBreadCrumb = breadCrumbsByStepViewId.get(inId);
			if (aBreadCrumb != null) {
				outIndex = breadCrumbs.indexOf(aBreadCrumb);
			} // if
		} // if

		return outIndex;
	}

	/**
	 * Called whenever the wizard moved one step back in order to adjust the bread crumbs.
	 */
	protected void wizardMovedBack() {

		// remove last bread crumb
		UCBreadCrumb aLastBreadCrumb = (UCBreadCrumb) breadCrumbs.get(breadCrumbs.size() - 1);
		breadCrumbs.remove(aLastBreadCrumb);

		// mark last bread crumb as being the current one
		aLastBreadCrumb = (UCBreadCrumb) breadCrumbs.get(breadCrumbs.size() - 1);
		aLastBreadCrumb.setIsCurrent(true);

		if (!testMode) {
			eventBus.fireEvent(new WizardBreadCrumbEvent(getBreadCrumbs()));
		} // if
	}

	/**
	 * Called whenever the wizard moved one step forward in order to adjust the bread crumbs.
	 */
	protected void wizardMovedForward() {
		breadCrumbs.add(new UCBreadCrumb(i18n, currentViewIdentifier, true));
		if (!testMode) {
			eventBus.fireEvent(new WizardBreadCrumbEvent(getBreadCrumbs()));
		} // if
	}

	/**
	 * Activates the test mode by providing default I18N and skipping any event bus notifications.
	 */
	void activateTestMode() {
		testMode = true;
		i18n = new DefaultWizardI18N();
	}

	/**
	 * Resets the controller by removing all bread crumbs.
	 */
	protected void reset() {
		breadCrumbs.clear();
	}
}