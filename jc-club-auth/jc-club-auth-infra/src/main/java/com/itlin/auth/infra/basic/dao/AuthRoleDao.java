package com.itlin.auth.infra.basic.dao;

import com.itlin.auth.infra.basic.entity.AuthRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AuthRole)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-31 09:39:59
 */
public interface AuthRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param authRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    //List<AuthRole> queryAllByLimit(AuthRole authRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param authRole 查询条件
     * @return 总行数
     */
    long count(AuthRole authRole);

    /**
     * 新增数据
     *
     * @param authRole 实例对象
     * @return 影响行数
     */
    int insert(AuthRole authRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AuthRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AuthRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthRole> entities);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 影响行数
     */
    int update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    AuthRole query(AuthRole authRole);

    List<AuthRole> bachRole(List<Long> roleList);
}

