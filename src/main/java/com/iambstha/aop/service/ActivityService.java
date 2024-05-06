package com.iambstha.aop.service;

import com.iambstha.aop.entity.Activity;

public interface ActivityService {

    public Activity save(Activity activity, Object[] args);
    public void process(Activity activity, Object[] args);

}
