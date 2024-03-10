package com.itlin.subject.infra.basic.service;

import com.itlin.subject.common.utils.Result;
import com.itlin.subject.infra.basic.bo.SubjectLabelBo;
import com.itlin.subject.infra.basic.entity.SubjectLabel;


/**
 * 题目标签表(SubjectLabel)表服务接口
 *
 * @author makejava
 * @since 2024-03-04 21:53:28
 */
public interface SubjectLabelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectLabel queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectLabel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    //Page<SubjectLabel> queryByPage(SubjectLabel subjectLabel, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    SubjectLabel insert(SubjectLabel subjectLabel);

    /**
     * 修改数据
     *
     * @param subjectLabel 实例对象
     * @return 实例对象
     */
    SubjectLabel update(SubjectLabel subjectLabel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据子分类查标签
     * @param subjectLabelBo
     * @return
     */
    Result queryLabelByCategoryId(SubjectLabelBo subjectLabelBo);
}
