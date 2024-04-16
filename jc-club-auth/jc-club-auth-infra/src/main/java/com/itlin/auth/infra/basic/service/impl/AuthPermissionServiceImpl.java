package com.itlin.auth.infra.basic.service.impl;

import com.itlin.auth.infra.basic.entity.AuthPermission;
import com.itlin.auth.infra.basic.dao.AuthPermissionDao;
import com.itlin.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthPermission)表服务实现类
 *
 * @author makejava
 * @since 2024-03-31 09:39:59
 */
@Service("authPermissionService")
public class AuthPermissionServiceImpl implements AuthPermissionService {
    @Resource
    private AuthPermissionDao authPermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthPermission queryById(Long id) {
        return this.authPermissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param authPermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<AuthPermission> queryByPage(AuthPermission authPermission, PageRequest pageRequest) {
//        long total = this.authPermissionDao.count(authPermission);
//        return new PageImpl<>(this.authPermissionDao.queryAllByLimit(authPermission, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthPermission insert(AuthPermission authPermission) {
        this.authPermissionDao.insert(authPermission);
        return authPermission;
    }

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthPermission update(AuthPermission authPermission) {
        this.authPermissionDao.update(authPermission);
        return this.queryById(authPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authPermissionDao.deleteById(id) > 0;
    }

    @Override
    public List<AuthPermission> queryByList(List<Long> presionList) {
        return authPermissionDao.queryByList(presionList);

    }
}
