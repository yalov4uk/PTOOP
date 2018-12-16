package com.yalovchuk.ptoop.service;

import java.net.URL;
import java.net.URLClassLoader;

public class ShapeLoader {

  @SuppressWarnings("unchecked")
  public <T> T load(String className, URL[] urls) {
    try {
      return (T) new URLClassLoader(urls).loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  @SuppressWarnings("unchecked")
  public <T> T loadInstance(String className, URL[] urls) {
    try {
      return ((Class<? extends T>) load(className, urls)).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
