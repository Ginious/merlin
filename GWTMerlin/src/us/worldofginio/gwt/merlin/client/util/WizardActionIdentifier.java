package us.worldofginio.gwt.merlin.client.util;

import us.worldofginio.gwt.merlin.client.controller.WizardController;

/**
 * Tagging interface for an identifier of a wizard action that will be used to uniquely identify
 * each action that will provided as wizard button. The {@link WizardController} works based on
 * those identifiers..
 * 
 * When implementing a custom wizard the best idea is to implement an enumeration type that
 * implements this interface and that provides all actions that are required.
 * 
 * @author WoG 2014
 */
public interface WizardActionIdentifier {

}