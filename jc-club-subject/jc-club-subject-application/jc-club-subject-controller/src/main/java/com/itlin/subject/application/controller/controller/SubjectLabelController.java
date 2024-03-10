package com.itlin.subject.application.controller.controller;

import com.itlin.subject.application.controller.convert.LabelToBo;
import com.itlin.subject.application.controller.dto.SubjectLabelDto;
import com.itlin.subject.common.utils.Result;
import com.itlin.subject.infra.basic.bo.SubjectLabelBo;
import com.itlin.subject.infra.basic.service.SubjectLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject/label")
public class SubjectLabelController {
    @Autowired
    private SubjectLabelService labelService;

    /**
     * 根据子分类查标签
     * @param subjectLabelDto
     * @return
     */
    @PostMapping("queryLabelByCategoryId")
    public Result queryLabelByCategoryId(@RequestBody SubjectLabelDto subjectLabelDto){
        SubjectLabelBo subjectLabelBo = LabelToBo.QUERY.convertToBo(subjectLabelDto);
        return labelService.queryLabelByCategoryId(subjectLabelBo);




    }
}
