package com.wang.bean;

import java.io.Serializable;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wang.util.JSON;

/**
 * The {@code Beans} Class used to contains the Bean in query. <br>
 * it's includes the total count for the query
 * 
 * @param <T>
 *          the generic type
 */
public final class Beans<E extends Bean> extends ArrayList<E> implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 2L;

  /** The log. */
  protected static Log      log              = LogFactory.getLog(Beans.class);

  /** The total. */
  public int                total            = -1;                            // unknown

  public JSON               stats;

  public long               cost             = -1;

  public List<String>       columns          = null;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public JSON getStats() {
    return stats;
  }

  public void setStats(JSON stats) {
    this.stats = stats;
  }

  public long getCost() {
    return cost;
  }

  public void setCost(long cost) {
    this.cost = cost;
  }

  public List<String> getColumns() {
    return columns;
  }

  public void setColumns(List<String> columns) {
    this.columns = columns;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  public String toString() {
    return "Beans[total=" + total + ", size=" + size() + "]";
  }

}
