/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package playn.flash.json.impl;

import playn.flash.json.JsonNumber;
import playn.flash.json.JsonType;
import playn.flash.json.JsonValue;

/**
 * Server-side implementation of JsonNumber.
 */
public class JreJsonNumber extends JreJsonValue implements JsonNumber {

  private double number;

  public JreJsonNumber(double number) {
    this.number = number;
  }

  @Override
  public double getNumber() {
    return number;
  }

  @Override
  public Object getObject() {
    return getNumber();
  }

  @Override
  public JsonType getType() {
    return JsonType.NUMBER;
  }

  @Override
  public boolean jsEquals(JsonValue value) {
    return getObject().equals(((JreJsonValue)value).getObject());
  }

  @Override
  public void traverse(JsonVisitor visitor, playn.flash.json.impl.JsonContext ctx) {
    visitor.visit(getNumber(), ctx);
  }

  @Override
  public String toJson() {
    String toReturn = String.valueOf(number);
    if (toReturn.endsWith(".0")) {
      toReturn = toReturn.substring(0, toReturn.length() - 2);
    }
    return toReturn;
  }
}
