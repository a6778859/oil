package com.oil.upms.rpc.api;

import com.oil.common.base.BaseServiceMock;
import com.oil.upms.dao.mapper.OilMapper;
import com.oil.upms.dao.model.Oil;
import com.oil.upms.dao.model.OilExample;

/**
* 降级实现OilService接口
* Created by shuzheng on 2017/6/21.
*/
public class OilServiceMock extends BaseServiceMock<OilMapper, Oil, OilExample> implements OilService {

}
