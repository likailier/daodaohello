package com.example.daoyun.util;


import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

public class SmsUtil {
    public static String sendSms(String valcode,String[] phoneNumbers){
        try{
            Credential cred = new Credential(Constants.SMSSECREID, Constants.SMSSECREKEY);


            // 实例化一个http选项，可选，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            // 设置代理
//            httpProfile.setProxyHost("host");
//            httpProfile.setProxyPort(port);
            /* SDK默认使用POST方法。
             * 如果你一定要使用GET方法，可以在这里设置。GET方法无法处理一些较大的请求 */
            httpProfile.setReqMethod("POST");
            /* SDK有默认的超时时间，非必要请不要进行调整
             * 如有需要请在代码中查阅以获取最新的默认值 */
            httpProfile.setConnTimeout(60);
            /* SDK会自动指定域名。通常是不需要特地指定域名的，但是如果你访问的是金融区的服务
             * 则必须手动指定域名，例如sms的上海金融区域名： sms.ap-shanghai-fsi.tencentcloudapi.com */
            httpProfile.setEndpoint("sms.tencentcloudapi.com");


            /* 非必要步骤:
             * 实例化一个客户端配置对象，可以指定超时时间等配置 */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK默认用TC3-HMAC-SHA256进行签名
             * 非必要请不要修改这个字段 */
            clientProfile.setSignMethod("HmacSHA256");
            clientProfile.setHttpProfile(httpProfile);
            /* 实例化要请求产品(以sms为例)的client对象
             * 第二个参数是地域信息，可以直接填写字符串ap-guangzhou，或者引用预设的常量 */
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
            /* 实例化一个请求对象，根据调用的接口和实际情况，可以进一步设置请求参数
             * 你可以直接查询SDK源码确定接口有哪些属性可以设置
             * 属性可能是基本类型，也可能引用了另一个数据结构
             * 推荐使用IDE进行开发，可以方便的跳转查阅各个接口和数据结构的文档说明 */

            SendSmsRequest req = new SendSmsRequest();
            String appid = Constants.SMSAPPID;
            req.setSmsSdkAppid(appid);

            String sign = Constants.SMSSIGN;
            req.setSign(sign);

            String templateID = Constants.SMSTEMPLATEID;
            req.setTemplateID(templateID);

            req.setPhoneNumberSet(phoneNumbers);

            String[] templateParams = {valcode};
            req.setTemplateParamSet(templateParams);

            SendSmsResponse res = client.SendSms(req);
            System.out.println(SendSmsResponse.toJsonString(res));
        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
        return null;
    }
}
