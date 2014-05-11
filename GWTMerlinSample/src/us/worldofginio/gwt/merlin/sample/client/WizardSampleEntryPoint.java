package us.worldofginio.gwt.merlin.sample.client;

import java.util.Collection;

import us.worldofginio.gwt.merlin.client.controller.BreadCrumb;
import us.worldofginio.gwt.merlin.client.presenter.WizardPresenter;
import us.worldofginio.gwt.merlin.client.util.WizardBreadCrumbEvent;
import us.worldofginio.gwt.merlin.client.util.WizardBreadCrumbHandler;
import us.worldofginio.gwt.merlin.sample.client.wizard.BasicWizardAction;
import us.worldofginio.gwt.merlin.sample.client.wizard.shared.model.SampleModel;
import us.worldofginio.gwt.merlin.sample.client.wizard.step1.WizardStepPresenter1DateOfBirth;
import us.worldofginio.gwt.merlin.sample.client.wizard.step2.WizardStepPresenter2Name;
import us.worldofginio.gwt.merlin.sample.client.wizard.step3.WizardStepPresenter3Decision;
import us.worldofginio.gwt.merlin.sample.client.wizard.step4.WizardStepPresenter4ChildName;
import us.worldofginio.gwt.merlin.sample.client.wizard.step5.WizardStepPresenter5Summary;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WizardSampleEntryPoint implements EntryPoint {

	static final WizardSampleGinjector INJECTOR = GWT.create(WizardSampleGinjector.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// build main page GUI and add to root panel
		VerticalPanel aMainVPanel = new VerticalPanel();
		RootPanel.get("content").add(aMainVPanel);
		final HorizontalPanel aHPanel = new HorizontalPanel();
		aMainVPanel.add(aHPanel);

		// register bread crumb handler before wizard presenter is created otherwise
		// first bread crumb is initially not being shown
		INJECTOR.getEventBus().addHandler(WizardBreadCrumbEvent.TYPE, new WizardBreadCrumbHandler() {

			@Override
			public void onBreadCrumbsChanged(Collection<BreadCrumb> inBreadCrumbs) {

				// remove previous bread crumb labels
				aHPanel.clear();

				// add all bread crumbs that exist
				boolean aFirstCrumb = true;
				for (BreadCrumb aCurrentCrumb : inBreadCrumbs) {

					// add separator after first bread crumb for each crumb
					if (!aFirstCrumb) {
						Label aSeparator = new Label(" > ");
						aSeparator.addStyleName("breadCrumb");
						aHPanel.add(aSeparator);
					} // if

					// create and add new label for current bread crumb
					Label aCurrLabel = new Label(aCurrentCrumb.getTitle());
					aHPanel.add(aCurrLabel);
					if (aCurrentCrumb.isCurrent()) {
						aCurrLabel.addStyleName("breadCrumbCurrent");
					} else {
						aCurrLabel.addStyleName("breadCrumb");
					} // else

					aFirstCrumb = false;
				} // for
			}
		});

		WizardPresenter aPresenter = INJECTOR.getWizardPresenter();

		aPresenter.registerWizardStepPresenters(new WizardStepPresenter1DateOfBirth(), new WizardStepPresenter2Name(),
				new WizardStepPresenter3Decision(), new WizardStepPresenter4ChildName(),
				new WizardStepPresenter5Summary());
		aPresenter.registerWizardActions(BasicWizardAction.BACK, BasicWizardAction.FORWARD, BasicWizardAction.FINISH,
				BasicWizardAction.CANCEL);

		aPresenter.startWizard(aMainVPanel, new SampleModel());
	}
}