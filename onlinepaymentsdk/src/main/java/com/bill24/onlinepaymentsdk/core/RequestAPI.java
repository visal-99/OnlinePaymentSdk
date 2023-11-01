package com.bill24.onlinepaymentsdk.core;



import com.bill24.onlinepaymentsdk.model.AddToFavoriteModel;
import com.bill24.onlinepaymentsdk.model.CheckoutDetailModel;
import com.bill24.onlinepaymentsdk.model.ExpiredTransactionModel;
import com.bill24.onlinepaymentsdk.model.GenerateLinkDeepLinkModel;
import com.bill24.onlinepaymentsdk.model.baseResponseModel.BaseResponse;
import com.bill24.onlinepaymentsdk.model.conts.Constant;
import com.bill24.onlinepaymentsdk.model.requestModel.AddToFavoriteRequestModel;
import com.bill24.onlinepaymentsdk.model.requestModel.CheckoutDetailRequestModel;
import com.bill24.onlinepaymentsdk.model.requestModel.ExpiredRequestModel;
import com.bill24.onlinepaymentsdk.model.requestModel.GenerateDeeplinkRequestModel;

import retrofit2.Call;

public class RequestAPI {

    private final String refererKey;
    private final String baseUrl;
    public RequestAPI(String refererKey,String baseUrl){
        this.refererKey=refererKey;
        this.baseUrl=baseUrl;
    }

    public Call<BaseResponse<CheckoutDetailModel>> postCheckoutDetail(CheckoutDetailRequestModel model){
        return RetrofitClient.getInstance(baseUrl).getApiClient()
                .postCheckoutDetail(Constant.CONTENT_TYPE,Constant.TOKEN,refererKey,model);
    }

    public  Call<BaseResponse<ExpiredTransactionModel>> postExpireTran(ExpiredRequestModel model){
        return  RetrofitClient.getInstance(baseUrl).getApiClient().
                        postExpiredTransaction(Constant.CONTENT_TYPE,Constant.TOKEN,refererKey,model);
    }
    public Call<BaseResponse<GenerateLinkDeepLinkModel>> postGenerateDeeplink(GenerateDeeplinkRequestModel model){
        return RetrofitClient.getInstance(baseUrl).getApiClient().
                postGenerateDeepLink(Constant.CONTENT_TYPE,Constant.TOKEN,refererKey,model);
    }
    public Call<BaseResponse<AddToFavoriteModel>> postAddToFavorite(AddToFavoriteRequestModel model){
        return RetrofitClient.getInstance(baseUrl).getApiClient().
                postAddToFavorite(Constant.CONTENT_TYPE,Constant.TOKEN,refererKey,model);
    }
}
