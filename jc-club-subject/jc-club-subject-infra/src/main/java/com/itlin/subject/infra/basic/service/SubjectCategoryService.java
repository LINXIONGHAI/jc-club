package com.itlin.subject.infra.basic.service;

import com.itlin.subject.common.utils.Result;
import com.itlin.subject.infra.basic.bo.SubjectCategoryBo;
import com.itlin.subject.infra.basic.entity.SubjectCategory;


/**
 * 题目分类(SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2024-02-29 23:30:08
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
   // Page<SubjectCategory> queryByPage(SubjectCategory subjectCategory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    void add(SubjectCategoryBo subjectCategoryBo);

    /**
     * 查询分类
     * @param subjectCategoryBo
     * @return
     */
    Result queryPrimaryCategory(SubjectCategoryBo subjectCategoryBo);
}
