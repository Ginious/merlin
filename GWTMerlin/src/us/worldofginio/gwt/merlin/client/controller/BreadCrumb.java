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