package com.hexaware.ftp82.exceptions;
/**
 * Notfoundexception class.
 */
public class NotFoundException extends Exception {
/**
 * String value for exception class.
 */
  public NotFoundException() {
    super();
  }
/**
 *@param name as the string message.
 */
  public NotFoundException(final String name) {
    super(name);
  }
}
