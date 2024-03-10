package com.itlin.subject.application.controller.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.itlin.subject.application.controller.convert.CategoryDtoToBo;
import com.itlin.subject.application.controller.dto.SubjectCategoryDto;
import com.itlin.subject.common.utils.Result;
import com.itlin.subject.infra.basic.bo.SubjectCategoryBo;
import com.itlin.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Autowired
    private SubjectCategoryService subjectCategoryService;


    /**
     * Test
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody SubjectCategoryDto subjectCategoryDto) {

        Preconditions.checkNotNull(subjectCategoryDto.getCategoryName(),"分类名称不能为空");

        //使用切面进行日志记录
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController: add subjectCategoryDto:{} ", JSON.toJSONString(subjectCategoryDto));
        }
        SubjectCategoryBo subjectCategoryBo = CategoryDtoToBo.INSERT.convertDtoToBo(subjectCategoryDto);
        subjectCategoryService.add(subjectCategoryBo);
        return Result.ok();
    }

    /**
     * 查询分类
     * @param subjectCategoryDto
     * @return
     */
    @PostMapping("/queryPrimaryCategory")
    public Result queryPrimaryCategory(@RequestBody SubjectCategoryDto subjectCategoryDto){
        SubjectCategoryBo subjectCategoryBo = CategoryDtoToBo.INSERT.convertDtoToBo(subjectCategoryDto);
        return subjectCategoryService.queryPrimaryCategory(subjectCategoryBo);
    }
    /**
     *
     */
    @PostMapping("/queryCategoryByPrimary")
    public Result queryCategoryByPrimary(@RequestBody SubjectCategoryDto subjectCategoryDto){
        SubjectCategoryBo subjectCategoryBo = CategoryDtoToBo.INSERT.convertDtoToBo(subjectCategoryDto);
        return subjectCategoryService.queryPrimaryCategory(subjectCategoryBo);
    }




}
