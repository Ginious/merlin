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