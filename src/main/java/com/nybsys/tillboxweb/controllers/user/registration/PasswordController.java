/**
 * Created By: Md. Nazmus Salahin
 * Created Date: 29-Dec-17
 * Time: 2:47 PM
 * Modified By:
 * Modified date:
 * (C) CopyRight Nybsys ltd.
 */
package com.nybsys.tillboxweb.controllers.user.registration;

import com.nybsys.tillboxweb.constant.UserRegConst;
import com.nybsys.tillboxweb.core.RequestHelper;
import com.nybsys.tillboxweb.core.RequestMessage;
import com.nybsys.tillboxweb.core.ResponseMessage;
import com.nybsys.tillboxweb.models.user.registration.ChangePasswordModel;
import com.nybsys.tillboxweb.models.user.registration.ForgetPasswordModel;
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
@RequestMapping(UserRegConst.PASSWORD_BASE_URL)
@Api(tags = "User-Registration",value = UserRegConst.PASSWORD_CONTROLLER_NAME, description = UserRegConst.PASSWORD_CONTROLLER_DESCRIPTION)
public class PasswordController {

    @ApiOperation(value = UserRegConst.PASSWORD_FORGET_PASSWORD_GET_DESCRIPTION, response = ForgetPasswordModel.class)
    @RequestMapping(value = UserRegConst.PASSWORD_FORGET_PASSWORD_GET, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage get(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.PASSWORD_BASE_URL+ UserRegConst.PASSWORD_FORGET_PASSWORD_GET, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = UserRegConst.PASSWORD_FORGET_PASSWORD_UPDATE_DESCRIPTION, response = ForgetPasswordModel.class)
    @RequestMapping(value = UserRegConst.PASSWORD_FORGET_PASSWORD_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage update(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.PASSWORD_BASE_URL+ UserRegConst.PASSWORD_FORGET_PASSWORD_UPDATE , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = UserRegConst.PASSWORD_CHANGE_PASSWORD_UPDATE_DESCRIPTION, response = ChangePasswordModel.class)
    @RequestMapping(value = UserRegConst.PASSWORD_CHANGE_PASSWORD_UPDATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage changePassword(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.PASSWORD_BASE_URL+ UserRegConst.PASSWORD_CHANGE_PASSWORD_UPDATE, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }
}
