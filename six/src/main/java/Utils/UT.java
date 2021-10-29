package Utils;

import java.time.Instant;
import it.euris.academy.six.data.enums.MovieCategory;

public class UT {
  
  public static Long toLong(String value) {
    return value == null ? null : Long.parseLong(value);
  }

  public static Double toDouble(String value) {
    return value == null ? null : Double.parseDouble(value);
  }

  public static Instant toInstant(String value) {
    return value == null ? null : Instant.parse(value);
  }

  public static String fromInstant(Instant value) {
    return value == null ? null : value.toString();
  }
  
  public static String numberToString(Number value) {
    return value == null ? null : value.toString();
  }

  public static Integer toInteger(String value) {
    return value == null ? null : Integer.parseInt(value);
  }
  
  public static String getMovieCategory(MovieCategory value) {
    return value == null ? null : value.name();
  }
  
  public static MovieCategory getMovieCategory(String value) {
    if (value==null) {
      return null;
    }
    for (MovieCategory type : MovieCategory.values()) {
      if (type.name().equals(value)) {
        return type;
      }
    }
    return null;
  }
  

}
