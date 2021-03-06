package net.sf.anathema.lib.util;

public class Identificate implements Identified {

  private final String id;

  public Identificate(String id) {
    this.id = id;
  }

  @Override
  public final String getId() {
    return id;
  }

  @Override
  public String toString() {
    return id;
  }

  @Override
  public final boolean equals(Object obj) {
    if (!(obj instanceof Identificate)) {
      return false;
    }
    Identificate other = (Identificate) obj;
    return other.id.equals(id);
  }

  @Override
  public final int hashCode() {
    return getId().hashCode();
  }
}