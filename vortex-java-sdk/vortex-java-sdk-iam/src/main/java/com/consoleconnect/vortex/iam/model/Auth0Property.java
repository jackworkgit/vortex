package com.consoleconnect.vortex.iam.model;

import lombok.Data;

@Data
public class Auth0Property {

  private Config mgmtApi;
  private Config app;

  private String mgmtOrgId;

  @Data
  public static class Config {
    private String domain;
    private String clientId;
    private String clientSecret;
    private String audience;
  }
}
