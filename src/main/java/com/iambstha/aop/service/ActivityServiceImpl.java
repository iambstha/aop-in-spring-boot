package com.iambstha.aop.service;

import com.iambstha.aop.entity.Activity;
import com.iambstha.aop.repository.ActivityRepository;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class ActivityServiceImpl implements  ActivityService {

    @Autowired
    private final ActivityRepository activityRepository;

    @Override
    public Activity save(Activity activity, Object[] args) {
        if(Objects.equals(activity.getRemark(), "")){
            String remark = "Updated remark";
            activity.setRemark(remark);
        }
        return activityRepository.save(activity);
    }

    @Override
    @Async("activityExecute")
    public void process(Activity activity, Object[] args) {

        try {
            Thread.sleep(1);
            this.save(activity, args);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
