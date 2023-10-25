package com.university.booking_university_project.modules.baseService;

import com.university.booking_university_project.modules.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceTestImpl extends BaseServiceImpl<BaseServiceTestEntity, Integer, BaseServiceTestRepository> {
    protected BaseServiceTestImpl(BaseServiceTestRepository baseServiceTestRepository) {
        super(baseServiceTestRepository);
    }
}
