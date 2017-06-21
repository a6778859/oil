package com.oil.upms.rpc.service.impl;

import com.oil.common.annotation.BaseService;
import com.oil.common.base.BaseServiceImpl;
import com.oil.upms.dao.mapper.OilMapper;
import com.oil.upms.dao.model.Oil;
import com.oil.upms.dao.model.OilExample;
import com.oil.upms.rpc.api.OilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OilService实现
* Created by shuzheng on 2017/6/21.
*/
@Service
@Transactional
@BaseService
public class OilServiceImpl extends BaseServiceImpl<OilMapper, Oil, OilExample> implements OilService {

    private static Logger _log = LoggerFactory.getLogger(OilServiceImpl.class);

    @Autowired
    OilMapper oilMapper;

}