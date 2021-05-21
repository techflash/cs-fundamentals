/**
 * Copyright 2018. All rights reserved. All rights, titles and interest in and to this software are
 * owned by Market Logic Software AG, Berlin, Germany. Permission to use, copy, modify, distribute
 * or otherwise make this software available to any third party and for any purpose requires a
 * signed licensing agreement. Visit us at www.MarketLogicSoftware.com for commercial licensing
 * opportunities.
 */
package general;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class Inner extends HashMap<String, String> implements Serializable {
  private static final long serialVersionUID = 1L;

  private String id = null;

  private String text = null;

  public Inner id(String id) {
    this.id = id;
    return this;
  }


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Inner text(String text) {
    this.text = text;
    return this;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Inner inner = (Inner) o;
    return Objects.equals(this.id, inner.id)
        && Objects.equals(this.text, inner.text)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Inner {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
