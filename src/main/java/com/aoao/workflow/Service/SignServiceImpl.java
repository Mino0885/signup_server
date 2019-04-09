package com.aoao.workflow.Service;

import com.aoao.workflow.Dao.SignDao;
import com.aoao.workflow.Dao.SignDaoImpl;

import java.util.Map;

public class SignServiceImpl implements SignService {

    @Override
    public Boolean saveGroup(Map<String, Object> signTable) {
        SignDao signDao = new SignDaoImpl();
        return signDao.saveGroup(signTable);
    }
}
