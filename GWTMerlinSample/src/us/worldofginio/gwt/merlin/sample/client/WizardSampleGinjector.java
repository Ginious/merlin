package us.worldofginio.gwt.merlin.sample.client;

import us.worldofginio.gwt.merlin.client.controller.WizardController;
import us.worldofginio.gwt.merlin.client.presenter.WizardPresenter;
import us.worldofginio.gwt.merlin.client.presenter.WizardPresenterImpl;
import us.worldofginio.gwt.merlin.client.util.WizardI18N;
import us.worldofginio.gwt.merlin.client.view.WizardView;
import us.worldofginio.gwt.merlin.client.view.WizardViewImpl;
import us.worldofginio.gwt.merlin.sample.client.wizard.BasicWizardController;
import us.worldofginio.gwt.merlin.sample.client.wizard.BasicWizardI18N;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.inject.Singleton;

/**
 * @author WoG 2014
 */
@GinModules({ WizardSampleGinjector.Module.class })
public interface WizardSampleGinjector extends Ginjector {

	class Module extends AbstractGinModule {

		@Override
		protected void configure() {

			// required for bread crumb actualisation
			bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);

			// needed as class gets data injected
			bind(WizardView.class).to(WizardViewImpl.class).in(Singleton.class);

			bind(WizardI18N.class).to(BasicWizardI18N.class).in(Singleton.class);
			bind(WizardPresenter.class).to(WizardPresenterImpl.class).in(Singleton.class);
			bind(WizardController.class).to(BasicWizardController.class).in(Singleton.class);
		}
	}

	WizardPresenterImpl getWizardPresenter();

	EventBus getEventBus();
}