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
import com.google.gwt.event.shared.EventHandler;

/**
 * A handler which is capable of receiving actualized bread crumb information using the
 * {@link EventBus}.
 * 
 * For the visualization/ tracking of bread crumbs a handler must be registered like follows:
 * 
 * <pre>
 * eventBus.addHandler(WizardBreadCrumbEvent.TYPE, new WizardBreadCrumbHandler() {
 * 	public void onBreadCrumbsChanged(Collection&lt;BreadCrumb&gt; inBreadCrumbs) {
 * 		// e.g. update text of UI widget or custom component
 * 	}
 * });
 * </pre>
 * 
 * @author WoG 2014
 */
public interface WizardBreadCrumbHandler extends EventHandler {

	/**
	 * Called when the bread crumbs changed e.g. due to a step move forward or backward.
	 * 
	 * @param inBreadCrumbs
	 *            The bread crumbs.
	 */
	void onBreadCrumbsChanged(Collection<BreadCrumb> inBreadCrumbs);
}