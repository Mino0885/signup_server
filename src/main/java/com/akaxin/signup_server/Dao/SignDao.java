package com.akaxin.signup_server.Dao;

import java.util.Map;

public interface SignDao {
    Boolean saveGroup(Map<String,Object> signTable);
}
