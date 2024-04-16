package com.itlin.subject.infra.basic.es.service;

import com.itlin.subject.infra.basic.es.SubjectInfoEs;

public interface EsSubjectService {

    boolean addDoc(SubjectInfoEs subjectInfoEs);

    Object findDoc();

}
