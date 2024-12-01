package com.prestanet.domain;

import com.prestanet.persistence.entity.Usuario;

public class User {

    private int userId;
    private String userName;
    private String password;

    //get y set
    public int getUserId() { return userId;
    }
    public void setUserId(int userId) { this.userId = userId;
    }

    public String getUserName() { return userName;
    }
    public void setUserName(String userName) { this.userName = userName;
    }

    public String getPassword() { return password;
    }
    public void setPassword(String password) { this.password = password;
    }

}