package com.uim.autoapi.mapper;

import com.uim.autoapi.pojo.ApiResult;

import java.util.List;

public interface ApiResultMapper {

    /**
     * 添加一条api测试案例
     */
    void insertApiResult(ApiResult apiResult);

    List<ApiResult> selectAllApiResult();
}
