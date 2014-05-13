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