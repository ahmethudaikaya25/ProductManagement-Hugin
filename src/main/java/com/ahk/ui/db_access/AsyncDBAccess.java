package com.ahk.ui.db_access;

public interface AsyncDBAccess {

    public void onSuccess();

    public void onError(Exception e);

}
