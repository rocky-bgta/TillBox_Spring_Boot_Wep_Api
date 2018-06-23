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
import com.nybsys.tillboxweb.models.user.registration.BusinessModel;
import com.nybsys.tillboxweb.models.user.registration.UserModel;
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
@RequestMapping(UserRegConst.BUSINESS_BASE_URL)
@Api(tags = "User-Registration",value = UserRegConst.BUSINESS_CONTROLLER_NAME, description = UserRegConst.BUSINESS_CONTROLLER_DESCRIPTION)
public class BusinessController {

    @ApiOperation(value = UserRegConst.BUSINESS_SAVE_DESCRIPTION, response = BusinessModel.class)
    @RequestMapping(value = UserRegConst.SAVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage save(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.BUSINESS_BASE_URL+ UserRegConst.SAVE, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.BUSINESS_GET_BY_ID_DESCRIPTION, response = BusinessModel.class)
    @RequestMapping(value = UserRegConst.GET_BY_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.BUSINESS_BASE_URL+ UserRegConst.GET_BY_ID, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.BUSINESS_GET_BY_USER_ID_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.BUSINESS_GET_BY_USER_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getByUser(@RequestBody RequestMessage requestMessage) throws MqttException {
        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.BUSINESS_BASE_URL+ UserRegConst.BUSINESS_GET_BY_USER_ID, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value =  UserRegConst.BUSINESS_GET_BUSINESS_OPTIONS_DESCRIPTION, response = BusinessModel.class)
    @RequestMapping(value = UserRegConst.BUSINESS_GET_BUSINESS_OPTIONS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getBusinessOptions(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.BUSINESS_BASE_URL+ UserRegConst.BUSINESS_GET_BUSINESS_OPTIONS, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = UserRegConst.BUSINESS_SEARCH_DESCRIPTION, response = BusinessModel.class)
    @RequestMapping(value = UserRegConst.SEARCH, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage search(@RequestBody RequestMessage requestMessage) throws MqttException {
        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.BUSINESS_BASE_URL+ UserRegConst.SEARCH, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.BUSINESS_SELECT_DESCRIPTION, response = BusinessModel.class)
    @RequestMapping(value = UserRegConst.SELECT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage select(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.BUSINESS_BASE_URL+ UserRegConst.SELECT, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

}
