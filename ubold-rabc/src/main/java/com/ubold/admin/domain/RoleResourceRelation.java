package com.ubold.admin.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户角色关联
 * Created by lenovo on 2017/11/11.
 */
@Data
@Entity
@Table(name = "TB_RBAC_ROLE_RESOURCE_RELATION")
public class RoleResourceRelation extends Auditable {

    private String userId;
    private String resourceId;
}
