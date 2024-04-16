package com.itlin.auth.infra.basic.service.impl;

import com.itlin.auth.infra.basic.entity.AuthPermission;
import com.itlin.auth.infra.basic.entity.AuthRolePermission;
import com.itlin.auth.infra.basic.dao.AuthRolePermissionDao;
import com.itlin.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限关联表(AuthRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2024-03-31 09:40:00
 */
@Service("authRolePermissionService")
public class AuthRolePermissionServiceImpl implements AuthRolePermissionService {
    @Resource
    private AuthRolePermissionDao authRolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRolePermission queryById(Long id) {
        return this.authRolePermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param authRolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<AuthRolePermission> queryByPage(AuthRolePermission authRolePermission, PageRequest pageRequest) {
//        long total = this.authRolePermissionDao.count(authRolePermission);
//        return new PageImpl<>(this.authRolePermissionDao.queryAllByLimit(authRolePermission, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRolePermission insert(AuthRolePermission authRolePermission) {
        this.authRolePermissionDao.insert(authRolePermission);
        return authRolePermission;
    }

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRolePermission update(AuthRolePermission authRolePermission) {
        this.authRolePermissionDao.update(authRolePermission);
        return this.queryById(authRolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authRolePermissionDao.deleteById(id) > 0;
    }

    @Override
    public List<AuthPermission> query(AuthPermission authPermission) {
        return  authRolePermissionDao.query(authPermission);


    }

    @Override
    public List<AuthRolePermission> queryByList(List<Long> roleIds) {
        return authRolePermissionDao.queryByList(roleIds);
    }
}
