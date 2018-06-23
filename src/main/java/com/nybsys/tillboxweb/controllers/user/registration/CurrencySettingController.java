/**
 * Created By: Md. Rashed Khan Menon
 * Created Date: 03-05-2018
 * Time: 12:20 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight Nybsys ltd.
 */
package com.nybsys.tillboxweb.controllers.user.registration;

import com.nybsys.tillboxweb.constant.UserRegConst;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.expense.BlankModel;
import com.nybsys.tillboxweb.models.user.registration.VMCurrencySettingModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.nybsys.tillboxweb.constant.WorkerPublishedConstants.WORKER_USER_REGISTRATION_MODULE_TOPIC;

@RestController
@RequestMapping(UserRegConst.CURRENCY_SETTING_BASE_URL)
@Api(tags = "User-Registration",value = UserRegConst.CURRENCY_SETTING_CONTROLLER_NAME, description = UserRegConst.CURRENCY_SETTING_CONTROLLER_DESCRIPTION)
public class CurrencySettingController {

    @ApiOperation(value = UserRegConst.CURRENCY_SETTING_SAVE_DESCRIPTION, response = VMCurrencySettingModel.class)
    @RequestMapping(value = UserRegConst.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {
        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_SETTING_BASE_URL+ UserRegConst.SAVE , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.CURRENCY_SETTING_GET_BY_BUSINESS_ID_DESCRIPTION, response = BlankModel.class)
    @RequestMapping(value = UserRegConst.CURRENCY_SETTING_GET_BY_BUSINESS_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByBusinessID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.CURRENCY_SETTING_BASE_URL+ UserRegConst.CURRENCY_SETTING_GET_BY_BUSINESS_ID , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
}
