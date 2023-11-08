package com.university.booking_university_project.modules.role.repository;

import com.university.booking_university_project.modules.role.RoleService;
import com.university.booking_university_project.modules.role.dto.RoleCreationDTO;
import com.university.booking_university_project.modules.role.dto.RoleDTO;
import com.university.booking_university_project.modules.role.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Role")
public class RoleController {

  private final RoleService roleService;

  @Autowired
  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @PostMapping("/CreateAll")
  public ResponseEntity<List<RoleDTO>> createRoles(@RequestBody RoleCreationDTO roleCreationDTO) {
    return ResponseEntity.ok(roleService.createRoles(roleCreationDTO));
  }

  @GetMapping("/SearchAll")
  public ResponseEntity<List<RoleDTO>> searchAll() {
    return ResponseEntity.ok(roleService.findAllRolesDTO());
  }

  @PostMapping("/EditAll")
  public ResponseEntity<List<RoleDTO>> editRoles(@RequestBody RoleCreationDTO roleCreationDTO) {
    return ResponseEntity.ok(roleService.editRoles(roleCreationDTO));
  }

  @DeleteMapping("/DeleteAll")
  public ResponseEntity<Void> deleteRoles(List<Integer> ids) {
    roleService.deleteAllByIds(ids);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/Grant")
  public ResponseEntity<Void> grantRoles(@RequestBody List<UserRoleDTO> userRoleDTOList) {
    roleService.grantRoles(userRoleDTOList);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/Revoke")
  public ResponseEntity<Void> revokeRoles(@RequestBody List<UserRoleDTO> userRoleDTOList) {
    roleService.revokeRoles(userRoleDTOList);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
