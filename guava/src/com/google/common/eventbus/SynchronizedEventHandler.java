/*
 * Copyright (C) 2007 The Guava Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.eventbus;


/**
 * Wraps a (potentially) non-thread-safe EventHandler, ensuring only one thread can
 * access it at a time
 *
 * @author Cliff Biffle, Kris J. Pruden
 */
public class SynchronizedEventHandler implements EventHandler {
  private EventHandler wrapped;

  /**
   * Creates a new SynchronizedEventHandler to wrap an underlying
   * unsynchronized handler
   *
   * @param target  object to which the method applies.
   * @param method  handler method.
   */
  public SynchronizedEventHandler(EventHandler wrapped) {
    this.wrapped = wrapped;
  }

  @Override public synchronized void handleEvent(Object event) throws Exception {
    wrapped.handleEvent(event);
  }


  @Override public String toString() {
    return "[synchronized " + wrapped + "]";
  }

  @Override public int hashCode() {
    final int PRIME = 269;
    return (PRIME + wrapped.hashCode());
  }

  @Override public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }

    if(obj == null) {
      return false;
    }

    if(getClass() != obj.getClass()) {
      return false;
    }

    final SynchronizedEventHandler other = (SynchronizedEventHandler) obj;

    return this.wrapped.equals(other.wrapped);
  }
}
