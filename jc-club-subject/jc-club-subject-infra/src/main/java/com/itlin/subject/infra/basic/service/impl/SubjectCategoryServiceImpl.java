package com.itlin.subject.infra.basic.service.impl;

import com.itlin.subject.common.utils.Result;
import com.itlin.subject.infra.basic.bo.SubjectCategoryBo;
import com.itlin.subject.infra.basic.convert.CategoryBoToEntity;
import com.itlin.subject.infra.basic.entity.SubjectCategory;
import com.itlin.subject.infra.basic.dao.SubjectCategoryDao;
import com.itlin.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 题目分类(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2024-02-29 23:30:08
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Long id) {
        return this.subjectCategoryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectCategory> queryByPage(SubjectCategory subjectCategory, PageRequest pageRequest) {
//        long total = this.subjectCategoryDao.count(subjectCategory);
//        return new PageImpl<>(this.subjectCategoryDao.queryAllByLimit(subjectCategory, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory update(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.update(subjectCategory);
        return this.queryById(subjectCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectCategoryDao.deleteById(id) > 0;
    }

    /**
     * 新增分类
     * @param subjectCategoryBo
     */
    @Override
    public void add(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = CategoryBoToEntity.INSERT.convertToEntity(subjectCategoryBo);
        int insert = subjectCategoryDao.insert(subjectCategory);

    }

    /**
     * 查询分类
     * @param subjectCategoryBo
     * @return
     */
    @Override
    public Result queryPrimaryCategory(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = CategoryBoToEntity.QUERY.convertToEntity(subjectCategoryBo);

        List<SubjectCategory>  list=subjectCategoryDao.query(subjectCategory);

        return Result.ok(list);
    }
}
