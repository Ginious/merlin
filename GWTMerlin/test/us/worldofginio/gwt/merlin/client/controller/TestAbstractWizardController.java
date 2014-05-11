package us.worldofginio.gwt.merlin.client.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import us.worldofginio.gwt.merlin.client.controller.BreadCrumb;
import us.worldofginio.gwt.merlin.client.controller.UCBreadCrumb;
import us.worldofginio.gwt.merlin.client.controller.UCTestController.StepViewId;

/**
 * Test class for the wizard controller.
 * 
 * @author WoG 2014
 */
public class TestAbstractWizardController {

	/**
	 * The controller being tested.
	 */
	private UCTestController controllerUnderTest;

	/**
	 * Ensures that the given step is the marked as being the current one.
	 * 
	 * @param inId
	 *            The identifier of the step to check.
	 */
	private void assertBreadCrumbIsCurrent(StepViewId inId) {
		for (Object aCurrCrumbObj : controllerUnderTest.getBreadCrumbs()) {
			UCBreadCrumb aCurrCrumb = (UCBreadCrumb) aCurrCrumbObj;
			if (aCurrCrumb.getStepViewId() == inId) {
				return;
			} // if
		} // for

		fail("Bread crumb " + inId.name() + " is not current");
	}

	/**
	 * Ensure that the given steps exist as bread crumb in the order as being given.
	 * 
	 * @param inIds
	 *            The identifiers of the steps in their current order.
	 */
	void assertBreadCrumbs(StepViewId... inIds) {

		int anArrayIndex = 0;
		for (Object aCurrCrumb : controllerUnderTest.getBreadCrumbs()) {
			assertTrue("Amount bread crumbs does not match", anArrayIndex < inIds.length);
			assertEquals(inIds[anArrayIndex++], ((UCBreadCrumb) aCurrCrumb).getStepViewId());
		}
	}

	@Before
	public void setup() {
		controllerUnderTest = new UCTestController();
		controllerUnderTest.activateTestMode();
	}

	@Test
	public void testBreadCrumbs_MoveConditional() {

		controllerUnderTest.reset();
		assertBreadCrumbs();

		// start with A
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_A);
		assertBreadCrumbs(StepViewId.PAGE_A);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_A);

		// move to B
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_B);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_B);

		// move to C
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_C);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_C);

		// move back to B
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_B);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_B);

		// move to E and skip C and D
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_E);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_E);

		// move back to B
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_B);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_B);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_B);

		// skip C and move directly to D
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_D);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_D);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_D);

		// move to E
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_E);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_D, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_E);

		// move back to A
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_A);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_D, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_A);

		// move directly to E skipping all others
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_E);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_E);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testBreadCrumbs_MoveForwardAndBack() {

		Collection<BreadCrumb> aBreadCrumbsList = controllerUnderTest.getBreadCrumbs();
		assertTrue(aBreadCrumbsList.isEmpty());

		// start with A
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_A);
		assertEquals(1, controllerUnderTest.getBreadCrumbs().size());
		assertBreadCrumbs(StepViewId.PAGE_A);

		// move forward to B
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_B);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_B);

		// move forward to C
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_C);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_C);

		// move forward to D
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_D);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C, StepViewId.PAGE_D);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_D);

		// move forward to E
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_E);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C, StepViewId.PAGE_D, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_E);

		// move back to D
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_D);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C, StepViewId.PAGE_D, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_D);

		// move back to C
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_C);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C, StepViewId.PAGE_D, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_C);

		// move back to B
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_B);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C, StepViewId.PAGE_D, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_B);

		// move back to A
		controllerUnderTest.setCurrentStepViewIdentifier(StepViewId.PAGE_A);
		assertBreadCrumbs(StepViewId.PAGE_A, StepViewId.PAGE_B, StepViewId.PAGE_C, StepViewId.PAGE_D, StepViewId.PAGE_E);
		assertBreadCrumbIsCurrent(StepViewId.PAGE_A);
	}
}