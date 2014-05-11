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