package com.vacv.destination.openapi.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * DestinationDto
 */

@JsonTypeName("Destination")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-29T21:23:49.070811800-04:00[America/Toronto]")
public class DestinationDto {

  @JsonProperty("code")
  private String code;

  @JsonProperty("name")
  private String name;

  @JsonProperty("hotelCodes")
  
  private List<String> hotelCodes = new ArrayList<>();

  public DestinationDto code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
  */
  @NotNull
  @Schema(name = "code", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public DestinationDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DestinationDto hotelCodes(List<String> hotelCodes) {
    this.hotelCodes = hotelCodes;
    return this;
  }

  public DestinationDto addHotelCodesItem(String hotelCodesItem) {
    this.hotelCodes.add(hotelCodesItem);
    return this;
  }

  /**
   * Get hotelCodes
   * @return hotelCodes
  */
  @NotNull
  @Schema(name = "hotelCodes", requiredMode = Schema.RequiredMode.REQUIRED)
  public List<String> getHotelCodes() {
    return hotelCodes;
  }

  public void setHotelCodes(List<String> hotelCodes) {
    this.hotelCodes = hotelCodes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DestinationDto destination = (DestinationDto) o;
    return Objects.equals(this.code, destination.code) &&
        Objects.equals(this.name, destination.name) &&
        Objects.equals(this.hotelCodes, destination.hotelCodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, hotelCodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DestinationDto {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hotelCodes: ").append(toIndentedString(hotelCodes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

