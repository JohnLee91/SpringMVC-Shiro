package org.seckill.entity;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-25
 * <p>Version: 1.0
 */
public class UrlFilter implements Serializable {
    private Long id;
    private String name; //url名称/描述
    private String url; //地址
    private String roles; //所需要的角色，可省略
    private List<String> rolesList; //用于前端下拉列表显示已拥有的角色时默认选中
    private String permissions; //所需要的权限，可省略
    private Integer available = 1;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
        setRolesListFormRoles();
    }

    public List<String> getRolesList() {
        if(rolesList == null) {
            rolesList = new ArrayList<String>();
        }
        return rolesList;
    }

    public void setRolesList(List<String> rolesList) {
        this.rolesList = rolesList;
        setRolesFormRolesList();
    }

    public void setRolesListFormRoles(){
        if(!StringUtils.isEmpty(roles)) {
            String[] roleStrs = roles.split(",");
            for (String roleStr : roleStrs) {
                if (StringUtils.isEmpty(roleStr)) {
                    continue;
                }
                getRolesList().add(String.valueOf(roleStr));
            }
        }
    }

    public void setRolesFormRolesList(){
        if(!CollectionUtils.isEmpty(rolesList)) {
            StringBuilder s = new StringBuilder();
            for (String role : rolesList) {
                s.append(role);
                s.append(",");
            }

            s.deleteCharAt(s.length()-1);
            this.roles = s.toString();
        }
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UrlFilter urlFilter = (UrlFilter) o;

        if (id != null ? !id.equals(urlFilter.id) : urlFilter.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UrlFilter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", roles='" + roles + '\'' +
                ", permissions='" + permissions + '\'' +
                ", available='" + available + '\'' +
                '}';
    }
}
