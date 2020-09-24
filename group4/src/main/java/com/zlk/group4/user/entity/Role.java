package com.zlk.group4.user.entity;

/**
 * @author:sunjiahe
 * @date:2020/9/22
 * @descreption:角色实体类
 */
public class Role {
       /**角色id*/
       private Integer roleId;
       /**角色名称*/
       private String roleName;

       public Role() {
       }

       public Role(Integer roleId, String roleName) {
              this.roleId = roleId;
              this.roleName = roleName;
       }

       public Integer getRoleId() {
              return roleId;
       }

       public void setRoleId(Integer roleId) {
              this.roleId = roleId;
       }

       public String getRoleName() {
              return roleName;
       }

       public void setRoleName(String roleName) {
              this.roleName = roleName;
       }

       @Override
       public String toString() {
              return "Role{" +
                      "roleId=" + roleId +
                      ", roleName='" + roleName + '\'' +
                      '}';
       }
}
