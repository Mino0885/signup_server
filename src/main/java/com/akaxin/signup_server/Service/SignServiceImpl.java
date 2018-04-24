package com.akaxin.signup_server.Service;

import com.akaxin.signup_server.Dao.SignDao;
import com.akaxin.signup_server.Dao.SignDaoImpl;

import java.util.Map;

public class SignServiceImpl implements SignService {

    @Override
    public Boolean saveGroup(Map<String, Object> signTable) {
        SignDao signDao = new SignDaoImpl();
        return signDao.saveGroup(signTable);
    }
}
