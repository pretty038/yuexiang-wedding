package com.yuexiang.wedding.common.helper;

//import com.tencentcloudapi.common.Credential;
//import com.tencentcloudapi.common.exception.TencentCloudSDKException;
//import com.tencentcloudapi.common.profile.ClientProfile;
//import com.tencentcloudapi.sms.v20190711.SmsClient;
//import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
//import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

public class MessageUtil {
    public static void main(String[] args) {

//        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey，见《创建secretId和secretKey》小节
//        Credential cred = new Credential("2s2e22",
//                "seceawwwe");
//
//        // 实例化要请求产品(以cvm为例)的client对象
//        ClientProfile clientProfile = new ClientProfile();
//        clientProfile.setSignMethod(ClientProfile.SIGN_TC3_256);
//        SmsClient smsClient = new SmsClient(cred, "ap-chongqing");//第二个ap-chongqing 填产品所在的区
//        SendSmsRequest sendSmsRequest = new SendSmsRequest();
//        sendSmsRequest.setSmsSdkAppid("140102072921");//appId ,见《创建应用》小节
//        String[] phones={"+8613020031515"};  //发送短信的目标手机号，可填多个。
//        sendSmsRequest.setPhoneNumberSet(phones);
//        sendSmsRequest.setTemplateID("4976412");  //模版id,见《创建短信签名和模版》小节
//        String [] templateParam={"应用离线了","应用内存溢出，应用down了"};//模版参数，从前往后对应的是模版的{1}、{2}等,见《创建短信签名和模版》小节
//        sendSmsRequest.setTemplateParamSet(templateParam);
//        sendSmsRequest.setSign("腾讯云交付中心"); //签名内容，不是填签名id,见《创建短信签名和模版》小节
//        try {
//            SendSmsResponse sendSmsResponse= smsClient.SendSms(sendSmsRequest); //发送短信
//            System.out.println(sendSmsResponse.toString());
//        } catch (TencentCloudSDKException e) {
//            e.printStackTrace();
//        }

    }
}
