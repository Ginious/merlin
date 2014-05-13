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
package us.worldofginio.gwt.merlin.client.util;

import java.util.Collection;

import us.worldofginio.gwt.merlin.client.controller.BreadCrumb;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent;

/**
 * Event that can be fired using the GWT {@link EventBus} for notifying listeners about changes of
 * the wizard state e.g. in order to show the name of the current wizard step.
 * 
 * @author WoG 2014
 */
public final class WizardBreadCrumbEvent extends GwtEvent<WizardBreadCrumbHandler> {

	public static final Type<WizardBreadCrumbHandler> TYPE = new Type<WizardBreadCrumbHandler>();

	private Collection<BreadCrumb> breadCrumbs;

	public WizardBreadCrumbEvent(Collection<BreadCrumb> inBreadcrumbs) {
		super();

		breadCrumbs = inBreadcrumbs;
	}

	@Override
	protected void dispatch(WizardBreadCrumbHandler inHandler) {
		inHandler.onBreadCrumbsChanged(breadCrumbs);
	}

	@Override
	public Type<WizardBreadCrumbHandler> getAssociatedType() {
		return TYPE;
	}
}