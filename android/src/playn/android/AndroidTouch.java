/**
 * Copyright 2011 The PlayN Authors
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
package playn.android;

import playn.core.Touch;

public class AndroidTouch implements Touch {
  private Listener listener;

  @Override
  public synchronized void setListener(Listener listener) {
    this.listener = listener;
  }

  /*
   * The methods below are called from the GL render thread
   */

  void onTouchStart(Event[] touches) {
    if (listener != null)
      listener.onTouchStart(touches);
  }

  void onTouchMove(Event[] touches) {
    if (listener != null)
      listener.onTouchMove(touches);
  }

  void onTouchEnd(Event[] touches) {
    if (listener != null)
      listener.onTouchEnd(touches);
  }

}
