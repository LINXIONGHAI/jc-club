package com.itlin.subject.infra.basic.service;

import com.itlin.subject.infra.basic.entity.SubjectJudge;

/**
 * 判断题(SubjectJudge)表服务接口
 *
 * @author makejava
 * @since 2024-03-05 11:34:56
 */
public interface SubjectJudgeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectJudge queryById(Long id);

    /**
     * 分页查询
     *
     * @param subjectJudge 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    //Page<SubjectJudge> queryByPage(SubjectJudge subjectJudge, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge insert(SubjectJudge subjectJudge);

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge update(SubjectJudge subjectJudge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
