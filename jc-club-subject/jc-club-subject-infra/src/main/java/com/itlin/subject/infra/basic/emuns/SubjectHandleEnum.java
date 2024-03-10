package com.itlin.subject.infra.basic.emuns;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public enum SubjectHandleEnum {
    /**
     * 1: 单选
     * 2：多选
     * 3：判断
     * 4：简答
     */

    RADIO(1, "单选"),
    Mulitiple(2, "多选"),
    JUDGE(3, "判断"),
    BRIEF(4, "简答"),
    ;

    int type;
    String desc;

    SubjectHandleEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static SubjectHandleEnum getByType(int type) {
        for (SubjectHandleEnum subjectHandleEnum : SubjectHandleEnum.values()) {

            if (subjectHandleEnum.type == type) {
                return subjectHandleEnum;
            }
        }
        return null;
    }


}
