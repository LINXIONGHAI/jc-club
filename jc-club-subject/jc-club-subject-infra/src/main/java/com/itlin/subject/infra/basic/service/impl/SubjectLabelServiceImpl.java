package com.itlin.subject.infra.basic.service.impl;

import com.itlin.subject.common.utils.Result;
import com.itlin.subject.infra.basic.bo.SubjectLabelBo;
import com.itlin.subject.infra.basic.convert.LabelBoToEntity;
import com.itlin.subject.infra.basic.entity.SubjectLabel;
import com.itlin.subject.infra.basic.dao.SubjectLabelDao;
import com.itlin.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 题目标签表(SubjectLabel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-04 21:53:28
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {
    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectLabel> queryByPage(SubjectLabel subjectLabel, PageRequest pageRequest) {
//        long total = this.subjectLabelDao.count(subjectLabel);
//        return new PageImpl<>(this.subjectLabelDao.queryAllByLimit(subjectLabel, pageRequest), pageRequest, total);
////    }

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel insert(SubjectLabel subjectLabel) {
        this.subjectLabelDao.insert(subjectLabel);
        return subjectLabel;
    }

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectLabel update(SubjectLabel subjectLabel) {
        this.subjectLabelDao.update(subjectLabel);
        return this.queryById(subjectLabel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }

    /**
     * 根据子分类查标签
     * @param subjectLabelBo
     * @return
     */
    @Override
    public Result queryLabelByCategoryId(SubjectLabelBo subjectLabelBo) {

        SubjectLabel subjectLabel = LabelBoToEntity.QUERY.convertBoToEntity(subjectLabelBo);

        List<SubjectLabel> list =subjectLabelDao.queryLabelByCategoryId(subjectLabel);
        return Result.ok(list);
    }
}
