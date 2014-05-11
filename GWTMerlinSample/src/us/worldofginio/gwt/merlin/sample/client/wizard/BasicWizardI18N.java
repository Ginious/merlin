package us.worldofginio.gwt.merlin.sample.client.wizard;

import us.worldofginio.gwt.merlin.client.util.WizardActionIdentifier;
import us.worldofginio.gwt.merlin.client.util.WizardI18N;
import us.worldofginio.gwt.merlin.client.view.WizardStepViewIdentifier;

public class BasicWizardI18N implements WizardI18N {

	@Override
	public String getTitle() {

		return "WoG Sample Wizard";
	}

	@Override
	public String getLabelForWizardAction(WizardActionIdentifier inAction) {

		if (inAction == BasicWizardAction.BACK) {
			return "Zur�ck";
		} else if (inAction == BasicWizardAction.CANCEL) {
			return "Abbrechen";
		} else if (inAction == BasicWizardAction.FINISH) {
			return "Abschliessen";
		} else if (inAction == BasicWizardAction.FORWARD) {
			return "Weiter";
		}

		throw new RuntimeException("Nicht unterstuetzte Page Action: " + inAction.toString());
	}

	@Override
	public String getTooltipForWizardAction(WizardActionIdentifier inAction) {

		if (inAction == BasicWizardAction.BACK) {
			return "Eine Seite zur�ck";
		} else if (inAction == BasicWizardAction.CANCEL) {
			return "Wizard abbrechen und �nderungen verwerfen";
		} else if (inAction == BasicWizardAction.FINISH) {
			return "Abschliessen und Meldung einreichen";
		} else if (inAction == BasicWizardAction.FORWARD) {
			return "Weiter zur n�chsten Seite";
		}

		throw new RuntimeException("Nicht unterstuetzte Page Action: " + inAction.toString());
	}

	@Override
	public String getStepTitle(WizardStepViewIdentifier inStepViewId) {

		String outTitle = null;

		if (inStepViewId == BasicWizardStepViewIdentifier.A_DATEOFBIRTH) {
			outTitle = "Date of Birth";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.B_NAME) {
			outTitle = "Name";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.C_DECISION) {
			outTitle = "Children";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.D_CHILDNAME) {
			outTitle = "Child Name";
		} else if (inStepViewId == BasicWizardStepViewIdentifier.E_SUMMARY) {
			outTitle = "Summary";
		} // else if

		return outTitle;
	}
}