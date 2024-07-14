package com.vectorlink.finance.controller;


import java.util.ArrayList;
import java.util.List;
import com.vectorlink.common.ApiResult;
import com.vectorlink.core.StringParam;
import com.vectorlink.grpc.finance.detail.FinanceDetailControllerApi;
import com.vectorlink.grpc.finance.detail.FinanceDetailModel;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "应结明细")
public class ProviderController implements FinanceDetailControllerApi {

    @Override
    @ApiOperation("应结明细信息")
    public ApiResult<List<FinanceDetailModel>> listAllCompanyDetail(StringParam param) {
        List<FinanceDetailModel> result =new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            result.add(FinanceDetailModel.builder().companyId(i).companyName("测试"+i).financeDetail(Double.valueOf( i*5))
                    .operator("操作员"+i).build());
        }
        return ApiResult.success(
               result
        );
    }
}
