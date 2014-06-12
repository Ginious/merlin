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

import us.worldofginio.gwt.merlin.client.util.WizardBreadCrumbHandler;

/**
 * A bread crumb is a textual representation of a wizard step that is normally used for displaying
 * the progress of a wizard in terms of step titles to increase transparency and usability. The
 * usage of bread crumbs along with this wizard implementation is optional.
 * 
 * See {@link WizardBreadCrumbHandler} for details on how to receive bread crumb information.
 * 
 * @author WoG 2014
 */
public interface BreadCrumb {

	/**
	 * Gets the title of this step to be shown as a bread crumb.
	 * 
	 * @return The title.
	 */
	String getTitle();

	/**
	 * Indicates whether or not this bread crumb represent the current wizard step.
	 * 
	 * @return The switch indicating whether or not this bread crumb represent the current wizard
	 *         step.
	 */
	boolean isCurrent();
}