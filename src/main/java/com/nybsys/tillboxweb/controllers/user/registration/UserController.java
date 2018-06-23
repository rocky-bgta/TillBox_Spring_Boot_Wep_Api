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
import com.nybsys.tillboxweb.models.user.registration.RegistrationInvitationModel;
import com.nybsys.tillboxweb.models.user.registration.TokenModel;
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
@RequestMapping(UserRegConst.USER_BASE_URL)
@Api(tags = "User-Registration",value = UserRegConst.USER_CONTROLLER_NAME, description = UserRegConst.USER_CONTROLLER_DESCRIPTION)
public class UserController {

    @ApiOperation(value = UserRegConst.USER_SIGN_UP_DESCRIPTION, response = RegistrationInvitationModel.class)
    @RequestMapping(value = UserRegConst.USER_SIGN_UP, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage signUpInvitation(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.USER_SIGN_UP , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.USER_SIGN_UP_CONFIRMATION_DESCRIPTION, response = TokenModel.class)
    @RequestMapping(value = UserRegConst.USER_SIGN_UP_CONFIRMATION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage signUp(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock( UserRegConst.USER_BASE_URL+ UserRegConst.USER_SIGN_UP_CONFIRMATION, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.USER_LOGIN_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.USER_LOGIN, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage login(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.USER_LOGIN , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        System.out.println(responseMessage);
        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.USER_GET_ALL_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.GET_ALL, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllUsers(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.GET_ALL, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.USER_GET_BY_ID_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.GET_BY_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getUserById(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.GET_BY_ID, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.USER_GET_ACTIVE_USER_LIST_BY_BUSINESS_ID_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.USER_GET_ACTIVE_USER_LIST_BY_BUSINESS_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getUserListByBusinessID(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.USER_GET_ACTIVE_USER_LIST_BY_BUSINESS_ID, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = UserRegConst.USER_GET_ACTIVE_INACTIVE_INVITED_USER_LIST_BY_BUSINESS_ID_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.USER_GET_ACTIVE_INACTIVE_INVITED_USER_LIST_BY_BUSINESS_ID, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getUserListActiveAndInactiveAndInvited(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.USER_GET_ACTIVE_INACTIVE_INVITED_USER_LIST_BY_BUSINESS_ID, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }
    @ApiOperation(value = UserRegConst.USER_EDIT_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.USER_EDIT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage editUser(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.USER_EDIT, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;
    }

    @ApiOperation(value = UserRegConst.USER_ACTIVE_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.USER_ACTIVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage activateUser(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.USER_ACTIVE, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = UserRegConst.USER_INACTIVE_DESCRIPTION, response = UserModel.class)
    @RequestMapping(value = UserRegConst.USER_INACTIVE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage inActivateUser(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock(UserRegConst.USER_BASE_URL+ UserRegConst.USER_INACTIVE, WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = "Update user by conditions", response = UserModel.class)
    @RequestMapping(value = "updateByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage updateByConditions(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/user/updateByCondition" , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = "Delete user by conditions", response = UserModel.class)
    @RequestMapping(value = "deleteByCondition", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage deleteByConditions(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/user/deleteByCondition" , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = "Check InterCom", response = UserModel.class)
    @RequestMapping(value = "checkInterCom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage checkInterCom(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/user/checkInterCom", WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = "History Test", response = UserModel.class)
    @RequestMapping(value = "historyTest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage historyTest(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/user/historyTest" , WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }

    @ApiOperation(value = "", response = Object.class)
    @RequestMapping(value = "getAllAccountThroughInterModuleCommunication", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMessage getAllAccountThroughInterModuleCommunication(@RequestBody RequestMessage requestMessage) throws MqttException {

        ResponseMessage responseMessage;
        String publishedMessageId;
        Object lock;

        RequestHelper requestHelper = new RequestHelper();
        lock = requestHelper.getLock("api/user/getAllAccountThroughInterModuleCommunication"
                ,WORKER_USER_REGISTRATION_MODULE_TOPIC, requestMessage);
        publishedMessageId = requestHelper.getPublishedMessageId();
        responseMessage = requestHelper.getResponse(lock,publishedMessageId);

        return responseMessage;

    }
}
