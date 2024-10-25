package com.consoleconnect.vortex.iam.controller;

import com.auth0.json.mgmt.roles.Role;
import com.consoleconnect.vortex.core.model.HttpResponse;
import com.consoleconnect.vortex.core.toolkit.Paging;
import com.consoleconnect.vortex.core.toolkit.PagingHelper;
import com.consoleconnect.vortex.iam.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController()
@RequestMapping(value = "/organizations/{orgId}/roles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Organization", description = "Organization APIs")
@Slf4j
public class OrganizationRoleController {

  private final OrganizationService service;

  @Operation(summary = "List all roles")
  @GetMapping("")
  public HttpResponse<Paging<Role>> search(
      @PathVariable String orgId,
      @RequestParam(value = "page", required = false, defaultValue = PagingHelper.DEFAULT_PAGE_STR)
          int page,
      @RequestParam(value = "size", required = false, defaultValue = PagingHelper.DEFAULT_SIZE_STR)
          int size) {
    return HttpResponse.ok(service.listRoles(orgId, page, size));
  }
}