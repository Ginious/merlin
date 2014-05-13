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