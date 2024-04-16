package com.itlin.auth.domain.service;

import com.itlin.auth.commom.utils.Result;
import com.itlin.auth.domain.bo.AuthUserBo;

public interface UserServiceDomain {
    String registe(AuthUserBo authUserBo);

    Result valid(String valid);
     Result testSentinel();
}
