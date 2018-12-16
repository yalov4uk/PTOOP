package com.yalovchuk.ptoop.service;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * This class can dynamically load classes and instances.
 */
public class ShapeLoader {

  /**
   * Load class by classname and url where .class located.
   *
   * @param className - classname.
   * @param urls - array of urls, where classes located.
   * @return loaded class.
   */
  @SuppressWarnings("unchecked")
  public <T> T load(String className, URL[] urls) {
    try {
      return (T) new URLClassLoader(urls).loadClass(className);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Load default instance of class by classname and url where .class located.
   *
   * @param className - classname.
   * @param urls - array of urls, where classes located.
   * @return loaded class's instance.
   */
  @SuppressWarnings("unchecked")
  public <T> T loadInstance(String className, URL[] urls) {
    try {
      return ((Class<? extends T>) load(className, urls)).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }
}
