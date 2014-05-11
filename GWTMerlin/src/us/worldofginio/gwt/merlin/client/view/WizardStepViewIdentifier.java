package us.worldofginio.gwt.merlin.client.view;

import us.worldofginio.gwt.merlin.client.controller.WizardController;

/**
 * Tagging interface for an identifier of a wizard step view that will be used to uniquely identify
 * each view that will/ can provided by the wizard. The {@link WizardController} works based on
 * those identifiers when determining the next step to display.
 * 
 * When implementing a custom wizard the best idea is to implement an enumeration type that
 * implements this interface and that provides all step that are required.
 * 
 * @author WoG 2014
 */
public interface WizardStepViewIdentifier {

}