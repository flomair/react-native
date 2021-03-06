// Copyright 2004-present Facebook. All Rights Reserved.

package com.facebook.react.bridge;

import javax.annotation.Nullable;

import com.facebook.proguard.annotations.DoNotStrip;
/**
 * Static class that allows markers to be placed in React code and responded to in a
 * configurable way
 */
@DoNotStrip
public class ReactMarker {

  public interface MarkerListener {
    void logMarker(String name);
  };

  @Nullable static private MarkerListener sMarkerListener = null;

  public static void setMarkerListener(MarkerListener listener) {
    SoftAssertions.assertCondition(
      sMarkerListener == null,
      "MarkerListener is being overwritten.");
    sMarkerListener = listener;
  }

  @DoNotStrip
  public static void logMarker(String name) {
    if (sMarkerListener != null) {
      sMarkerListener.logMarker(name);
    }
  }
}
