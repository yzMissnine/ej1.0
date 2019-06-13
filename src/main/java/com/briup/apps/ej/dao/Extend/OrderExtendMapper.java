package com.briup.apps.ej.dao.Extend;

/**
 * Created by lishanshan on 2019/6/13
 */
import com.briup.apps.ej.bean.extend.OrderExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderExtendMapper {
    List<OrderExtend> query(
            @Param("customerId") Long customerId,
            @Param("waiterId") Long waiterId
    );
}
