package com.ahk.program.ui.db_access;

import java.io.Serializable;

public interface AsyncDBAccess extends Serializable {

    public void onSuccess();

    public void onError(Exception e);

}
